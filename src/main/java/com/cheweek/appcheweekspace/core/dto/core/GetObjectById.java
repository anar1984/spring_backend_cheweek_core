package com.cheweek.appcheweekspace.core.dto.core;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetObjectById {
    @NotBlank(message = "chw_20021")
    String id;
}
