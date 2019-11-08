package cn.mall.shop.data;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.configurationprocessor.json.JSONObject;

@Setter
@Getter
public class ResultVO {

    public boolean result;
    public JSONObject data;
    public String message;

    public ResultVO doFailure() {
        this.result = false;
        return this;
    }

    public ResultVO doSuccess() {
        this.result = true;
        return this;
    }

}
