package �ļ�ϵͳ;

public class DataBlock {
		int dataBlockFlag;   //���ݿ��Ƿ�ʹ�ñ�־
		StringBuffer array =new StringBuffer();
		StringBuffer str =new StringBuffer(); //��ʱ��¼
	    DataBlock next;
				
		/*��ʼ��*/
	DataBlock(){
		dataBlockFlag = 0;  // û��ʹ��
		next=null;
	}
	void write(String fileContenta,int x){
		int a;
		String str=fileContenta;
		a=str.length()-x;
		if(a<=10) {
			String array=str.substring(x); //x��ʾ��ʼ���ַ�λ�ã��ַ���������10����ֱ�Ӷ���
		}
		else {              
			String array=str.substring(x,x+10);     //x��ʾ��ʼλ�ã�x+10��ʾ����λ�ã�һ�ζ�10���ַ���
			x=x+10;
			next=SuperBlock.dataBlockAllocation();
			next.write(fileContenta,x);
		}	
	}
	void delete() {
		if (next!=null)     // �ݹ��ҵ����Ŀ飬��Ϊnull���������Ͻ�ʹ�ñ�־��Ϊ0.
			next.delete();
		dataBlockFlag=0;
		next=null;
	}
}
