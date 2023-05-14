package com.ing.rankup_b.prize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("prizeApi")
@CrossOrigin(origins = {"http://localhost:8100", "http://localhost:8200", "http://localhost:4200"})

public class PrizeController {
    
    @Autowired
    private PrizeService service;

    public PrizeController(PrizeService service) {
        this.service = service;
    }

    @GetMapping(path = "user")
    public ResponseEntity user(@RequestParam("id_team") int id_team, @RequestParam("id_user") int id_user) {
        return ResponseEntity.status(HttpStatus.OK).body(
                //this.service.getUserPrize(id_team, id_user)
                ""
        );
    }

}
