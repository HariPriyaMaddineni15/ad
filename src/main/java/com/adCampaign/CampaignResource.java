package com.adCampaign;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/ad")
public class CampaignResource {
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Set<AdCampaign> getCampaignList() {
		return PrefDB.getCampaignList();
	}
	@POST
	public String addCampaign(AdCampaign adCampaign) {
		return PrefDB.addCampaign(adCampaign);
	}
	
	@GET
	@Path("/{partner_id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public AdCampaign getCampaignByPartnerId(@PathParam("partner_id") String partnerId) {
		return PrefDB.getCampaignByPartnerId(partnerId);
	}
}
