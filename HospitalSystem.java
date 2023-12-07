package com.mycompany.hospitalsystem;



    /*
     *This Java program is a basic Hospital System that allows the user
     *to perform various tasks related to managing patients, doctors, appointments,
     * and hospital departments.
     * The program uses various data structures such as ArrayList, LinkedList,
     *Stack, Queue, and Tree to store and organize different types of data.
     */

    import java.util.*;

    class LinkedList<T> {
        public  Node<T> head;

        public LinkedList() {
            head = null;
        }

        public void addFirst(T element) {
            Node<T> newNode = new Node<>(element, head);
            head = newNode;
        }

        public void addLast(T element) {
            Node<T> newNode = new Node<>(element, null);
            if (head == null) {
                head = newNode;
            } else {
                Node<T> lastNode = getLastNode();
                lastNode.setNext(newNode);
            }
        }

        public void removeFirst() {
            if (head == null) {
                throw new RuntimeException("List is empty!");
            }
            head = head.getNext();
        }

        public boolean isEmpty() {
            return head == null;
        }

        public int size() {
            int count = 0;
            Node<T> current = head;
            while (current != null) {
                count++;
                current = current.getNext();
            }
            return count;
        }

        private Node<T> getLastNode() {
            Node<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            return current;
        }

        public static class Node<T> {
            public T data;
            public  Node<T> next;

            public Node(T data, Node<T> next) {
                this.data = data;
                this.next = next;
            }

            public T getData() {
                return data;
            }

            public void setData(T data) {
                this.data = data;
            }

            public Node<T> getNext() {
                return next;
            }

            public void setNext(Node<T> next) {
                this.next = next;
            }
        }
    }

    class Doctor {
        private String name;
        private String specialization;
        private String department;


        public Doctor(String name, String department , String spec) {
            this.name = name;
            this.specialization=spec;
            this.department = department;
        }

        public String getName() {
            return name;
        }

        public String getDepartment() {
            return department;
        }

        @Override
        public String toString() {
            String str=" Doctor name     : "+this.name+"\n";
            str= str + " Department   : "+this.getDepartment()+"\n";
            str= str + " Specialization    : "+this.specialization+"\n";
            ;

            return str;

        }
    }


    class Stack<T> {

        public static final int CAPACITY = 3000;   // default array capacity
        private T[] data;
        private int t = -1;                      // index of the top element in stack

        public Stack() {
            data = (T[]) new Object[CAPACITY];
        }

        public void push(T element) {

            if (t < data.length) {
                t++;
                data[t] = element;
            }
        }

        public T pop() {

            if (!isEmpty()) {
                T elem = data[t];
                data[t] = null;
                t--;
                return elem;
            } else {
                throw new RuntimeException("Stack is empty!");
            }
        }

        public T top() {
            if (!isEmpty()) {
                return data[t];
            } else
                throw new RuntimeException("Stack is empty!");
        }

        public boolean isEmpty() {
            return t == -1;
        }

        public int size() {
            return (t + 1);
        }

    }
    class Patient {
        private int id;
        private String name;
        private int age;
        private String gander;
        private String address;
        private String phoneNumber;

        public Patient(){};

        public Patient(int id ,String name, int age,String gender , String address , String phone) {
            this.id=id;
            this.name = name;
            this.age = age;
            this.gander=gender;
            this.address=address;
            this.phoneNumber=phone;
        }
        public Patient(String name) {
            this.name = name;
        }

        public void setGander(String gander) {
            this.gander = gander;}

        public boolean gander (String gander){
            String m="m";
            String f="f";
            if (gander.equals(m)||gander.equals(f)) {
                return true;}
            else { return false; }
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }


        public String getName() {
            return name;
        }


        public int getAge() {
            return age;
        }

        public int getID(){
            return this.id;
        }
        public void setID(int id){
            this.id=id;
        }

        public String getAddress(){
            return this.address;
        }
        public void setAddress(String address){
            this.address=address;
        }



        @Override
        public String toString() {
            String str=" Patient ID     : "+this.id+"\n";
            str= str + " Patient Name   : "+this.name+"\n";
            str= str + " Patient Age    : "+this.age+"\n";
            str= str+ " Gender         : "+this.gander+"\n";
            str= str+ " Address        : "+this.address+"\n";
            str= str+ " phone        : "+this.phoneNumber+"\n";
            str= str+ "---------------------------------------\n";

            return str;
        }
        public int binarySearch(ArrayList<Patient> patients, String name) {
            int left = 0;
            int right = patients.size() - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (patients.get(mid).getName().equals(name)) {
                    return mid;
                }

                if (patients.get(mid).getName().compareTo(name) < 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return -1; // patient not found
        }
    }

    class Queue<T> {
        private ArrayList<T> queue;

        public Queue() {
            queue = new ArrayList<>();
        }

        public void enqueue(T element) {
            queue.add(element);
        }

        public T dequeue() {
            if (queue.isEmpty()) {
                throw new RuntimeException("Queue is empty!");
            }
            return queue.remove(0);
        }

        public T top() {
            if (queue.isEmpty()) {
                throw new RuntimeException("Queue is empty!");
            }
            return queue.get(0);
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }

        public int size() {
            return queue.size();
        }

    }
    /*
     *Scheduling an appointment and adding it
     *to the appointment queue has a time
     */
    class Appointment {
        private Patient patient;
        private Doctor doctor;
        private String dateTime;

        public Appointment(Patient patient, Doctor doctor, String dateTime) {
            this.patient = patient;
            this.doctor = doctor;
            this.dateTime = dateTime;
        }

        public Patient getPatient() {
            return patient;
        }

        public Doctor getDoctor() {
            return doctor;
        }

        public String getDateTime() {
            return dateTime;
        }

        @Override
        public String toString() {
            return "Appointment{" +
                    "patient=" + patient +
                    ", doctor=" + doctor +
                    ", dateTime='" + dateTime + '\'' +
                    '}';
        }
    }

    class Tree<T> {
        class TreeNode<T> {
            public  T data;
            private TreeNode<T> left;
            private TreeNode<T> right;

            public TreeNode(T data) {
                this.data = data;
            }

            public T getData() {
                return data;
            }

            public void setData(T data) {
                this.data = data;
            }

            public TreeNode<T> getLeft() {
                return left;
            }

            public void setLeft(TreeNode<T> left) {
                this.left = left;
            }

            public TreeNode<T> getRight() {
                return right;
            }

            public void setRight(TreeNode<T> right) {
                this.right = right;
            }
        }
        private TreeNode<T> root;

        public void add(T data) {
            if (root == null) {
                root = new TreeNode<>(data);
            } else {
                add(root, data);
            }
        }

        private void add(TreeNode<T> node, T data) {
            if (node.getLeft() == null) {
                node.setLeft(new TreeNode<>(data));
            } else if (node.getRight() == null) {
                node.setRight(new TreeNode<>(data));
            } else {
                add(node.getLeft(), data);
            }
        }

        public void print() {
            print(root, 0);
        }

        private void print(TreeNode<T> node, int level) {
            if (node != null) {
                print(node.getRight(), level + 1);

                System.out.println(getIndent(level) + node.getData());
                print(node.getLeft(), level + 1);
            }
        }

        private String getIndent(int level) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < level; i++) {
                sb.append("  ");
            }
            return sb.toString();
        }
    }
    class PatientComparator implements Comparator<Patient> {
        public int compare(Patient p1, Patient p2) {
            return p1.getName().compareTo(p2.getName());
        }
    }
    class MergeSort<T extends Comparable<T>> {
        public static void mergeSort(ArrayList<Patient> patients, Comparator<Patient> comparator) {
            if(patients.size() > 1) {
                int mid = patients.size() / 2;
                ArrayList<Patient> left = new ArrayList<>(patients.subList(0, mid));
                ArrayList<Patient> right = new ArrayList<>(patients.subList(mid, patients.size()));

                mergeSort(left, comparator);
                mergeSort(right, comparator);

                int i = 0, j = 0, k = 0;
                while(i < left.size() && j < right.size()) {
                    if(comparator.compare(left.get(i), right.get(j)) < 0) {
                        patients.set(k++, left.get(i++));
                    } else {
                        patients.set(k++, right.get(j++));
                    }
                }
                while(i < left.size()) {
                    patients.set(k++, left.get(i++));
                }
                while(j < right.size()) {
                    patients.set(k++, right.get(j++));
                }
            }
        }
        public void mergeSort(ArrayList<T> list) {
            if (list.size() > 1) {
                int mid = list.size() / 2;
                ArrayList<T> left = new ArrayList<>(list.subList(0, mid));
                ArrayList<T> right = new ArrayList<>(list.subList(mid, list.size()));

                mergeSort(left);
                mergeSort(right);

                int i = 0, j = 0, k = 0;
                while (i < left.size() && j < right.size()) {
                    if (left.get(i).compareTo(right.get(j)) < 0) {
                        list.set(k++, left.get(i++));
                    } else {
                        list.set(k++, right.get(j++));
                    }
                }

                while (i < left.size()) {
                    list.set(k++, left.get(i++));
                }

                while (j < right.size()) {
                    list.set(k++, right.get(j++));
                }
            }
        }
    }

    class InsertionSort<T extends Comparable<T>> {

        public void insertionSort(ArrayList<T> list) {
            for (int i = 1; i < list.size(); i++) {
                T key = list.get(i);
                int j = i - 1;

                while (j >= 0 && list.get(j).compareTo(key) > 0) {
                    list.set(j + 1, list.get(j));
                    j--;
                }

                list.set(j + 1, key);
            }
        }
    }

    class HospitalDepartment {
        public  String name;
        private List<HospitalDepartment> subDepartments;

        public HospitalDepartment(String name) {
            this.name = name;
            this.subDepartments = new ArrayList<>();
        }

        public void add(HospitalDepartment department) {
            subDepartments.add(department);
        }
        public String getDepartmentName(){
            return this.name;
        }

        public String toString(){
            String st=name;
            return name;
        }
    }
    public class HospitalSystem {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            ArrayList<Patient> patients = new ArrayList<>();
            LinkedList<Doctor> doctors = new LinkedList<>();
            Stack<Patient> patientStack = new Stack<>();
            Queue<Appointment> appointments=new Queue<>();
            Tree<HospitalDepartment> departments = new Tree<>();
            Patient patient = new Patient();


            departments.add(new HospitalDepartment("Cardiology"));
            departments.add(new HospitalDepartment("Neurology"));
            departments.add(new HospitalDepartment("Oncology"));
            departments.add(new HospitalDepartment("Pediatrics"));
            departments.add(new HospitalDepartment("Surgery"));

            int choice = 0;
            do {
                System.out.println("\nHospital System Menu:");
                System.out.println("1. Add Patient");
                System.out.println("2. Add Doctor");
                System.out.println("3. Schedule Appointment");
                System.out.println("4. Search for Patient");
                System.out.println("5. Sort Patients by Name");
                System.out.println("6. print all Patient");
                System.out.println("7. last patient added" );
                System.out.println("8. delete last Scheduled Appointment" );
                System.out.println("9. Exit\n");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        Patient patient1=new Patient();

                        System.out.print("Enter patient ID : ");
                        int id = sc.nextInt();
                        patient1.setID(id);

                        System.out.print("Enter patient name: ");
                        String junk=sc.nextLine();
                        String name = sc.nextLine();
                        patient1.setName(name);

                        System.out.print("Enter patient age: ");
                        int age = sc.nextInt();
                        patient1.setAge(age);

                        System.out.print("Enter patient gender (m or f) :");
                        String gander = sc.next();
                        while(!patient1.gander(gander)){
                            System.out.println("invalid value, try again");
                            gander = sc.next();}
                        patient1.setGander(gander);

                        System.out.print("Enter address : ");
                        String address = sc.next();
                        patient1.setAddress(address);

                        System.out.print("Enter phone number : ");
                        String phone = sc.next();
                        patient1.setPhoneNumber(phone);

                        patients.add(patient1);
                        patientStack.push(patient1);
                        System.out.println("Patient added successfully!");
                        break;

                    case 2:

                        System.out.print("\nEnter doctor name: ");
                        name = sc.nextLine();
                        System.out.println("list of all department in the Hospital :");
                        departments.print();

                        System.out.print("Enter doctor department : ");
                        String department = sc.nextLine();
                        System.out.print("Enter doctor Specialization : ");
                        String spec = sc.nextLine();

                        Doctor doctor = new Doctor(name, department,spec);
                        doctors.addFirst(doctor);
                        System.out.println("Doctor added successfully!");
                        break;

                    case 3:
                        System.out.print("Enter patient name: ");
                        name = sc.nextLine();

                        System.out.println("\nThe info of All doctors in Hospital System :"); // print doctors list
                        LinkedList.Node<Doctor> DList=doctors.head;
                        while(DList!=null){

                            System.out.println(DList.getData());
                            DList=DList.next;}

                        System.out.print("Enter doctor name: ");
                        String doctorName = sc.nextLine();

                        System.out.print("Enter appointment date (MM/DD/YYYY):");
                        String dateTime = sc.nextLine();

                        if (patient.binarySearch(patients,name)!= -1) {
                            patient = patients.get(patient.binarySearch(patients, name));

                        } else {
                            System.out.println("Patient not found!");
                        }

                        Doctor d=null;
                        LinkedList.Node<Doctor> current=doctors.head;
                        while(current!=null){
                            if(current.getData().getName().equalsIgnoreCase(doctorName)){
                                d=current.getData();
                                break;
                            }
                        } if (d == null) {
                        System.out.println("Doctor not found!");
                        break;
                        }

                        Appointment appointment = new Appointment(patient, d, dateTime);
                        appointments.enqueue(appointment);
                        System.out.println("Appointment scheduled successfully!");
                        break;

                    case 4:
                        System.out.print("Enter patient name: ");
                        name = sc.nextLine();
                        if (patient.binarySearch(patients,name)!= -1) {
                            System.out.println(patients.get(patient.binarySearch(patients, name)));
                        } else {
                            System.out.println("Patient not found!");
                        }
                        break;

                    case 5:
                        MergeSort.mergeSort(patients,new PatientComparator());
                        System.out.println("Patients sorted by name:");
                        for (Patient pt : patients){
                            System.out.println(pt);
                        }
                        break;

                    case 6:
                        System.out.println("The info of All Patients in Hospital System :");
                        for (Patient pt : patients) {
                            System.out.println(pt);
                        }
                        break;

                    case 7 :
                        System.out.println("Last patient added: ");
                        System.out.println("\n"+patientStack.top());
                        break;

                    case 8 :
                        appointments.dequeue();
                        System.out.println("Appointment removed successfully!");
                        break;


                    case 9 :
                        System.out.println("Exiting Hospital System...");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }
            } while (choice < 9);
        }
    }