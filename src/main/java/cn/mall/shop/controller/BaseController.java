package cn.mall.shop.controller;

import cn.mall.shop.data.ResultVO;

public class BaseController {

    public ResultVO getFailure() {
        return new ResultVO().doFailure();
    }

    public ResultVO getSuccess() {
        return new ResultVO().doSuccess();
    }

}
