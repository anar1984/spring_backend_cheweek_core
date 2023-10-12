package com.cheweek.appcheweekspace.erp.controller.core;

import com.cheweek.appcheweekspace.erp.dto.core.CityDTO;
import com.cheweek.appcheweekspace.erp.service.core.CityReadService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("/core/city")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CityController {

    final CityReadService cityReadService;

    @PostMapping("/read")
    public List<CityDTO> getCityList(@Valid @RequestBody CityDTO dto) {
        return cityReadService.getCityByCountry(dto);
    }
}
