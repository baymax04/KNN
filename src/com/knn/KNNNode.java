package com.knn;

public class KNNNode implements Comparable<KNNNode>{

	float x1,x2;//特征值
	String type;//特征值对应的类型
	double dis;//与待测点之间的距离
		
	public float getX1() {
		return x1;
	}

	public void setX1(float x1) {
		this.x1 = x1;
	}

	public float getX2() {
		return x2;
	}

	public void setX2(float x2) {
		this.x2 = x2;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getDis() {
		return dis;
	}

	public void setDis(double dis) {
		this.dis = dis;
	}
	
	@Override
	public String toString() {
		return "KNNNode [x1=" + x1 + ", x2=" + x2 + ", type=" + type + ", dis=" + dis + "]";
	}

	@Override
	public int compareTo(KNNNode arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}
