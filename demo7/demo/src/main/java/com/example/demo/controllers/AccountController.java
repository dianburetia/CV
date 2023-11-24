package com.example.demo.controllers;

import com.example.demo.RoleA;
import com.example.demo.model.Account;
import com.example.demo.model.Device;
import com.example.demo.repositories.AccountRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
@RestController
@RequestMapping("/accounts")
@CrossOrigin(origins="*")
public class AccountController {
    private final AccountRepository accountRepository;
    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    @CrossOrigin(origins="*")
    @GetMapping
    public List<Account> getClients() {
        return accountRepository.findAll();
    }
    @CrossOrigin(origins="*")
    @GetMapping("/{name}")
    public Account getClientByName(@PathVariable String name) {
        List<Account> accountList=accountRepository.findAll();
        for(Account account:accountList){
            if(account.getName().equals(name))return account;
        }
        return null;
    }
    @CrossOrigin(origins="*")
    @GetMapping("/accounts")
    public long[] getClientsIds() {
        List<Account> accounts= accountRepository.findAll();
        long[] ids=new long[accounts.size()];
        int c=0;
        for(Account account:accounts){
            ids[c++]=account.getId();
        }
        return ids;
    }
    @CrossOrigin(origins="*")
    @PostMapping
    public void  createClient(@RequestBody Account account)  {
        //System.out.println(account.getDevicesIds());
        /*
         try {
            // URL of Service B's endpoint
            String serviceBUrl = "http://service-b-host:service-b-port/saveData";

            // Create a URL object
            URL url = new URL(serviceBUrl);

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the request method to POST
            connection.setRequestMethod("POST");

            // Set request headers (optional)
            connection.setRequestProperty("Content-Type", "application/json");

            // Enable input and output streams
            connection.setDoInput(true);
            connection.setDoOutput(true);

            // Create the data to send (you can use a JSON library to serialize data)
            String dataToSend = "{ \"key\": \"value\" }";

            // Write the data to the output stream
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = dataToSend.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            // Get the HTTP response code
            int responseCode = connection.getResponseCode();
            System.out.println("HTTP Response Code: " + responseCode);

            // Close the connection
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
         */
         accountRepository.save(account);
    }
    @CrossOrigin(origins="*")
    @PutMapping("/devices/{id}")
    public ResponseEntity updateAccountDevice(@PathVariable Long id, @RequestBody Device device) {
        String serviceAUrl = "http://172.19.0.4:8090/devices";
        System.out.println(device.getAccountId());
        // Create a RestTemplate to make the POST request
        //try {
            RestTemplate restTemplate = new RestTemplate();
            // Send the device to Microservice A
            ResponseEntity<String> response = restTemplate.postForEntity(serviceAUrl, device, String.class);
            // Check the response
            if (response.getStatusCode().is2xxSuccessful()) {
                System.out.println("Device sent and saved successfully in Microservice A " + device.getAccountId());
            } else {
                System.err.println("Failed to send the device to Microservice A");
            }
        //}
//        catch (RestClientException e) {
//            if (e.getCause() instanceof ConnectException) {
//                // handle connect exception
//                return ResponseEntity.status(HttpStatus.CONFLICT).body("Could not connect");
//            }
//            throw e; // rethrow if not a ConnectException
//        }
         return ResponseEntity.ok(device);

    }
    @PutMapping("/{id}")
    public ResponseEntity updateAccount(@PathVariable Long id, @RequestBody Account account) {
        Account currentAccount = accountRepository.findById(id).orElseThrow(RuntimeException::new);
        currentAccount.setId(id);
        currentAccount.setName(account.getName());
        currentAccount.setRole(account.getRole());
        currentAccount.setPassword(account.getPassword());
        currentAccount.setDevicesIds(account.getDevicesIds());
        accountRepository.save(currentAccount);
        System.out.println(account.getDevicesIds());
        /*
         try {
            // URL of Service B's endpoint
            String serviceBUrl = "http://service-b-host:service-b-port/saveData";

            // Create a URL object
            URL url = new URL(serviceBUrl);

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the request method to POST
            connection.setRequestMethod("POST");

            // Set request headers (optional)
            connection.setRequestProperty("Content-Type", "application/json");

            // Enable input and output streams
            connection.setDoInput(true);
            connection.setDoOutput(true);

            // Create the data to send (you can use a JSON library to serialize data)
            String dataToSend = "{ \"key\": \"value\" }";

            // Write the data to the output stream
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = dataToSend.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            // Get the HTTP response code
            int responseCode = connection.getResponseCode();
            System.out.println("HTTP Response Code: " + responseCode);

            // Close the connection
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
         */
        return ResponseEntity.ok(currentAccount);
    }
    @CrossOrigin(origins = "http://localhost:3000",methods = {RequestMethod.DELETE}, allowedHeaders = {"*"})
    @DeleteMapping("/{id}")
    public ResponseEntity deleteAccount(@PathVariable Long id) {
        accountRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
