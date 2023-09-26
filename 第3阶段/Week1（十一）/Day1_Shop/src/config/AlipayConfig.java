package config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "9021000128688145";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC3rOHPebzlDNcMSAD/B0EllG9WczK7f8vBH0B+OR6CH076V+G02bWFn55q+PX2Crp3vwEPYYwvgYV0IxwS6b+3jgwqzbA2IHYtjaxPg/3NpVlhpKH/UWFf+wKVE0t8xl67HjYwH5TeFiyx974EWMWwx40srwUFMCA5CifQXISi21ShPQMp6bhPhWhirusufOIw6BHq9Zmb4G/5yuSge712VMswyDFMFJz4FPSl/Ue7At/q29UgihyifVUGMhqrkavyKzM7YdRQ0E45qEdOO1RE0Uo10zupPvgxD810nw8cfsR7twR8/3uWX39TX246wBZbqxLeWBIH+oKltp3UpqcRAgMBAAECggEAF8+htnPhuQ/hEQaEmosmNuj3Rg3JFeWLVI3onnRpMBU+99VMvVU74wa+Ur/TowHhCoUIbiYHNmFkG5oxmYIUCIexrBreLSYoK9+h5u0FihNVcwMUvTSfmwG/Y/QMZTCSN0/DVpnBgsj9IlUrnQSlHDXCZ3iI/hMvGjXm02wrBbGQ8MFB9dgoo8HTU/kLkJSF8oqZAQlrkj2zboYC01xIgy9BG93p57f5fZERGEvDCXw8aMMhS9f4OOoiOMLfeL7HXYjBtTkmwTZTJZY9k2qcA5Czi3tz+0oY8xwArMOiuY144gLBTkUyF48IyLIPG+Zl3dV/+5bePaLt0MUI/ihKwQKBgQDqwl9asoD+0fMLLRGy0iymfHZP33S7zT2RHQ9AnTH+c1PMl2RUihZAVPtgGlKM8SLBVIL8bZTK67U4lKZV8YKhGaWDxX/Fbruqnh+LObYAiHFQnV+Tmec7iS0llLWckX97Dvs39UP6P9fBbmUoceWWAq+jnHgY6T+aXy0Sw37H/wKBgQDIS0Yxp1CqL6MGQUtGiKow4rXenvSsw0SwNh7qHlAjTnYEiBBIlJ5ivNDSdJ7RSiNv6cQNwxIfjEj7FzzvxDxbeBjAZSoDe3q3A950b9/7FS6V6fVcKmYSji8ydTxit9PS12lCIkspsSIBo5DwB9gJnwcSLWt9FQ18K+90yzYQ7wKBgEGwNcJJJHMpCBred49T5A6J0Qk0e5N5MHsEaJop4i1S0+Xxjq9hHCzQGq6fbu3lI1Z5cVV0zCejoMe+QHTX6Tdu17NxdfkmrPhm2mi4s0ae5yYpgu7oJ52vGqTjYZX32HX0kTLtPCIv7w0++KtCg31gLwlW5PwDeDqX2yLe9QC9AoGBALMPQHCRcLbEoYytALvM38GWXBrqpjhw1U5nA9ovQVtfAHjqnwwT+UiyHkmXQog+LFIXfVMESoZzpqb6zlpXZ9IqGo6doiK82CcXSV90yJsyA5S4NMaxjNEX1a/ZSSPDzZXXR918xQ8/sPQgIynDCWsIhYzFmCuZj5WrvYX/SZV3AoGBALLM3WQ1PWLrdOChhXNfjsb7EvyLuzonGICR5rSHXPVpkzZyTIBmHfcrVMboCbPLDrj+PTTVEgK6mYbgkiV2M1cw1GsZCeuxcJuMjSFjk8g1Q1NDgSO4p4ti78cML5stUMJP8IByufnf0sGCbt/pqRK4jN5yxUL9hytiE0afDcZL";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAu3baKULTYrImKE09NYw5clkScnZIGs7VQJStNzRj2yWdaA1b94BqS0XoIrM1JcZqbdNlK2iu44WQyCbCpf1qWszs6pn/XaihfZbUqsk8dFfnzvWUtWtBlqldlAsC50rciB2YaSwhPjiTXdtCRbZS4xUL48X2kAVW3XdCiN2LNlUH9de+avglBTojBXe5AOMwfvW4NO08Zb9gwWfm1Yej11CSscnDMNzCr7RP2pT98w1CGv9dxcAZE/dzWAOIVwF+mUhiOeZZXzVFXiyl5Xcg95o21Pa5/vesY7N5/B/g+MPYmo56d5k6ihZCgEVHb477EoXhnGf906DznqZrGN53YQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi-sandbox.dl.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

