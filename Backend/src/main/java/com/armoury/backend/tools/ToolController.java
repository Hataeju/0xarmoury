<<<<<<< Updated upstream
package com.armoury.backend.tools;

import com.armoury.backend.config.BaseException;
import com.armoury.backend.config.BaseResponse;
import com.armoury.backend.tools.model.GetToolRes;
import com.armoury.backend.user.model.GetUserRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tools")
public class ToolController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private final ToolProvider toolProvider;

    public ToolController(ToolProvider toolProvider){
        this.toolProvider = toolProvider;
    }

    @ResponseBody
    @GetMapping("/{toolIdx}")
    public BaseResponse<GetToolRes> getToolByIdx (@PathVariable("toolIdx")int toolIdx){
        try{
            GetToolRes toolRes = toolProvider.getToolByIdx(toolIdx);
            return new BaseResponse<>(toolRes);
        } catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }
    }

}
=======
//package com.armoury.backend.tools;
//
//import com.armoury.backend.config.BaseException;
//import com.armoury.backend.config.BaseResponse;
//import com.armoury.backend.user.model.GetUserRes;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/tools")
//public class ToolController {
//    final Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    @Autowired
//    private final ToolProvider toolProvider;
//
//    public ToolController(ToolProvider toolProvider){
//        this.toolProvider = toolProvider;
//    }
//
////    @ResponseBody
////    @GetMapping("/{toolIdx}")
////    public BaseResponse<String> getToolByIdx (@PathVariable("toolIdx")int toolIdx){
////        try{
////            String result = toolProvider.getToolByIdx(toolIdx);
////            return new BaseResponse<>(result);
////        } catch(BaseException exception){
////            return new BaseResponse<>((exception.getStatus()));
////        }
////    }
////}
>>>>>>> Stashed changes
