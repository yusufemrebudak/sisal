package sisal.services.flightMs.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.jetbrains.annotations.NotNull;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Represents result of command service")
public class ResultDTO  {

    @Schema(name = "result code")
    @NotNull
    private String resultCode;

    @Schema(name = "result message")

    @NotNull
    private String resultMsg;

    @Schema(name = "extra info for general usage")
    private String extraInfo;

    private String state;

}
