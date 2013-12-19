/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package generadordellistes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


/**
 *
 * @author DmnT
 */
public class FrmGeneradorDeLlistes extends javax.swing.JFrame {
    
    ArrayList<Alumne> alumnes = new ArrayList<Alumne>();
    ArrayList<String> materies = new ArrayList<String>();
    
    
    
    
    

    /**
     * Creates new form FrmGeneradorDeLlistes
     */
    public FrmGeneradorDeLlistes() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Indica el fitxer que conté les dades a tractar:");

        jTextField1.setEditable(false);

        jButton1.setText("Examinar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Selecciona les matèries de es quals vols generar llistes:");

        jScrollPane2.setViewportView(jList1);

        jButton2.setText("Generar Llistes");
        jButton2.setName("GenerarLlistes"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2))
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(165, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jButton2)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser fc = new JFileChooser();
        //Obra la finestra Per buscar el fitxer
        fc.showOpenDialog(this);
        //asigna el fitxer al textbox
        jTextField1.setText(fc.getSelectedFile().getPath());
        this.llegirDades(jTextField1.getText(),alumnes,materies);
        //ordenar les llistes:
        Collections.sort(alumnes);
        Collections.sort(materies);  
        Vector<String> materies2 = new Vector<String>(materies);
        jList1.setListData(materies2);
        
        /*try {
            BufferedReader inputStream= new BufferedReader(new FileReader(jTextField1.getText()));
            String l;
            inputStream.readLine();
            while((l=inputStream.readLine())!=null){
                String[] tempor=l.split("\"");
                System.out.print(tempor[3]+"-"+tempor[7]+"-"+tempor[11]+"\n");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmGeneradorDeLlistes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmGeneradorDeLlistes.class.getName()).log(Level.SEVERE, null, ex);
        }*/
            
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            //System.out.print(jList1.getSelectedValuesList().toString());
            List<String> materiesSeleccionades = jList1.getSelectedValuesList();
            DocumentBuilder docBuilder =DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("llistes");  
            doc.appendChild(rootElement);
            
            for(String str : materiesSeleccionades){
                Element materia = doc.createElement("llista");
                materia.setAttribute("materia", str);
                for(int i=0;i<alumnes.size();i++){
                    if(alumnes.get(i).getMateries().contains(str)){
                        Element unAlumne = doc.createElement("alumne");
                        Element nomCognom = doc.createElement("cognomsNom");
                        nomCognom.appendChild(doc.createTextNode(alumnes.get(i).getCognoms()+", "+alumnes.get(i).getNom()));
                        unAlumne.appendChild(nomCognom);
                        Element elGrup = doc.createElement("grup");
                        elGrup.appendChild(doc.createTextNode(alumnes.get(i).getGrup()));
                        unAlumne.appendChild(elGrup);
                        materia.appendChild(unAlumne);
                    }                    
                }  
                rootElement.appendChild(materia);
            }
            Transformer transformer =TransformerFactory.newInstance().newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File("llistaAlumesPerMateria.xml"));
                transformer.transform(source, result);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(FrmGeneradorDeLlistes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(FrmGeneradorDeLlistes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(FrmGeneradorDeLlistes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmGeneradorDeLlistes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmGeneradorDeLlistes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmGeneradorDeLlistes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmGeneradorDeLlistes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmGeneradorDeLlistes().setVisible(true);
            }
        });
    }
    
    public void llegirDades(String direccio, ArrayList<Alumne> alumnes, ArrayList<String> materies){
        try {
            BufferedReader inputStream= new BufferedReader(new FileReader(direccio));
            String l;
            //es llegeix una linia primer per a ometre la primera, en la que no hi ha cap alumne
            inputStream.readLine();
            //TODO això ha d'introduir dades, no imprimir
            while((l=inputStream.readLine())!=null){
                String[] temporStrings=l.replaceAll("\"", "").split(",");
                //System.out.println(temporStrings[1]+"-"+temporStrings[2].trim());
                Alumne temporAlumne=new Alumne();
                temporAlumne.setCognoms(temporStrings[1]);
                temporAlumne.setNom(temporStrings[2].trim());
                temporAlumne.setGrup(temporStrings[3]);
                ArrayList<String> temporMaterAlumn = new ArrayList<String>();
                for(int i=4;i<temporStrings.length;i++){
                    temporMaterAlumn.add(temporStrings[i]);
                    if(!materies.contains(temporStrings[i])){
                        materies.add(temporStrings[i]);
                    }
                }
                temporAlumne.setMateries(temporMaterAlumn);
                alumnes.add(temporAlumne);
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmGeneradorDeLlistes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmGeneradorDeLlistes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
