package com.yzit.weixin.uitls;

import com.thoughtworks.xstream.XStream;
import com.yzit.weixin.entity.Article;
import com.yzit.weixin.entity.ImageMessage;
import com.yzit.weixin.entity.NewsMessage;
import com.yzit.weixin.entity.TextMessage;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageUtil {
    /**
     * 将XML转换成Map集合
     */
    public static Map<String, String>xmlToMap(HttpServletRequest request) throws IOException, DocumentException {
        Map<String, String> map = new HashMap<String, String>();
        SAXReader reader = new SAXReader();            // 使用dom4j解析xml
        InputStream ins = request.getInputStream(); // 从request中获取输入流
        Document doc = reader.read(ins);

        Element root = doc.getRootElement();         // 获取根元素
        List<Element> list = root.elements();        // 获取所有节点

        for (Element e : list) {
            map.put(e.getName(), e.getText());
            System.out.println(e.getName() + "--->" + e.getText());
        }
        ins.close();
        return map;
    }

    /**
     * 将文本消息对象转换成XML
     */
    public static String textMessageToXML(TextMessage textMessage){
        XStream xstream = new XStream();              // 使用XStream将实体类的实例转换成xml格式
        xstream.alias("xml", textMessage.getClass()); // 将xml的默认根节点替换成“xml”
        return xstream.toXML(textMessage);

    }
    /**
     * 将图片消息对象转换成XML
     */
    public static String imagesMessageToXML(ImageMessage imageMessage) {
        XStream xstream = new XStream();              // 使用XStream将实体类的实例转换成xml格式
        xstream.alias("xml", imageMessage.getClass()); // 将xml的默认根节点替换成“xml”
        return xstream.toXML(imageMessage);
    }
    /**
     * 图文消息对象转换成xml
     *
     * @param newsMessage 图文消息对象
     * @return xml
     */
    public static String newsMessageToXml(NewsMessage newsMessage) {
        XStream xstream = new XStream();              // 使用XStream将实体类的实例转换成xml格式
        xstream.alias("xml", newsMessage.getClass());
        xstream.alias("item", new Article().getClass());
        return xstream.toXML(newsMessage);
    }
}
