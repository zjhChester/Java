package img;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONObject;

import com.baidu.aip.face.AipFace;
import com.baidu.aip.face.MatchRequest;

public class Sample {
    //����APPID/AK/SK
    public static final String APP_ID = "15091052";
    public static final String API_KEY = "3P57ZHaENzGM7nXrqyR7RhWw";
    public static final String SECRET_KEY = "Rehegym1TReXHOI2MDX4g1HnjLxjcw9j";

    public static void main(String[] args) {
        // ��ʼ��һ��AipFace
        AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);

        // ��ѡ�������������Ӳ���
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // ��ѡ�����ô����������ַ, http��socket��ѡһ�����߾�������
//        client.setHttpProxy("proxy_host", proxy_port);  // ����http����
//        client.setSocketProxy("127.0.0.1", 9999);  // ����socket����

        // ��ѡ������log4j��־�����ʽ���������ã���ʹ��Ĭ������
        // Ҳ����ֱ��ͨ��jvm�����������ô˻�������
//        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        // ���ýӿ�
        String path = "shou.jpg";
        JSONObject res = client.detect(path, path, new HashMap<String, String>());
        System.out.println(res.toString(2));
        
    }
    public void faceCheck(AipFace client) {
        // �����ѡ�������ýӿ�
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("face_field", "age");
        options.put("max_face_num", "2");
        options.put("face_type", "LIVE");
        
        String image = "ȡ����image_type����������BASE64�ַ�����URL�ַ�����FACE_TOKEN�ַ���";
        String imageType = "BASE64";
        
        // �������
        JSONObject res = client.detect(image, imageType, options);
        System.out.println(res.toString(2));

    }
    
    public void facesSelect(AipFace client) {
        // �����ѡ�������ýӿ�
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("quality_control", "NORMAL");
        options.put("liveness_control", "LOW");
        options.put("user_id", "233451");
        options.put("max_user_num", "3");
        
        String image = "ȡ����image_type����������BASE64�ַ�����URL�ַ�����FACE_TOKEN�ַ���";
        String imageType = "BASE64";
        String groupIdList = "3,2";
        
        // ��������
        JSONObject res = client.search(image, imageType, groupIdList, options);
        System.out.println(res.toString(2));

    }
    public void faceRegist(AipFace client) {
        // �����ѡ�������ýӿ�
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("user_info", "user's info");
        options.put("quality_control", "NORMAL");
        options.put("liveness_control", "LOW");
        
        String image = "ȡ����image_type����������BASE64�ַ�����URL�ַ�����FACE_TOKEN�ַ���";
        String imageType = "BASE64";
        String groupId = "group1";
        String userId = "user1";
        
        // ����ע��
        JSONObject res = client.addUser(image, imageType, groupId, userId, options);
        System.out.println(res.toString(2));
    }
    
    public void faceUpdate(AipFace client) {
        // �����ѡ�������ýӿ�
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("user_info", "user's info");
        options.put("quality_control", "NORMAL");
        options.put("liveness_control", "LOW");
        
        String image = "ȡ����image_type����������BASE64�ַ�����URL�ַ�����FACE_TOKEN�ַ���";
        String imageType = "BASE64";
        String groupId = "group1";
        String userId = "user1";
        
        // ��������
        JSONObject res = client.updateUser(image, imageType, groupId, userId, options);
        System.out.println(res.toString(2));

    }
    
    public void faceDelete(AipFace client) {
        // �����ѡ�������ýӿ�
        HashMap<String, String> options = new HashMap<String, String>();
        
        String userId = "user1";
        String groupId = "group1";
        String faceToken = "face_token_23123";
        
        // ����ɾ��
        JSONObject res = client.faceDelete(userId, groupId, faceToken, options);
        System.out.println(res.toString(2));

    }
    public void selectUserInfo(AipFace client) {
        // �����ѡ�������ýӿ�
        HashMap<String, String> options = new HashMap<String, String>();
        
        String userId = "user1";
        String groupId = "group1";
        
        // �û���Ϣ��ѯ
        JSONObject res = client.getUser(userId, groupId, options);
        System.out.println(res.toString(2));

    }
    public void getFaceList(AipFace client) {
        // �����ѡ�������ýӿ�
        HashMap<String, String> options = new HashMap<String, String>();
        
        String userId = "user1";
        String groupId = "group1";
        
        // ��ȡ�û������б�
        JSONObject res = client.faceGetlist(userId, groupId, options);
        System.out.println(res.toString(2));

    }
    
    public void getUserList(AipFace client) {
        // �����ѡ�������ýӿ�
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("start", "0");
        options.put("length", "50");
        
        String groupId = "group1";
        
        // ��ȡ�û��б�
        JSONObject res = client.getGroupUsers(groupId, options);
        System.out.println(res.toString(2));

    }
    public void copyUserGroupToAnotherUserGroup(AipFace client) {
        // �����ѡ�������ýӿ�
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("src_group_id", "11111");
        options.put("dst_group_id", "222222");
        
        String userId = "user1";
        
        // �����û�
        JSONObject res = client.userCopy(userId, options);
        System.out.println(res.toString(2));

    }
    public void deleteUser(AipFace client) {
        // �����ѡ�������ýӿ�
        HashMap<String, String> options = new HashMap<String, String>();
        
        String groupId = "group1";
        String userId = "user1";
        
        // ɾ���û�
        JSONObject res = client.deleteUser(groupId, userId, options);
        System.out.println(res.toString(2));

    }
    public void createUserGroup(AipFace client) {
        // �����ѡ�������ýӿ�
        HashMap<String, String> options = new HashMap<String, String>();
        
        String groupId = "group1";
        
        // �����û���
        JSONObject res = client.groupAdd(groupId, options);
        System.out.println(res.toString(2));

    }

    public void deleteUserGroup(AipFace client) {
        // �����ѡ�������ýӿ�
        HashMap<String, String> options = new HashMap<String, String>();
        
        String groupId = "group1";
        
        // ɾ���û���
        JSONObject res = client.groupDelete(groupId, options);
        System.out.println(res.toString(2));

    }
    public void selectUserGroup(AipFace client) {
        // �����ѡ�������ýӿ�
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("start", "0");
        options.put("length", "50");
        // ���б��ѯ
        JSONObject res = client.getGroupList(options);
        System.out.println(res.toString(2));

    }
    
    public void identityVerification(AipFace client) {
        // �����ѡ�������ýӿ�
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("quality_control", "NORMAL");
        options.put("liveness_control", "LOW");
        
        String image = "ȡ����image_type����������BASE64�ַ�����URL�ַ�����FACE_TOKEN�ַ���";
        String imageType = "BASE64";
        String idCardNumber = "110233112299822211";
        String name = "����";
        
        // �����֤
        JSONObject res = client.personVerify(image, imageType, idCardNumber, name, options);
        System.out.println(res.toString(2));

    }
    
    public void faceCompare(AipFace client) {
        String image1 = "base64_1";
        String image2 = "base64_2";

        // image1/image2Ҳ����Ϊurl��facetoken, ��Ӧ��imageType������Ҫ��֮��Ӧ��
        MatchRequest req1 = new MatchRequest(image1, "BASE64");
        MatchRequest req2 = new MatchRequest(image2, "BASE64");
        ArrayList<MatchRequest> requests = new ArrayList<MatchRequest>();
        requests.add(req1);
        requests.add(req2);

        JSONObject res = client.match(requests);
        System.out.println(res.toString(2));

    }
}