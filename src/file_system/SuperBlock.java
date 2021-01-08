package file_system;
public class SuperBlock {
	private static DataBlock[] dataBlock = new DataBlock[10];
	private static Inode[] inode = new Inode[10];
	private boolean dirty = false;//��λ���ڴ��е������Ƿ񱻸ı�ı�־
	static Inode InodeAllocation() {
		for(int i=0;i<10;i++)
			if(inode[i]==null||inode[i].inodeFlag == 0) {
				inode[i]=new Inode();
				return inode[i]; 
			}		
		return null;
	}
	static DataBlock DataBlockAllocation() {//���ݿ����,���ڿյ����ݿ鷵�ظ����ݿ����
		for(int i = 0;i < 10;i++)
			if(dataBlock[i]==null||dataBlock[i].dataBlockFlag == 0) {
				dataBlock[i]=new DataBlock();
				return dataBlock[i];
			}
		return null;
	}
	boolean getDirty() {//��ȡ��λ
		return dirty;
	}
	void modifyDirty() {//�޸���λ
		dirty = true;
	}
}
