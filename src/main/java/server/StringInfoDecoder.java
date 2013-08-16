package server;

import domain.Message;
import domain.SensorValue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class StringInfoDecoder{
    private String msgString;

    public StringInfoDecoder(String msgString){
        this.msgString = msgString;
    }

    public Set<Message> decodeAll(){
        Set<Message> result = new HashSet<Message>();
        String[] msgs = msgString.split("[|]");
        Set<Message> msgsInOneTime = new HashSet<Message>();
        for (int i = 1; i < msgs.length; i++){
            String[] msgParts = msgs[i].split("#");
            if( msgParts.length == 2){
                Iterator<Message> it = msgsInOneTime.iterator();
                System.out.println("msgsInOneTime"+msgsInOneTime);
                while(it.hasNext()){
                    Message tmpMsg = it.next();
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    Date date = null;
                    try {
                        date = format.parse(msgParts[1].trim());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    tmpMsg.setTimestamp(date.getTime());
                    result.add(tmpMsg);
                }
                msgsInOneTime.clear();
            } else{
                Message msg = new Message();
                msg.setSensor(msgParts[0]);
                List<SensorValue> list = new ArrayList<SensorValue>();
                list.add(new SensorValue(msgParts[2],Double.valueOf(msgParts[1])));
                msg.setValues(list);
                msgsInOneTime.add(msg);
            }
        }
//        ArrayList<String> list = new ArrayList<String>();
//        List<ArrayList<String>> lists = new ArrayList<ArrayList<String>>();
//        for (int i = 0; i < msgs.length; i++){
//            list.add(msgs[i]);
//            if( msgs[i].startsWith("time")){
//                lists.add(list);
//                list.clear();
//            }
//        }
//        Iterator<ArrayList<String>> it1 = lists.iterator();
//        while(it1.hasNext()){
//            ArrayList<String> tmpList = it1.next();
//            Iterator<String> it2 = tmpList.iterator();
//        }
        return result;
    }
}
