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
   void write(String fileContenta){
	    int x=0;  //ƫ�Ʋ���		
		datablock=SuperBlock.DataBlockAllocation();
		datablock.write(fileContenta, x);
		inodeFlag=1;// �Ѿ���ʹ��
    }
   void delete() {
	   if(datablock!=null)
		   datablock.delete();  //�������ݿ�ɾ��
	   inodeFlag=0;
	   datablock=null;
   }
}
