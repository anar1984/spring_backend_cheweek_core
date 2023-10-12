package com.cheweek.appcheweekspace.erp.controller.core;

import com.cheweek.appcheweekspace.erp.dto.core.CountryDTO;
import com.cheweek.appcheweekspace.erp.service.core.CountryReadService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/core/country")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CountryController {

    final CountryReadService countryReadService;
    @PostMapping("/read")
    public List<CountryDTO> getCountryList() {

        return countryReadService.getCountryList();
    }
}
