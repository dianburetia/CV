package com.example.demo.controllers;

import com.example.demo.model.Device;
import com.example.demo.repository.DeviceRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
    @RestController
    @RequestMapping("/devices")
    public class DeviceController {
        private final DeviceRepository deviceRepository;
        public DeviceController(DeviceRepository deviceRepository) {
            this.deviceRepository = deviceRepository;
        }
        @DeleteMapping("/{id}")
        @CrossOrigin(origins = "http://localhost:3000",methods = {RequestMethod.DELETE}, allowedHeaders = {"*"})
        public ResponseEntity deleteAccount(@PathVariable Long id) {
            deviceRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        @CrossOrigin("*")
        @GetMapping
        @RequestMapping("/devicess")
        public long[] getDevices() {
            List<Device> devices= deviceRepository.findAll();
            long[] ids=new long[devices.size()];int c=0;
            for(Device device:devices){
                ids[c++]=device.getId();
            }
            return ids;
        }
        @CrossOrigin("*")
        @GetMapping
        @RequestMapping("/{id}")
        public List<Device> getDevicesId(@PathVariable long id) {
            List<Device> devices= deviceRepository.findAll();
            List<Device> devicesret=new ArrayList<>();
            for(Device device:devices){
               if(device.getAccountId()==id)devicesret.add(device);
            }
            return devicesret;
        }
        @GetMapping
        @CrossOrigin("*")
        public List<Device> getDevicesIds() {
            return deviceRepository.findAll();
        }
        @PostMapping
        @CrossOrigin("*")
        public void createDevice(@RequestBody Device device) {
            System.out.println(device.getAccountId());
            deviceRepository.save(device);
        }
        @PutMapping("/{id}")
        @CrossOrigin("*")
        public ResponseEntity updateAccount(@PathVariable Long id, @RequestBody Device device) {
            Device currentDevice = new Device();
            currentDevice.setId(id);
            currentDevice.setDescriptions(device.getDescriptions());
            currentDevice.setAddress(device.getAddress());
            currentDevice.setMaximumConsumption(device.getMaximumConsumption());
            currentDevice.setAccountId(device.getAccountId());
            deviceRepository.save(currentDevice);

            return ResponseEntity.ok(currentDevice);
        }

    }


