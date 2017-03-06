# ad
AdCampaign Service
Create HTTP POST 

URL - http://<localhost>/ad/ad, RequestMethod : POST
 
Request JSON format:
Sample data:

{
 
"partner_id": "abc",
"duration": 1, 
"ad_content": "alphabet...content"

}

Get one AdCampaign

URL - http://<localhost>/ad/{partner_id}, RequestMethod : GET
First Create an AdCampaign and check with the GET request for a specified partner.

UnitTesting is done.

Return the list of all AdCamapigns

URL - http://<localhost>/ad/ad, RequestMethod : GET

Deployment:

You can deploy the project onto a local host and check the response through any rest client like Postman.



