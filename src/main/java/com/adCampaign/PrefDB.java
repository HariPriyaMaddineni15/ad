package com.adCampaign;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PrefDB {
	static PrefDB prefDB = new PrefDB();
	private static Set<AdCampaign> campaignList = new HashSet<AdCampaign>();
	private long creationTime = 0;

	public long getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(long creationTime) {
		this.creationTime = creationTime;
	}

	static {
		campaignList.add(new AdCampaign("Backend", 1, "Java, J2EE "));
		campaignList.add(new AdCampaign("Front End", 2, "Angular, HTML, CSS "));
		campaignList.add(new AdCampaign("DB", 3, "SQL,Oracle,Mongo "));
		campaignList.add(new AdCampaign("WebServices", 4, "SOAP,REST "));
	}

	public static String addCampaign(AdCampaign adCampaign) {

		Iterator<AdCampaign> iterator = campaignList.iterator();
		while (iterator.hasNext()) {
			AdCampaign campObj = (AdCampaign) iterator.next();
			if ((campObj.getPartner_id().equals(adCampaign.getPartner_id()))) {
				return "This Partner_id already has one active Ad. Sorry, We cannot add another Ad .";
			}
		}
		campaignList.add(adCampaign);
		long creationTime = (System.currentTimeMillis()) / 1000;
		prefDB.setCreationTime(creationTime);
		return "Campaign added Successfully";

	}

	public static AdCampaign getCampaignByPartnerId(String partnerId) {
		AdCampaign adCampaign = new AdCampaign();
		long creationTime = prefDB.getCreationTime();
		Iterator<AdCampaign> iterator = campaignList.iterator();
		while (iterator.hasNext()) {
			AdCampaign campObj = (AdCampaign) iterator.next();
			if (campObj.getPartner_id().equals(partnerId)) {
				int dur = campObj.getDuration();
				long currentTime = (System.currentTimeMillis()) / 1000;
				if (currentTime <= (creationTime + dur)) {
					adCampaign = campObj;
					break;
				} else {
					adCampaign = null;
					break;
				}
				
			}
		}
		return adCampaign;
	}

	public static Set<AdCampaign> getCampaignList() {
		return campaignList;
	};

}
