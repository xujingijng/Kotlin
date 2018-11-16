package com.xjj.kotlin;

/**
 * Describe:线程类（线程创建的4中方式）
 *
 * 继承Thread，多线程中不能共享线程的实例变量，而实现Runnable可以
 * @author xujingjing
 * @date 2018/11/7 0007
 */
public class ThreadTest {

    public static void main(String[] args) {
        // new Test1().start();
        // new Test1().start();

      /*  Test2 runable = new Test2();
        new Thread(runable,"线程1").start();
        new Thread(runable,"线程2").start();*/

    }


    private static class Test1 extends Thread{

        private int i;
        @Override
        public void run() {
            super.run();
            for (; i < 100 ; i++) {
                System.out.println(getName()+"===="+i);
            }
        }
    }

    private static class Test2 implements Runnable{

        private int i;
        @Override
        public void run() {
            for (; i < 100 ; i++) {
                System.out.println(Thread.currentThread().getName()+"===="+i);
            }
        }
    }

    static class Print{
        private boolean flag = false;

        public synchronized void writeNum(){
            for (int i = 1; i <= 26; i++) {
                try {
                if (flag){
                    wait();
                }else {
                    System.out.println(2*i-1);
                    System.out.println(2*i);
                    flag = true;
                    notifyAll();
                }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public synchronized void writeChar(){
            for (int i = 'A'; i <= 'Z'; i++) {
                try {
                    if (!flag){
                        wait();
                    }else {
                        System.out.println((char) i);
                        flag = false;
                        notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
