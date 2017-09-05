
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		num=8;
		solution=new int[num];
		trackBack(0);
	}

	public static int num;
	public static int[]solution;
	public static int count=1;
	
	public static void trackBack(int pos){
		if(pos<0||count>num+1)//��Ϊcount��ʼֵΪ1�������ݻ���ݸ���n�Σ��˳�ʱcountӦ��Ϊn+1�Σ�����
			return;
		
		if(put(pos)){
			if(pos==num-1)
				print();
			pos++;
		}else{
			pos--;
		}
		trackBack(pos);
	}
	//�ж��Ƿ�������
	public static boolean put(int pos){
		if(pos==num)
			return false;
		if(pos==0){
			solution=new int[num];
			solution[0]=count;
			count++;
			return true;
		}
		boolean flag=true;
		for(int i=1;i<=num;i++){
			flag=true;
			for(int j=0;j<pos;j++){
				if(i==solution[j]){
					flag=false;
					break;
				}
			}
			if(flag&&judge(pos,i)&&i>solution[pos]){
				solution[pos]=i;
				for(int j=pos+1;j<num;j++){
					solution[j]=0;
				}
				break;
			}else{
				flag=false;
			}
		}
		return flag;
	}
	//����Ƿ���ͬһֱ��
	public static boolean judge(int pos,int val){
		boolean flag=true;
		for(int i=0;i<pos;i++){
			if(Math.abs(pos-i)==Math.abs(val-solution[i])){
				flag=false;
				break;
			}
		}
		return flag;
	}
	
	public static void print(){
		for(int i:solution){
			System.out.print(i+" ");
		}
		System.out.println();
	}
}
