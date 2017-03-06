package com.adCampaign;
import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

public class CampaignResourceTest {

		private PrefDB prefDB = new PrefDB();

	@Test
	public void test_getCampaignList() {
		Set<AdCampaign> campaignList = prefDB.getCampaignList();
		assertTrue(campaignList.size() > 0);
	}
	@Test
	public void test_addCampaign(){
		AdCampaign adCampaign = new AdCampaign("1234", 12, "content");
		String str = PrefDB.addCampaign(adCampaign);
		assertEquals(str, "Campaign added Successfully");
	}
	
}
