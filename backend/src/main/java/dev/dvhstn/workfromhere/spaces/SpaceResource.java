package dev.dvhstn.workfromhere.spaces;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpaceResource {
    private Long id;
    private String name;
    private String description;
    private SpaceTypeResource type;
    private boolean isWifiAvailable;
    private String wifiPassword;
    private Integer wifiSpeed;
}
