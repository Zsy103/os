
public class SuperBlock {
	private static DataBlock[] datablock = new DataBlock[10];
	private static Inode[] inode= new Inode[10];
	private boolean dirty = false;
	static int[] InodeNum = {0,0,0,0,0,0,0,0,0,0}; 
	static int[] DataBlockNum = {0,0,0,0,0,0,0,0,0,0}; 
	static int[] GetInodeNum()//�����������״̬
	{ 
		return InodeNum;
	}
	static int[]  GetDataBlockNum()//������ݿ����״̬
	{ 
		return DataBlockNum;
	}
	static boolean InodeAllocation(int inodeNum) {//��������,����������δ���䣬���з��䣬���ѷ��䣬����false
		if(InodeNum[inodeNum]==0)
		{
			InodeNum[inodeNum]=1;
			return true;
		}
		else
			return false;
	}
	static boolean DataBlockAllocation(int dataBlockNum,char[] cotent) {//���ݿ����,DataBlockNum�Ƿ����ȥ�����ݿ����
		if(DataBlockNum[dataBlockNum]==0)
		{
			DataBlockNum[dataBlockNum]=1;
			dataBlock[dataBlockNum].array=cotent;
			return true;
		}
		else
			return false;
	}
	static void DeleteInode(int InodeNum)//ͨ��������ɾ���ļ������Ŀ¼���µ��ļ�����Ŀ¼�������
	{
		
	}
	
	
}
