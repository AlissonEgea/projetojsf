package br.com.alissonegea.controller;
 
import java.io.File;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.Serializable;
import javax.faces.application.FacesMessage;  
import javax.faces.bean.ManagedBean;  
import javax.faces.bean.ViewScoped;  
import javax.faces.context.FacesContext;  
import org.primefaces.event.FileUploadEvent;  
import org.primefaces.model.UploadedFile;  
  
@ManagedBean  
@ViewScoped  
public class MbUploadArquivo implements Serializable {  
  
    private UploadedFile arquivo;  
  
    /* Construtor */  
    public MbUploadArquivo() {  
    }  
  
    /* Get e Set */  
    public UploadedFile getArquivo() {  
        return arquivo;  
    }  
  
    public void setArquivo(UploadedFile arquivo) {  
        this.arquivo = arquivo;  
    }  
    
    public void uploadListener(FileUploadEvent evento) {  
        this.arquivo = evento.getFile();  
  
        FacesContext ctx = FacesContext.getCurrentInstance();  
        FacesMessage msg = new FacesMessage();  
  
        msg.setSummary("Arquivo anexado com sucesso.");  
        msg.setSeverity(FacesMessage.SEVERITY_INFO);  
  
        ctx.addMessage("mensagens", msg);  
  
    }  
  
    /** 
     * Salvar o arquivo 
     * @return  
     */  
    public String salvar() {  
  
        FacesContext ctx = FacesContext.getCurrentInstance();  
        FacesMessage msg = new FacesMessage();  
  
        String nomeArquivo = arquivo.getFileName(); //Nome do arquivo enviado  
        byte[] conteudo = arquivo.getContents(); //Conteudo a ser gravado no arquivo  
  
        File file = new File("C:\\teste" + nomeArquivo); //Cria uma referencia para arquivo no caminho passado  
  
        try {  
  
            //Escreve o arquivo e salva  
            FileOutputStream fos = new FileOutputStream(file);  
            fos.write(conteudo);  
            fos.flush();  
            fos.close();  
  
            msg.setSummary("Arquivo salvo com sucesso!");  
            msg.setSeverity(FacesMessage.SEVERITY_INFO);  
  
        } catch (IOException ex) {  
  
            msg.setSummary(ex.getMessage());  
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);  
  
        } finally {  
            ctx.addMessage("mensagens", msg);  
            return null;  
        }  
  
    }  
}  