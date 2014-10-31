package in.cybergen.blog;
import com.googlecode.cqengine.CQEngine;
import com.googlecode.cqengine.IndexedCollection;
import com.googlecode.cqengine.index.hash.HashIndex;
import com.googlecode.cqengine.index.suffix.SuffixTreeIndex;
import com.googlecode.cqengine.query.Query;
import com.googlecode.cqengine.query.*;
import java.util.ArrayList;
import java.util.List;

import static com.googlecode.cqengine.query.QueryFactory.*;

/**
 * Created by vishnu on 24/10/14.
 */
public class IndexedCollections {
    public static IndexedCollection indexedCampaign = CQEngine.newInstance();
    public static void initialize(){
        indexedCampaign.addIndex(HashIndex.onAttribute(Campaign.CAMPAIGN_NAME));
        indexedCampaign.addIndex(SuffixTreeIndex.onAttribute(Campaign.COUNTRY));
        indexedCampaign.addIndex(SuffixTreeIndex.onAttribute(Campaign.SEGMENTS));
        indexedCampaign.addIndex(HashIndex.onAttribute(Campaign.STRICT_RETARGETING));
        indexedCampaign.addIndex(HashIndex.onAttribute(Campaign.STATUS));
    }
    public static void addCampaign(Campaign campaign){
        indexedCampaign.add(campaign);
    }
    public static List<Campaign> campaignsFor(String country,List<String> segments){
        List<Query<Campaign>> campaignQueries = new ArrayList<Query<Campaign>>();
        List<Campaign> campaigns = new ArrayList<Campaign>();
        campaignQueries.add(equal(Campaign.STATUS, "1"));
        campaignQueries.add(contains(Campaign.COUNTRY, country));

        for (String segment : segments) {
            campaignQueries.add(or(contains(Campaign.SEGMENTS, segment), not(equal(Campaign.STRICT_RETARGETING, "1"))));
        }


        Query<Campaign> finalQuery = and(campaignQueries);

        for(Object obj :indexedCampaign.retrieve(finalQuery)){
            campaigns.add((Campaign) obj);
        }
        return campaigns;
    }

    static Query<Campaign> orLogicCampaignAddQueries(List<Query<Campaign>> listQuery){
        if (listQuery.size() == 1) {
            return listQuery.get(0);
        } else if (listQuery.size() > 1) {
            return or(listQuery);
        }
        return null;
    }
}
