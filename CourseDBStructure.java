import java.io.IOException;
import java.util.*;

public class CourseDBStructure implements CourseDBStructureInterface {
        protected int count;
        protected LinkedList<CourseDBElement> hashTable[];
        
        @SuppressWarnings("unchecked")
        public CourseDBStructure(String test, int size) {
                this.count = size;
                hashTable = new LinkedList[size];
        }
        @SuppressWarnings("unchecked")
        public CourseDBStructure(int count) {
                this.count = count;
                hashTable = new LinkedList[count];
        }
        @Override
        public CourseDBElement get(int crn) throws IOException {
                String str = crn + "";
                int index = str.hashCode() % count;
                if(hashTable[index] == null) {
                        throw new IOException();
                }
                else {
                        for(int a = 0; a < count; a++) {
                                CourseDBElement temp = hashTable[index].get(a);
                                if(temp.getCRN() == crn) {
                                        return temp;
                                }
                        }
                        return null;
                }
        }
        @Override
        public void add(CourseDBElement info) {
                int index = info.hashCode() % count;
                if(hashTable[index] == null) {
                        hashTable[index] = new LinkedList<CourseDBElement>();
                }
                hashTable[index].add(info);
        }
        @Override
        public int getTableSize() {
                return count;
        }

}