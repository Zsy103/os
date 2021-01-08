package file_system;

class Inode {
      int inodeNum;// ������
      int inodeFlag;  // �Ƿ�ʹ��
      DataBlock datablock;  //�������ݿ��Ӷ���
      
    /*��ʼ��*/
    Inode(){
    	inodeFlag=0;  //��ʼ��δ��ʹ��
    	datablock=null;
    }
   void write(String fileContent){
	    int x=0;  //ƫ�Ʋ���		
		datablock=SuperBlock.DataBlockAllocation();
		if(datablock==null) {
			//�д�
		}
		//û�мӷ���ʧ�ܵĴ���
		datablock.write(fileContent, x);
		inodeFlag=1;// �Ѿ���ʹ��
    }
   StringBuffer  getFileContent() {
	   if(datablock!=null) {
		   return datablock.getFileContent();
	   }
	   return null;
   }
   void delete() {
	   if(datablock!=null)
		   datablock.delete();  //�������ݿ�ɾ��
	   inodeFlag=0;
	   datablock=null;
   }
}
