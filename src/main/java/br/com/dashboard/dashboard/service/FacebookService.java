package br.com.dashboard.dashboard.service;


import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.AdAccount;
import org.springframework.beans.factory.annotation.Value;

public class FacebookService {

    @Value("${facebook.access.token}")
    private String accessToken;

    @Value("${facebook.app.id}")
    private String appId;

    @Value("${facebook.app.secret}")
    private String appSecret;

    public void fetchCampaigns(String accountId) {
        APIContext apiContext = new APIContext(accessToken);
        AdAccount account = new AdAccount(accountId, apiContext);

        try {
            account.getCampaigns().requestAllFields().execute().forEach(campaign -> {
                System.out.println(campaign.getFieldName());
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
