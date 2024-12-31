package com.dbc.coffeePlaces.persistence.profiles.controllers;

import com.dbc.coffeePlaces.persistence.profiles.entities.Profile;
import com.dbc.coffeePlaces.persistence.profiles.services.ProfileService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profiles")
public class ProfileController {
    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping
    public ResponseEntity<Profile> create(@RequestBody Profile profile){
        return ResponseEntity.ok(profileService.create(profile));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profile> findOne(@RequestParam Integer id){
        return ResponseEntity.of(profileService.findOne(id));
    }

    @GetMapping
    public ResponseEntity<Page<Profile>> findAll(@RequestParam(defaultValue = "0") int page,
                                                 @RequestParam(defaultValue = "5") int elements){
        return ResponseEntity.ok(profileService.findAll(page, elements));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Profile> update(@RequestParam() int id,
                                          @RequestBody Profile profile){
        return ResponseEntity.of(profileService.update(id, profile));
    }

    @DeleteMapping("/{id}")
    public int delete(@RequestParam() int id){
        profileService.delete(id);
        return id;
    }
}
