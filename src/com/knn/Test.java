package com.knn;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final String url="f:\\knn.txt";
		final int k=5;
		String type="";
		 List<KNNNode> node=new ArrayList<KNNNode>();
		 //待归类的node
		 KNNNode kn1=new KNNNode();
		 kn1.setX1(33);
		 kn1.setX2(12);
		 
		 KNNProcess knnProcess=new KNNProcess();
		 node=knnProcess.readFile(url);//读取文件
		 node=knnProcess.calDis(node, kn1);
		 node=knnProcess.getNodeDesc(node, k);
		 
		 double dis=node.get(0).getDis();
		 int s=0;
		 
		 Map<String, List<KNNNode>> knn=knnProcess.result(node, k);
		 
		 for(Map.Entry<String, List<KNNNode>> en:knn.entrySet()){
			 int s1=en.getValue().size();
			 if (s1>s) {
				dis=((KNNNode)(en.getValue().get(s1-1))).getDis();
				s=s1;
				type=en.getKey();
			}else if (s1==s&dis>((KNNNode)(en.getValue().get(s1-1))).getDis()) {
				dis=((KNNNode)(en.getValue().get(s1-1))).getDis();
				s=s1;
				type=en.getKey();
			}
		 }
		 System.out.println("=====result=========");
		 kn1.setType(type);
		 System.out.println(kn1.toString());		 
	}
}
