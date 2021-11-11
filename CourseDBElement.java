public class CourseDBElement implements Comparable{
        private String id;
        private String roomNumber;
        private String professor;
        private int crn;
        private int creditNumber;
        
        public CourseDBElement() {
                id = "";
                crn = 0;
                creditNumber = 0;
                roomNumber = "";
                professor = "";
        }
        public CourseDBElement(String id, int crn, int creditNumber, String roomNumber, String professor) {
                this.id = id;
                this.crn = crn;
                this.creditNumber = creditNumber;
                this.roomNumber = roomNumber;
                this.professor = professor;
        }
        @Override
        public boolean equals(Object obj) {
                if (this == obj)
                        return true;
                if (obj == null)
                        return false;
                if (getClass() != obj.getClass())
                        return false;
                CourseDBElement other = (CourseDBElement) obj;
                if (crn != other.crn)
                        return false;
                return true;
        }
        @Override
        public int compareTo(CourseDBElement num) {
                return (this.crn - num.crn);
        }
        public void setCRN(int crn) {
            this.crn = crn;
        }
        @Override
        public int hashCode() {
                String str = crn + "";
                return str.hashCode();
        }
        public int getCRN() {
            return crn;
        }
        @Override
        public String toString() {
                String str = "\nCourse:" + id + " CRN:" + crn + " Credits:" + creditNumber + " Instructor:" + professor + " Room:" + roomNumber;
                return str;
        }
}