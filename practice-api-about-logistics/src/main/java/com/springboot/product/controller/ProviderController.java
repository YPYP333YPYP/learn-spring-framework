package com.springboot.product.controller;


import com.springboot.product.data.dto.ProviderDto;
import com.springboot.product.data.dto.ProviderResponseDto;
import com.springboot.product.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/provider")
public class ProviderController {

    private final ProviderService providerService;

    @Autowired
    public ProviderController(ProviderService providerService){
        this.providerService = providerService;
    }

    @GetMapping()
    public ResponseEntity<ProviderResponseDto> getProvider(Long id){
        ProviderResponseDto providerResponseDto = providerService.getProvider(id);

        return ResponseEntity.status(HttpStatus.OK).body(providerResponseDto);
    }

    @PostMapping()
    public ResponseEntity<ProviderResponseDto> createProvider(@RequestBody ProviderDto providerDto){
        ProviderResponseDto providerResponseDto = providerService.saveProvider(providerDto);

        return ResponseEntity.status(HttpStatus.OK).body(providerResponseDto);

    }

    @DeleteMapping()
    public ResponseEntity<String> deleteProduct(Long id) throws Exception{
        providerService.deleteProvider(id);

        return ResponseEntity.status(HttpStatus.OK).body("삭제 완료");
    }


}
