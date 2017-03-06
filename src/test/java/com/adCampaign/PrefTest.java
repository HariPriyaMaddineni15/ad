package com.adCampaign;

import static org.junit.Assert.*;
import org.junit.Test;
import com.adCampaign.AdCampaign;
import com.adCampaign.PrefDB;

public class PrefTest {

	@Test
	public void test_addCampaign_whenSamePartnerID() {
		AdCampaign camp = new AdCampaign("DB", 1, "Java, J2EE ");
		String str = PrefDB.addCampaign(camp);
		assertEquals(str,
				"This Partner_id already has one active Ad. Sorry, We cannot add another Ad .");
	}

	@Test
	public void test_addCampaign_whenDifferentPartnerID() {
		AdCampaign camp = new AdCampaign("xyz", 1, "Java, J2EE ");
		String str = PrefDB.addCampaign(camp);
		assertEquals(str, "Campaign added Successfully");

	}

	/*
	 * Test case for 1.POST - AdCampaign iscreated and then 2.GET - for partenr
	 * Id
	 */
	@Test
	public void test_getCampaignByPartnerId_afterUserCreatedAnAdCampaign() {
		PrefDB PrefDB = new PrefDB();
		AdCampaign newCampaign = new AdCampaign("abc", 100, "Java, J2EE ");
		PrefDB.addCampaign(newCampaign);
		AdCampaign camp = PrefDB.getCampaignByPartnerId("abc");
		assertEquals(newCampaign, camp);
	}

	/*
	 * While testing, technicallyy creation time and current time are same, so
	 * Negative Duration
	 */
	/*@Test
	public void test_getCampaignByPartnerId_afterUserCreatedAnAdCampaignWithNegativeDuration() {
		AdCampaign newCampaign = new AdCampaign("abc", -2, "Java, J2EE ");
		PrefDB.addCampaign(newCampaign);
		AdCampaign camp = PrefDB.getCampaignByPartnerId("abc");
		assertNull(camp);
	}*/
}
