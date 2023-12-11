package sisal.services.flightMs.api.response;

import lombok.Getter;
import lombok.Setter;
import sisal.services.flightMs.dto.ResultDTO;


@Setter
@Getter
public class ResultResponse {
    private ResultDTO resultDTO;

    public ResultResponse(ResultDTO resultDTO) {
        this.resultDTO = resultDTO;
    }
}
