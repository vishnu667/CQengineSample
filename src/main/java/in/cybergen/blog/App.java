package in.cybergen.blog;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Start");
        IndexedCollections.initialize();

        IndexedCollections.addCampaign(new Campaign("c1","1","1,2","UK","1","1"));
        IndexedCollections.addCampaign(new Campaign("c2","2,1","","IN,US","1","1"));
        IndexedCollections.addCampaign(new Campaign("c4","4","1","IN","0","1"));
        IndexedCollections.addCampaign(new Campaign("c5","5","3","US","1","1"));
        IndexedCollections.addCampaign(new Campaign("c6","5","3","","1","1"));
        IndexedCollections.addCampaign(new Campaign("c7","5","3","","1","1"));
        List<String> segments = new ArrayList<String>();
        segments.add("1");
        for(Campaign campaign : IndexedCollections.campaignsFor("",segments)){
            System.out.println(campaign.toString());
        }
        System.out.println("END");
    }
}
