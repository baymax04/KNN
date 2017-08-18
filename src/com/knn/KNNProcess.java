package com.knn;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KNNProcess {

	/**
	 * 计算历史数据与待测数据之间的欧氏距离
	 * @param node
	 * @param kn1
	 * @return
	 */
	public List<KNNNode> calDis(List<KNNNode> node,KNNNode kn1){
		for(int i=0;i<node.size();i++){
			KNNNode kn2=node.get(i);
			kn2.setDis(Math.sqrt(Math.pow(kn1.getX1()-kn2.getX1(), 2)+Math.pow(kn1.getX2()-kn2.getX2(), 2)));
		}
		return node;
	}
	
	/**
	 *  返回距离（相似度）最近（高）的K个对象
	 * @param node
	 * @param k
	 * @return
	 */
	public List<KNNNode> getNodeDesc(List<KNNNode> node,int k){
		Collections.sort(node);
		for(;k<node.size();){
			node.remove(k);
		}
		return node;
	}
	
	public Map<String, List<KNNNode>> result(List<KNNNode> node,int k){
		Map<String, List<KNNNode>> map=new HashMap<String, List<KNNNode>>();
		System.out.println("-------------K 个 近邻节点----------");
		
		for(int i=0;i<node.size();i++){
			System.out.println(node.get(i).toString());
		}
		
		for(int i=0;i<k;i++){
			String type=node.get(i).getType().trim();//获取特征值的类型
			if (map.containsKey(type)) {
				map.get(type).add(node.get(i));
				Collections.sort(map.get(type));
			}else {
				map.put(type, new ArrayList<KNNNode>());
				map.get(type).add(node.get(i));
			}
		}
		return map;
	}
	
	public List<KNNNode> readFile(String url){
		List<KNNNode> node=new ArrayList<>();
		String st="";
		File file=new File(url);
		
		if (file.isFile()) {
			
			BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader(file));
				while((st=br.readLine())!=null){
					String[] val = st.split("\\s+");
					if (val.length==3) {
						KNNNode knnNode=new KNNNode();
						knnNode.setX1(Float.parseFloat(val[0]));
						knnNode.setX2(Float.parseFloat(val[1]));
						knnNode.setType(val[2]);
						node.add(knnNode);
					}
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (br!=null) {
					br.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("文件不存在");
		}
		return node;
	}
	
	
	
	
	
	
}
