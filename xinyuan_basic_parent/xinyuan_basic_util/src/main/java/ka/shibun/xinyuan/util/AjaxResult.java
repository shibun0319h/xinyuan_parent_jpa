/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: AjaxResult
 * Author:   shibun
 * Date:     2019/2/23 22:00
 * Description: ajax返回值
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ka.shibun.xinyuan.util;

/**
 *
 * ajax返回值
 *
 * @author shibun
 * @create 2019/2/23
 * @since 1.0.0
 */
public class AjaxResult {

    private boolean success = true;

    private String msg = "操作成功";

    private Object obj ;

    public static AjaxResult me(){
        return new AjaxResult();
    }

    public boolean isSuccess() {
        return success;
    }

    public AjaxResult setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public AjaxResult setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getObj() {
        return obj;
    }

    public AjaxResult setObj(Object obj) {
        this.obj = obj;
        return this;
    }
}