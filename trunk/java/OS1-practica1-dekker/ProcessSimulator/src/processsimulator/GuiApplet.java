/*
 * GuiApplet.java
 *
 * Created on August 11, 2007, 4:15 PM
 */

package processsimulator;
import javax.swing.*;
import java.awt.*;
import dekker.*;
/**
 *
 * @author  Erik Giron
 */
public class GuiApplet extends javax.swing.JApplet implements Runnable {

    Proceso p1 = new Proceso(1);
    Proceso p2 = new Proceso(2);
    CriticalSection rc = new CriticalSection();
    Thread tp1 = new Thread(p1,"proceso1");
    Thread tp2 = new Thread(p2,"proceso2");
    //Thread trc = new Thread(rc,"regioncritica");
    private volatile Thread guiWindowThread;
    
    int status = 0;
    public GuiApplet(){
        initComponents();
                    p1.setBounds(/*0,0,100,100*/0,0,process1Panel.getSize().width,process1Panel.getSize().height);
                    p2.setBounds(0,0,process2Panel.getSize().width,process2Panel.getSize().height);
                    rc.setBounds(0,0,criticalSectionPanel.getSize().width,criticalSectionPanel.getSize().height);
                    process1Panel.add(p1);
                    process2Panel.add(p2);
                    criticalSectionPanel.add(rc);
                    p1.setImg("img/stomach.gif");
                    p2.setImg("img/lungs.jpg");
                    rc.setImg("img/throat.gif");
                    p1.setOther(p2);
                    p2.setOther(p1);
                    p1.setCs(rc);
                    p2.setCs(rc);
                    guiWindowThread = new Thread(this,"applet");
    }
    /** Initializes the applet GuiApplet */
    public void init() {
        try {
            java.awt.EventQueue.invokeAndWait(new Runnable() {
                public void run() {
                    
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    /**Thread de la ventana*/
    public void run() {
        while(Thread.currentThread() == this.guiWindowThread){
            repaint();
        }
    }

    /** This method is called from within the init() method to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        mainPanel = new javax.swing.JPanel();
        process1Panel = new javax.swing.JPanel();
        process2Panel = new javax.swing.JPanel();
        versionComboBox = new javax.swing.JComboBox();
        execToggle = new javax.swing.JButton();
        p2timefield = new javax.swing.JTextField();
        p1timefield = new javax.swing.JTextField();
        criticalSectionPanel = new javax.swing.JPanel();
        jTextArea1 = new javax.swing.JTextArea();

        javax.swing.GroupLayout process1PanelLayout = new javax.swing.GroupLayout(process1Panel);
        process1Panel.setLayout(process1PanelLayout);
        process1PanelLayout.setHorizontalGroup(
            process1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 208, Short.MAX_VALUE)
        );
        process1PanelLayout.setVerticalGroup(
            process1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 183, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout process2PanelLayout = new javax.swing.GroupLayout(process2Panel);
        process2Panel.setLayout(process2PanelLayout);
        process2PanelLayout.setHorizontalGroup(
            process2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 191, Short.MAX_VALUE)
        );
        process2PanelLayout.setVerticalGroup(
            process2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 183, Short.MAX_VALUE)
        );

        versionComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Version 1", "Version 2", "Version 3", "Version 4", "Version 5" }));

        execToggle.setText("Ejecutar");
        execToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                execToggleActionPerformed(evt);
            }
        });

        p2timefield.setText("5");

        p1timefield.setText("4");

        javax.swing.GroupLayout criticalSectionPanelLayout = new javax.swing.GroupLayout(criticalSectionPanel);
        criticalSectionPanel.setLayout(criticalSectionPanelLayout);
        criticalSectionPanelLayout.setHorizontalGroup(
            criticalSectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 159, Short.MAX_VALUE)
        );
        criticalSectionPanelLayout.setVerticalGroup(
            criticalSectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 168, Short.MAX_VALUE)
        );

        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setRows(5);
        jTextArea1.setText("Practica 1 S.O. 1\n(C)2007 Erik Giron [C# 20013492]\nIngenieria Usac, Agosto 2007");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(p1timefield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(execToggle)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(versionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(p2timefield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(131, Short.MAX_VALUE))
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(criticalSectionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addComponent(process1Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(process2Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jTextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(99, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(process1Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(process2Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(criticalSectionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(p2timefield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(versionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(p1timefield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(execToggle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void execToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_execToggleActionPerformed
        if(status == 0){
            p1.setStopped(false);
            p2.setStopped(false);
            p1.setTiempo(Integer.parseInt(p1timefield.getText()));
            p2.setTiempo(Integer.parseInt(p2timefield.getText()));
            Proceso.setModo(versionComboBox.getSelectedIndex() + 1);
            versionComboBox.setEnabled(false);
            p1timefield.setEnabled(false);
            p2timefield.setEnabled(false);
            tp1.start();
            tp2.start();
            //trc.start();
            execToggle.setText("Detener");
            
            status = 1;
        } else{
            p1.setStopped(true);
            p2.setStopped(true);
            versionComboBox.setEnabled(true);
            p1timefield.setEnabled(true);
            p2timefield.setEnabled(true);
            execToggle.setText("Ejecutar");
            status = 0;
        }
    }//GEN-LAST:event_execToggleActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel criticalSectionPanel;
    private javax.swing.JButton execToggle;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField p1timefield;
    private javax.swing.JTextField p2timefield;
    private javax.swing.JPanel process1Panel;
    private javax.swing.JPanel process2Panel;
    private javax.swing.JComboBox versionComboBox;
    // End of variables declaration//GEN-END:variables
    
}