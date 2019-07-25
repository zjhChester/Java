package img;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONObject;

import com.baidu.aip.face.AipFace;
import com.baidu.aip.face.MatchRequest;

public class Sample {
    //设置APPID/AK/SK
    public static final String APP_ID = "15091052";
    public static final String API_KEY = "3P57ZHaENzGM7nXrqyR7RhWw";
    public static final String SECRET_KEY = "Rehegym1TReXHOI2MDX4g1HnjLxjcw9j";

    public static void main(String[] args) {
        // 初始化一个AipFace
        AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("127.0.0.1", 9999);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
//        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        // 调用接口
        String path = "shou.jpg";
        JSONObject res = client.detect(path, path, new HashMap<String, String>());
        System.out.println(res.toString(2));
        
    }
    public void faceCheck(AipFace client) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("face_field", "age");
        options.put("max_face_num", "2");
        options.put("face_type", "LIVE");
        
        String image = "取决于image_type参数，传入BASE64字符串或URL字符串或FACE_TOKEN字符串";
        String imageType = "BASE64";
        
        // 人脸检测
        JSONObject res = client.detect(image, imageType, options);
        System.out.println(res.toString(2));

    }
    
    public void facesSelect(AipFace client) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("quality_control", "NORMAL");
        options.put("liveness_control", "LOW");
        options.put("user_id", "233451");
        options.put("max_user_num", "3");
        
        String image = "取决于image_type参数，传入BASE64字符串或URL字符串或FACE_TOKEN字符串";
        String imageType = "BASE64";
        String groupIdList = "3,2";
        
        // 人脸搜索
        JSONObject res = client.search(image, imageType, groupIdList, options);
        System.out.println(res.toString(2));

    }
    public void faceRegist(AipFace client) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("user_info", "user's info");
        options.put("quality_control", "NORMAL");
        options.put("liveness_control", "LOW");
        
        String image = "取决于image_type参数，传入BASE64字符串或URL字符串或FACE_TOKEN字符串";
        String imageType = "BASE64";
        String groupId = "group1";
        String userId = "user1";
        
        // 人脸注册
        JSONObject res = client.addUser(image, imageType, groupId, userId, options);
        System.out.println(res.toString(2));
    }
    
    public void faceUpdate(AipFace client) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("user_info", "user's info");
        options.put("quality_control", "NORMAL");
        options.put("liveness_control", "LOW");
        
        String image = "取决于image_type参数，传入BASE64字符串或URL字符串或FACE_TOKEN字符串";
        String imageType = "BASE64";
        String groupId = "group1";
        String userId = "user1";
        
        // 人脸更新
        JSONObject res = client.updateUser(image, imageType, groupId, userId, options);
        System.out.println(res.toString(2));

    }
    
    public void faceDelete(AipFace client) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        
        String userId = "user1";
        String groupId = "group1";
        String faceToken = "face_token_23123";
        
        // 人脸删除
        JSONObject res = client.faceDelete(userId, groupId, faceToken, options);
        System.out.println(res.toString(2));

    }
    public void selectUserInfo(AipFace client) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        
        String userId = "user1";
        String groupId = "group1";
        
        // 用户信息查询
        JSONObject res = client.getUser(userId, groupId, options);
        System.out.println(res.toString(2));

    }
    public void getFaceList(AipFace client) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        
        String userId = "user1";
        String groupId = "group1";
        
        // 获取用户人脸列表
        JSONObject res = client.faceGetlist(userId, groupId, options);
        System.out.println(res.toString(2));

    }
    
    public void getUserList(AipFace client) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("start", "0");
        options.put("length", "50");
        
        String groupId = "group1";
        
        // 获取用户列表
        JSONObject res = client.getGroupUsers(groupId, options);
        System.out.println(res.toString(2));

    }
    public void copyUserGroupToAnotherUserGroup(AipFace client) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("src_group_id", "11111");
        options.put("dst_group_id", "222222");
        
        String userId = "user1";
        
        // 复制用户
        JSONObject res = client.userCopy(userId, options);
        System.out.println(res.toString(2));

    }
    public void deleteUser(AipFace client) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        
        String groupId = "group1";
        String userId = "user1";
        
        // 删除用户
        JSONObject res = client.deleteUser(groupId, userId, options);
        System.out.println(res.toString(2));

    }
    public void createUserGroup(AipFace client) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        
        String groupId = "group1";
        
        // 创建用户组
        JSONObject res = client.groupAdd(groupId, options);
        System.out.println(res.toString(2));

    }

    public void deleteUserGroup(AipFace client) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        
        String groupId = "group1";
        
        // 删除用户组
        JSONObject res = client.groupDelete(groupId, options);
        System.out.println(res.toString(2));

    }
    public void selectUserGroup(AipFace client) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("start", "0");
        options.put("length", "50");
        // 组列表查询
        JSONObject res = client.getGroupList(options);
        System.out.println(res.toString(2));

    }
    
    public void identityVerification(AipFace client) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("quality_control", "NORMAL");
        options.put("liveness_control", "LOW");
        
        String image = "取决于image_type参数，传入BASE64字符串或URL字符串或FACE_TOKEN字符串";
        String imageType = "BASE64";
        String idCardNumber = "110233112299822211";
        String name = "张三";
        
        // 身份验证
        JSONObject res = client.personVerify(image, imageType, idCardNumber, name, options);
        System.out.println(res.toString(2));

    }
    
    public void faceCompare(AipFace client) {
        String image1 = "base64_1";
        String image2 = "base64_2";

        // image1/image2也可以为url或facetoken, 相应的imageType参数需要与之对应。
        MatchRequest req1 = new MatchRequest(image1, "BASE64");
        MatchRequest req2 = new MatchRequest(image2, "BASE64");
        ArrayList<MatchRequest> requests = new ArrayList<MatchRequest>();
        requests.add(req1);
        requests.add(req2);

        JSONObject res = client.match(requests);
        System.out.println(res.toString(2));

    }
}