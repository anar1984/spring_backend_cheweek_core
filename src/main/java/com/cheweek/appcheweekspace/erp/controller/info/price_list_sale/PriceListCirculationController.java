package com.cheweek.appcheweekspace.erp.controller.info.price_list_sale;

import com.cheweek.appcheweekspace.erp.dto.core.GetObjectById;
import com.cheweek.appcheweekspace.erp.dto.info.price_list_sale.PriceListCirculationCreateDTO;
import com.cheweek.appcheweekspace.erp.dto.info.price_list_sale.PriceListCirculationReadRequestDTO;
import com.cheweek.appcheweekspace.erp.dto.info.price_list_sale.PriceListCirculationReadResponseDTO;
import com.cheweek.appcheweekspace.erp.dto.info.price_list_sale.PriceListCirculationUpdateDTO;
import com.cheweek.appcheweekspace.erp.entity.info.price_list_sale.PriceListSale;
import com.cheweek.appcheweekspace.erp.service.info.price_list_sale.*;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/info/price/list/sale")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PriceListCirculationController {
    final PriceListCirculationCreateService priceListCicurlationCreateService;
    final PriceListCirculationUpdateService priceListCirculationUpdateService;
    final PriceListCirculationDeleteService priceListCirculationDeleteService;
    final PriceListCirculationReadService priceListCirculationReadService;
    final PriceListCirculationReadInfoService priceListCirculationReadInfoService;
    @PostMapping("/create")
    public ResponseEntity<?> insertCirculation(@RequestBody @Valid PriceListCirculationCreateDTO dto){
        priceListCicurlationCreateService.createCirculation(dto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody @Valid PriceListCirculationUpdateDTO priceListCirculationUpdateDTO) {
        priceListCirculationUpdateService.update(priceListCirculationUpdateDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @PostMapping("/delete")
    public ResponseEntity<?> update(@RequestBody @Valid GetObjectById getObjectById) {
        priceListCirculationDeleteService.delete(getObjectById);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @PostMapping("/read")
    public ResponseEntity<List<PriceListCirculationReadResponseDTO>> read(
            @RequestBody PriceListCirculationReadRequestDTO priceListCirculationReadRequestDTO) {
        return ResponseEntity.ok(priceListCirculationReadService.readApi(priceListCirculationReadRequestDTO));
    }

    @PostMapping("/read-info")
    public ResponseEntity<PriceListSale> readInfo(
            @RequestBody GetObjectById getObjectById) {
        return ResponseEntity.ok(priceListCirculationReadInfoService.readInfo(getObjectById));
    }
}
