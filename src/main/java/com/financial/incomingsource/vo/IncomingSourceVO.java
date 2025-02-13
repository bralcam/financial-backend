package com.financial.incomingsource.vo;

import com.financial.incomingsource.enums.IncomingSourceType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class IncomingSourceVO {

    @ApiModelProperty(notes="Incoming source Id")
    private Integer Id;

    @ApiModelProperty(notes="Incoming source name")
    private String name;

    @ApiModelProperty(notes="Incoming source description")
    private String description;

    @ApiModelProperty(notes="Incoming source type")
    private IncomingSourceType type;

}
