package in.cybergen.blog;

import com.googlecode.cqengine.attribute.Attribute;
import com.googlecode.cqengine.attribute.SimpleAttribute;

/**
 * Created by vishnu on 24/10/14.
 */
public class Campaign {
    private String campaign_name;
    private String campaign_id;
    private String segments;
    private String country;
    private String status;
    private String strictRetargeting;
    @Override
    public String toString(){
        StringBuilder string = new StringBuilder();
        string
                .append("campaign_id ").append(campaign_id).append("\t")
                .append("status ").append(status).append("\t")
                .append("campaign_name ").append(campaign_name).append("\t")
                .append("segments ").append(segments).append("\t")
                .append("country ").append(country).append("\t")
                .append("strictRetargeting ").append(strictRetargeting).append("\t")
        ;
        return string.toString();
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public Campaign(String name, String id, String segments, String country,String strictRetargeting,String status) {
        this.campaign_name = name;
        this.campaign_id = id;
        this.segments = segments;
        this.country = country;
        this.status = status;
        this.strictRetargeting=strictRetargeting;
    }

public static final Attribute<Campaign , String> CAMPAIGN_NAME = new SimpleAttribute<Campaign, String>() {
    @Override
    public String getValue(Campaign campaign) {
        return campaign.campaign_name;
    }
};

    public static final Attribute<Campaign , String> STATUS = new SimpleAttribute<Campaign, String>() {
        @Override
        public String getValue(Campaign campaign) {
            return campaign.status;
        }
    };
    public static final Attribute<Campaign,String> SEGMENTS = new SimpleAttribute<Campaign, String>() {
        @Override
        public String getValue(Campaign campaign) {
            return campaign.segments;
        }
    };
    public static final Attribute<Campaign,String> COUNTRY = new SimpleAttribute<Campaign, String>() {
        @Override
        public String getValue(Campaign campaign) {
            return campaign.country;
        }
    };
    public static final Attribute<Campaign,String> STRICT_RETARGETING = new SimpleAttribute<Campaign, String>() {
        @Override
        public String getValue(Campaign campaign) {
            return campaign.strictRetargeting;
        }
    };

    public String getStrictRetargeting() {
        return strictRetargeting;
    }

    public void setStrictRetargeting(String strictRetargeting) {
        this.strictRetargeting = strictRetargeting;
    }
    public String getCampaign_name() {
        return campaign_name;
    }

    public void setCampaign_name(String campaign_name) {
        this.campaign_name = campaign_name;
    }

    public String getCampaign_id() {
        return campaign_id;
    }

    public void setCampaign_id(String campaign_id) {
        this.campaign_id = campaign_id;
    }

    public String getSegments() {
        return segments;
    }

    public void setSegments(String segments) {
        this.segments = segments;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
