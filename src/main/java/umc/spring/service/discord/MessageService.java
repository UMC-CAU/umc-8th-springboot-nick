package umc.spring.service.discord;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class MessageService {

    @Value("${discord.webhook-url}")
    String webhookUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public boolean sendMessage(String message) {
        try{
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);

            DiscordMessage discordMessage = new DiscordMessage(message);
            HttpEntity<DiscordMessage> request = new HttpEntity<>(discordMessage, httpHeaders);

            ResponseEntity<String> response = restTemplate.postForEntity(webhookUrl, request, String.class);

            return response.getStatusCode().is2xxSuccessful();
        } catch (Exception e) {
            log.error("failed to send message to Discord", e);
            return false;
        }
    }
}
