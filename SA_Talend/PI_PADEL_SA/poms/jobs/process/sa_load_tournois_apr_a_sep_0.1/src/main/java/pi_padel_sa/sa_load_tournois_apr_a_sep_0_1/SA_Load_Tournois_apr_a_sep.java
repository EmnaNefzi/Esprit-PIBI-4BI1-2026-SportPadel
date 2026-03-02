// ============================================================================
//
// Copyright (c) 2006-2015, Talend SA
//
// Ce code source a été automatiquement généré par_Talend Open Studio for Data Integration
// / Soumis à la Licence Apache, Version 2.0 (la "Licence") ;
// votre utilisation de ce fichier doit respecter les termes de la Licence.
// Vous pouvez obtenir une copie de la Licence sur
// http://www.apache.org/licenses/LICENSE-2.0
// 
// Sauf lorsqu'explicitement prévu par la loi en vigueur ou accepté par écrit, le logiciel
// distribué sous la Licence est distribué "TEL QUEL",
// SANS GARANTIE OU CONDITION D'AUCUNE SORTE, expresse ou implicite.
// Consultez la Licence pour connaître la terminologie spécifique régissant les autorisations et
// les limites prévues par la Licence.


package pi_padel_sa.sa_load_tournois_apr_a_sep_0_1;

import routines.Numeric;
import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.StringHandling;
import routines.Relational;
import routines.TalendDate;
import routines.Mathematical;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;
 





@SuppressWarnings("unused")

/**
 * Job: SA_Load_Tournois_apr_a_sep Purpose: <br>
 * Description:  <br>
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status 
 */
public class SA_Load_Tournois_apr_a_sep implements TalendJob {

protected static void logIgnoredError(String message, Throwable cause) {
       System.err.println(message);
       if (cause != null) {
               cause.printStackTrace();
       }

}


	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}
	
	private final static String defaultCharset = java.nio.charset.Charset.defaultCharset().name();

	
	private final static String utf8Charset = "UTF-8";
	//contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String,String> propertyTypes = new java.util.HashMap<>();
		
		public PropertiesWithType(java.util.Properties properties){
			super(properties);
		}
		public PropertiesWithType(){
			super();
		}
		
		public void setContextType(String key, String type) {
			propertyTypes.put(key,type);
		}
	
		public String getContextType(String key) {
			return propertyTypes.get(key);
		}
	}
	
	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();
	// create application properties with default
	public class ContextProperties extends PropertiesWithType {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties){
			super(properties);
		}
		public ContextProperties(){
			super();
		}

		public void synchronizeContext(){
			
		}
		
		//if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if(NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
				return null;
			}
			return origin_value;
		}

	}
	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.
	public ContextProperties getContext() {
		return this.context;
	}
	private final String jobVersion = "0.1";
	private final String jobName = "SA_Load_Tournois_apr_a_sep";
	private final String projectName = "PI_PADEL_SA";
	public Integer errorCode = null;
	private String currentComponent = "";
	
		private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
        private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();
	
		private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
		private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
		private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
		public  final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();
	

private RunStat runStat = new RunStat();

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";
	
	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(), new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}
	
	public void setDataSourceReferences(List serviceReferences) throws Exception{
		
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		java.util.Map<String, javax.sql.DataSource> dataSources = new java.util.HashMap<String, javax.sql.DataSource>();
		
		for (java.util.Map.Entry<String, javax.sql.DataSource> entry : BundleUtils.getServices(serviceReferences,  javax.sql.DataSource.class).entrySet()) {
                    dataSources.put(entry.getKey(), entry.getValue());
                    talendDataSources.put(entry.getKey(), new routines.system.TalendDataSource(entry.getValue()));
		}

		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}


private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(new java.io.BufferedOutputStream(baos));

public String getExceptionStackTrace() {
	if ("failure".equals(this.getStatus())) {
		errorMessagePS.flush();
		return baos.toString();
	}
	return null;
}

private Exception exception;

public Exception getException() {
	if ("failure".equals(this.getStatus())) {
		return this.exception;
	}
	return null;
}

private class TalendException extends Exception {

	private static final long serialVersionUID = 1L;

	private java.util.Map<String, Object> globalMap = null;
	private Exception e = null;
	private String currentComponent = null;
	private String virtualComponentName = null;
	
	public void setVirtualComponentName (String virtualComponentName){
		this.virtualComponentName = virtualComponentName;
	}

	private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
		this.currentComponent= errorComponent;
		this.globalMap = globalMap;
		this.e = e;
	}

	public Exception getException() {
		return this.e;
	}

	public String getCurrentComponent() {
		return this.currentComponent;
	}

	
    public String getExceptionCauseMessage(Exception e){
        Throwable cause = e;
        String message = null;
        int i = 10;
        while (null != cause && 0 < i--) {
            message = cause.getMessage();
            if (null == message) {
                cause = cause.getCause();
            } else {
                break;          
            }
        }
        if (null == message) {
            message = e.getClass().getName();
        }   
        return message;
    }

	@Override
	public void printStackTrace() {
		if (!(e instanceof TalendException || e instanceof TDieException)) {
			if(virtualComponentName!=null && currentComponent.indexOf(virtualComponentName+"_")==0){
				globalMap.put(virtualComponentName+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			}
			globalMap.put(currentComponent+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
		}
		if (!(e instanceof TDieException)) {
			if(e instanceof TalendException){
				e.printStackTrace();
			} else {
				e.printStackTrace();
				e.printStackTrace(errorMessagePS);
				SA_Load_Tournois_apr_a_sep.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(SA_Load_Tournois_apr_a_sep.this, new Object[] { e , currentComponent, globalMap});
					break;
				}
			}

			if(!(e instanceof TDieException)){
			}
		} catch (Exception e) {
			this.e.printStackTrace();
		}
		}
	}
}

			public void tFileInputDelimited_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tLogRow_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBOutput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFileInputDelimited_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tLogRow_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBOutput_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFileInputDelimited_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_3_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tLogRow_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_3_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBOutput_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_3_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFileInputDelimited_4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_4_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tLogRow_4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_4_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBOutput_4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_4_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFileInputDelimited_5_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_5_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tLogRow_5_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_5_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBOutput_5_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_5_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFileInputDelimited_6_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_6_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tLogRow_6_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_6_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBOutput_6_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_6_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFileInputDelimited_7_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_7_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tLogRow_7_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_7_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBOutput_7_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_7_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFileInputDelimited_8_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_8_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tLogRow_8_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_8_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBOutput_8_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_8_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFileInputDelimited_9_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_9_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tLogRow_9_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_9_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBOutput_9_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_9_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFileInputDelimited_10_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_10_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tLogRow_10_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_10_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBOutput_10_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_10_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFileInputDelimited_11_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_11_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tLogRow_11_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_11_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBOutput_11_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_11_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFileInputDelimited_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tFileInputDelimited_2_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tFileInputDelimited_3_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tFileInputDelimited_4_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tFileInputDelimited_5_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tFileInputDelimited_6_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tFileInputDelimited_7_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tFileInputDelimited_8_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tFileInputDelimited_9_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tFileInputDelimited_10_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tFileInputDelimited_11_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
	






public static class row2Struct implements routines.system.IPersistableRow<row2Struct> {
    final static byte[] commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[0];
    static byte[] commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[0];

	
			    public String joueur1_nom;

				public String getJoueur1_nom () {
					return this.joueur1_nom;
				}
				
			    public String joueur1_prenom;

				public String getJoueur1_prenom () {
					return this.joueur1_prenom;
				}
				
			    public String joueur1_nationalite;

				public String getJoueur1_nationalite () {
					return this.joueur1_nationalite;
				}
				
			    public String joueur2_nom;

				public String getJoueur2_nom () {
					return this.joueur2_nom;
				}
				
			    public String joueur2_prenom;

				public String getJoueur2_prenom () {
					return this.joueur2_prenom;
				}
				
			    public String joueur2_nationalite;

				public String getJoueur2_nationalite () {
					return this.joueur2_nationalite;
				}
				
			    public Integer seed;

				public Integer getSeed () {
					return this.seed;
				}
				
			    public String round;

				public String getRound () {
					return this.round;
				}
				
			    public String score;

				public String getScore () {
					return this.score;
				}
				
			    public String resultat;

				public String getResultat () {
					return this.resultat;
				}
				
			    public java.util.Date date_tournoi;

				public java.util.Date getDate_tournoi () {
					return this.date_tournoi;
				}
				
			    public String nom_tournoi;

				public String getNom_tournoi () {
					return this.nom_tournoi;
				}
				
			    public String lieu_tournoi;

				public String getLieu_tournoi () {
					return this.lieu_tournoi;
				}
				
			    public BigDecimal prize_money;

				public BigDecimal getPrize_money () {
					return this.prize_money;
				}
				
			    public Integer points;

				public Integer getPoints () {
					return this.points;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length) {
				if(length < 1024 && commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length == 0) {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[1024];
				} else {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length);
			strReturn = new String(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length) {
				if(length < 1024 && commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length == 0) {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[1024];
				} else {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length);
			strReturn = new String(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep) {

        	try {

        		int length = 0;
		
					this.joueur1_nom = readString(dis);
					
					this.joueur1_prenom = readString(dis);
					
					this.joueur1_nationalite = readString(dis);
					
					this.joueur2_nom = readString(dis);
					
					this.joueur2_prenom = readString(dis);
					
					this.joueur2_nationalite = readString(dis);
					
						this.seed = readInteger(dis);
					
					this.round = readString(dis);
					
					this.score = readString(dis);
					
					this.resultat = readString(dis);
					
					this.date_tournoi = readDate(dis);
					
					this.nom_tournoi = readString(dis);
					
					this.lieu_tournoi = readString(dis);
					
						this.prize_money = (BigDecimal) dis.readObject();
					
						this.points = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep) {

        	try {

        		int length = 0;
		
					this.joueur1_nom = readString(dis);
					
					this.joueur1_prenom = readString(dis);
					
					this.joueur1_nationalite = readString(dis);
					
					this.joueur2_nom = readString(dis);
					
					this.joueur2_prenom = readString(dis);
					
					this.joueur2_nationalite = readString(dis);
					
						this.seed = readInteger(dis);
					
					this.round = readString(dis);
					
					this.score = readString(dis);
					
					this.resultat = readString(dis);
					
					this.date_tournoi = readDate(dis);
					
					this.nom_tournoi = readString(dis);
					
					this.lieu_tournoi = readString(dis);
					
						this.prize_money = (BigDecimal) dis.readObject();
					
						this.points = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.joueur1_nom,dos);
					
					// String
				
						writeString(this.joueur1_prenom,dos);
					
					// String
				
						writeString(this.joueur1_nationalite,dos);
					
					// String
				
						writeString(this.joueur2_nom,dos);
					
					// String
				
						writeString(this.joueur2_prenom,dos);
					
					// String
				
						writeString(this.joueur2_nationalite,dos);
					
					// Integer
				
						writeInteger(this.seed,dos);
					
					// String
				
						writeString(this.round,dos);
					
					// String
				
						writeString(this.score,dos);
					
					// String
				
						writeString(this.resultat,dos);
					
					// java.util.Date
				
						writeDate(this.date_tournoi,dos);
					
					// String
				
						writeString(this.nom_tournoi,dos);
					
					// String
				
						writeString(this.lieu_tournoi,dos);
					
					// BigDecimal
				
       			    	dos.writeObject(this.prize_money);
					
					// Integer
				
						writeInteger(this.points,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.joueur1_nom,dos);
					
					// String
				
						writeString(this.joueur1_prenom,dos);
					
					// String
				
						writeString(this.joueur1_nationalite,dos);
					
					// String
				
						writeString(this.joueur2_nom,dos);
					
					// String
				
						writeString(this.joueur2_prenom,dos);
					
					// String
				
						writeString(this.joueur2_nationalite,dos);
					
					// Integer
				
						writeInteger(this.seed,dos);
					
					// String
				
						writeString(this.round,dos);
					
					// String
				
						writeString(this.score,dos);
					
					// String
				
						writeString(this.resultat,dos);
					
					// java.util.Date
				
						writeDate(this.date_tournoi,dos);
					
					// String
				
						writeString(this.nom_tournoi,dos);
					
					// String
				
						writeString(this.lieu_tournoi,dos);
					
					// BigDecimal
				
       			    	dos.writeObject(this.prize_money);
					
					// Integer
				
						writeInteger(this.points,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("joueur1_nom="+joueur1_nom);
		sb.append(",joueur1_prenom="+joueur1_prenom);
		sb.append(",joueur1_nationalite="+joueur1_nationalite);
		sb.append(",joueur2_nom="+joueur2_nom);
		sb.append(",joueur2_prenom="+joueur2_prenom);
		sb.append(",joueur2_nationalite="+joueur2_nationalite);
		sb.append(",seed="+String.valueOf(seed));
		sb.append(",round="+round);
		sb.append(",score="+score);
		sb.append(",resultat="+resultat);
		sb.append(",date_tournoi="+String.valueOf(date_tournoi));
		sb.append(",nom_tournoi="+nom_tournoi);
		sb.append(",lieu_tournoi="+lieu_tournoi);
		sb.append(",prize_money="+String.valueOf(prize_money));
		sb.append(",points="+String.valueOf(points));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row2Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
    final static byte[] commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[0];
    static byte[] commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[0];

	
			    public String joueur1_nom;

				public String getJoueur1_nom () {
					return this.joueur1_nom;
				}
				
			    public String joueur1_prenom;

				public String getJoueur1_prenom () {
					return this.joueur1_prenom;
				}
				
			    public String joueur1_nationalite;

				public String getJoueur1_nationalite () {
					return this.joueur1_nationalite;
				}
				
			    public String joueur2_nom;

				public String getJoueur2_nom () {
					return this.joueur2_nom;
				}
				
			    public String joueur2_prenom;

				public String getJoueur2_prenom () {
					return this.joueur2_prenom;
				}
				
			    public String joueur2_nationalite;

				public String getJoueur2_nationalite () {
					return this.joueur2_nationalite;
				}
				
			    public Integer seed;

				public Integer getSeed () {
					return this.seed;
				}
				
			    public String round;

				public String getRound () {
					return this.round;
				}
				
			    public String score;

				public String getScore () {
					return this.score;
				}
				
			    public String resultat;

				public String getResultat () {
					return this.resultat;
				}
				
			    public java.util.Date date_tournoi;

				public java.util.Date getDate_tournoi () {
					return this.date_tournoi;
				}
				
			    public String nom_tournoi;

				public String getNom_tournoi () {
					return this.nom_tournoi;
				}
				
			    public String lieu_tournoi;

				public String getLieu_tournoi () {
					return this.lieu_tournoi;
				}
				
			    public BigDecimal prize_money;

				public BigDecimal getPrize_money () {
					return this.prize_money;
				}
				
			    public Integer points;

				public Integer getPoints () {
					return this.points;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length) {
				if(length < 1024 && commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length == 0) {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[1024];
				} else {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length);
			strReturn = new String(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length) {
				if(length < 1024 && commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length == 0) {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[1024];
				} else {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length);
			strReturn = new String(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep) {

        	try {

        		int length = 0;
		
					this.joueur1_nom = readString(dis);
					
					this.joueur1_prenom = readString(dis);
					
					this.joueur1_nationalite = readString(dis);
					
					this.joueur2_nom = readString(dis);
					
					this.joueur2_prenom = readString(dis);
					
					this.joueur2_nationalite = readString(dis);
					
						this.seed = readInteger(dis);
					
					this.round = readString(dis);
					
					this.score = readString(dis);
					
					this.resultat = readString(dis);
					
					this.date_tournoi = readDate(dis);
					
					this.nom_tournoi = readString(dis);
					
					this.lieu_tournoi = readString(dis);
					
						this.prize_money = (BigDecimal) dis.readObject();
					
						this.points = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep) {

        	try {

        		int length = 0;
		
					this.joueur1_nom = readString(dis);
					
					this.joueur1_prenom = readString(dis);
					
					this.joueur1_nationalite = readString(dis);
					
					this.joueur2_nom = readString(dis);
					
					this.joueur2_prenom = readString(dis);
					
					this.joueur2_nationalite = readString(dis);
					
						this.seed = readInteger(dis);
					
					this.round = readString(dis);
					
					this.score = readString(dis);
					
					this.resultat = readString(dis);
					
					this.date_tournoi = readDate(dis);
					
					this.nom_tournoi = readString(dis);
					
					this.lieu_tournoi = readString(dis);
					
						this.prize_money = (BigDecimal) dis.readObject();
					
						this.points = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.joueur1_nom,dos);
					
					// String
				
						writeString(this.joueur1_prenom,dos);
					
					// String
				
						writeString(this.joueur1_nationalite,dos);
					
					// String
				
						writeString(this.joueur2_nom,dos);
					
					// String
				
						writeString(this.joueur2_prenom,dos);
					
					// String
				
						writeString(this.joueur2_nationalite,dos);
					
					// Integer
				
						writeInteger(this.seed,dos);
					
					// String
				
						writeString(this.round,dos);
					
					// String
				
						writeString(this.score,dos);
					
					// String
				
						writeString(this.resultat,dos);
					
					// java.util.Date
				
						writeDate(this.date_tournoi,dos);
					
					// String
				
						writeString(this.nom_tournoi,dos);
					
					// String
				
						writeString(this.lieu_tournoi,dos);
					
					// BigDecimal
				
       			    	dos.writeObject(this.prize_money);
					
					// Integer
				
						writeInteger(this.points,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.joueur1_nom,dos);
					
					// String
				
						writeString(this.joueur1_prenom,dos);
					
					// String
				
						writeString(this.joueur1_nationalite,dos);
					
					// String
				
						writeString(this.joueur2_nom,dos);
					
					// String
				
						writeString(this.joueur2_prenom,dos);
					
					// String
				
						writeString(this.joueur2_nationalite,dos);
					
					// Integer
				
						writeInteger(this.seed,dos);
					
					// String
				
						writeString(this.round,dos);
					
					// String
				
						writeString(this.score,dos);
					
					// String
				
						writeString(this.resultat,dos);
					
					// java.util.Date
				
						writeDate(this.date_tournoi,dos);
					
					// String
				
						writeString(this.nom_tournoi,dos);
					
					// String
				
						writeString(this.lieu_tournoi,dos);
					
					// BigDecimal
				
       			    	dos.writeObject(this.prize_money);
					
					// Integer
				
						writeInteger(this.points,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("joueur1_nom="+joueur1_nom);
		sb.append(",joueur1_prenom="+joueur1_prenom);
		sb.append(",joueur1_nationalite="+joueur1_nationalite);
		sb.append(",joueur2_nom="+joueur2_nom);
		sb.append(",joueur2_prenom="+joueur2_prenom);
		sb.append(",joueur2_nationalite="+joueur2_nationalite);
		sb.append(",seed="+String.valueOf(seed));
		sb.append(",round="+round);
		sb.append(",score="+score);
		sb.append(",resultat="+resultat);
		sb.append(",date_tournoi="+String.valueOf(date_tournoi));
		sb.append(",nom_tournoi="+nom_tournoi);
		sb.append(",lieu_tournoi="+lieu_tournoi);
		sb.append(",prize_money="+String.valueOf(prize_money));
		sb.append(",points="+String.valueOf(points));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row1Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tFileInputDelimited_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tFileInputDelimited_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row1Struct row1 = new row1Struct();
row1Struct row2 = row1;





	
	/**
	 * [tDBOutput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBOutput_1", false);
		start_Hash.put("tDBOutput_1", System.currentTimeMillis());
		
	
	currentComponent="tDBOutput_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row2");
					}
				
		int tos_count_tDBOutput_1 = 0;
		





String dbschema_tDBOutput_1 = null;
	dbschema_tDBOutput_1 = "sa";
	

String tableName_tDBOutput_1 = null;
if(dbschema_tDBOutput_1 == null || dbschema_tDBOutput_1.trim().length() == 0) {
	tableName_tDBOutput_1 = ("sa_tournament_apr");
} else {
	tableName_tDBOutput_1 = dbschema_tDBOutput_1 + "\".\"" + ("sa_tournament_apr");
}


int nb_line_tDBOutput_1 = 0;
int nb_line_update_tDBOutput_1 = 0;
int nb_line_inserted_tDBOutput_1 = 0;
int nb_line_deleted_tDBOutput_1 = 0;
int nb_line_rejected_tDBOutput_1 = 0;

int deletedCount_tDBOutput_1=0;
int updatedCount_tDBOutput_1=0;
int insertedCount_tDBOutput_1=0;
int rowsToCommitCount_tDBOutput_1=0;
int rejectedCount_tDBOutput_1=0;

boolean whetherReject_tDBOutput_1 = false;

java.sql.Connection conn_tDBOutput_1 = null;
String dbUser_tDBOutput_1 = null;

	
    java.lang.Class.forName("org.postgresql.Driver");
    
        String url_tDBOutput_1 = "jdbc:postgresql://"+"localhost"+":"+"5432"+"/"+"padel_bi_SA";
    dbUser_tDBOutput_1 = "postgres";
 
	final String decryptedPassword_tDBOutput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:lyUTPFbTCD90ERYcPiAq9mC29k2RbI/kdWddbSIvdvzLZEDi3Q==");

    String dbPwd_tDBOutput_1 = decryptedPassword_tDBOutput_1;

    conn_tDBOutput_1 = java.sql.DriverManager.getConnection(url_tDBOutput_1,dbUser_tDBOutput_1,dbPwd_tDBOutput_1);
	
	resourceMap.put("conn_tDBOutput_1", conn_tDBOutput_1);
        conn_tDBOutput_1.setAutoCommit(false);
        int commitEvery_tDBOutput_1 = 10000;
        int commitCounter_tDBOutput_1 = 0;


   int batchSize_tDBOutput_1 = 10000;
   int batchSizeCounter_tDBOutput_1=0;

int count_tDBOutput_1=0;
	    String insert_tDBOutput_1 = "INSERT INTO \"" + tableName_tDBOutput_1 + "\" (\"joueur1_nom\",\"joueur1_prenom\",\"joueur1_nationalite\",\"joueur2_nom\",\"joueur2_prenom\",\"joueur2_nationalite\",\"seed\",\"round\",\"score\",\"resultat\",\"date_tournoi\",\"nom_tournoi\",\"lieu_tournoi\",\"prize_money\",\"points\") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	    
	    java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(insert_tDBOutput_1);
	    resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);
	    

 



/**
 * [tDBOutput_1 begin ] stop
 */



	
	/**
	 * [tLogRow_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tLogRow_1", false);
		start_Hash.put("tLogRow_1", System.currentTimeMillis());
		
	
	currentComponent="tLogRow_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row1");
					}
				
		int tos_count_tLogRow_1 = 0;
		

	///////////////////////
	
         class Util_tLogRow_1 {

        String[] des_top = { ".", ".", "-", "+" };

        String[] des_head = { "|=", "=|", "-", "+" };

        String[] des_bottom = { "'", "'", "-", "+" };

        String name="";

        java.util.List<String[]> list = new java.util.ArrayList<String[]>();

        int[] colLengths = new int[15];

        public void addRow(String[] row) {

            for (int i = 0; i < 15; i++) {
                if (row[i]!=null) {
                  colLengths[i] = Math.max(colLengths[i], row[i].length());
                }
            }
            list.add(row);
        }

        public void setTableName(String name) {

            this.name = name;
        }

            public StringBuilder format() {
            
                StringBuilder sb = new StringBuilder();
  
            
                    sb.append(print(des_top));
    
                    int totals = 0;
                    for (int i = 0; i < colLengths.length; i++) {
                        totals = totals + colLengths[i];
                    }
    
                    // name
                    sb.append("|");
                    int k = 0;
                    for (k = 0; k < (totals + 14 - name.length()) / 2; k++) {
                        sb.append(' ');
                    }
                    sb.append(name);
                    for (int i = 0; i < totals + 14 - name.length() - k; i++) {
                        sb.append(' ');
                    }
                    sb.append("|\n");

                    // head and rows
                    sb.append(print(des_head));
                    for (int i = 0; i < list.size(); i++) {
    
                        String[] row = list.get(i);
    
                        java.util.Formatter formatter = new java.util.Formatter(new StringBuilder());
                        
                        StringBuilder sbformat = new StringBuilder();                                             
        			        sbformat.append("|%1$-");
        			        sbformat.append(colLengths[0]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%2$-");
        			        sbformat.append(colLengths[1]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%3$-");
        			        sbformat.append(colLengths[2]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%4$-");
        			        sbformat.append(colLengths[3]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%5$-");
        			        sbformat.append(colLengths[4]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%6$-");
        			        sbformat.append(colLengths[5]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%7$-");
        			        sbformat.append(colLengths[6]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%8$-");
        			        sbformat.append(colLengths[7]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%9$-");
        			        sbformat.append(colLengths[8]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%10$-");
        			        sbformat.append(colLengths[9]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%11$-");
        			        sbformat.append(colLengths[10]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%12$-");
        			        sbformat.append(colLengths[11]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%13$-");
        			        sbformat.append(colLengths[12]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%14$-");
        			        sbformat.append(colLengths[13]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%15$-");
        			        sbformat.append(colLengths[14]);
        			        sbformat.append("s");
        			                      
                        sbformat.append("|\n");                    
       
                        formatter.format(sbformat.toString(), (Object[])row);	
                                
                        sb.append(formatter.toString());
                        if (i == 0)
                            sb.append(print(des_head)); // print the head
                    }
    
                    // end
                    sb.append(print(des_bottom));
                    return sb;
                }
            

            private StringBuilder print(String[] fillChars) {
                StringBuilder sb = new StringBuilder();
                //first column
                sb.append(fillChars[0]);                
                    for (int i = 0; i < colLengths[0] - fillChars[0].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);	                

                    for (int i = 0; i < colLengths[1] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[2] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[3] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[4] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[5] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[6] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[7] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[8] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[9] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[10] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[11] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[12] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[13] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                
                    //last column
                    for (int i = 0; i < colLengths[14] - fillChars[1].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }         
                sb.append(fillChars[1]);
                sb.append("\n");               
                return sb;
            }
            
            public boolean isTableEmpty(){
            	if (list.size() > 1)
            		return false;
            	return true;
            }
        }
        Util_tLogRow_1 util_tLogRow_1 = new Util_tLogRow_1();
        util_tLogRow_1.setTableName("tLogRow_1");
        util_tLogRow_1.addRow(new String[]{"joueur1_nom","joueur1_prenom","joueur1_nationalite","joueur2_nom","joueur2_prenom","joueur2_nationalite","seed","round","score","resultat","date_tournoi","nom_tournoi","lieu_tournoi","prize_money","points",});        
 		StringBuilder strBuffer_tLogRow_1 = null;
		int nb_line_tLogRow_1 = 0;
///////////////////////    			



 



/**
 * [tLogRow_1 begin ] stop
 */



	
	/**
	 * [tFileInputDelimited_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tFileInputDelimited_1", false);
		start_Hash.put("tFileInputDelimited_1", System.currentTimeMillis());
		
	
	currentComponent="tFileInputDelimited_1";

	
		int tos_count_tFileInputDelimited_1 = 0;
		
	
	
	
 
	
	
	final routines.system.RowState rowstate_tFileInputDelimited_1 = new routines.system.RowState();
	
	
				int nb_line_tFileInputDelimited_1 = 0;
				org.talend.fileprocess.FileInputDelimited fid_tFileInputDelimited_1 = null;
				int limit_tFileInputDelimited_1 = -1;
				try{
					
						Object filename_tFileInputDelimited_1 = "C:/Users/ASUS/Downloads/Sports/Sports/script_tournois/tournament_apr.csv";
						if(filename_tFileInputDelimited_1 instanceof java.io.InputStream){
							
			int footer_value_tFileInputDelimited_1 = 0, random_value_tFileInputDelimited_1 = -1;
			if(footer_value_tFileInputDelimited_1 >0 || random_value_tFileInputDelimited_1 > 0){
				throw new java.lang.Exception("When the input source is a stream,footer and random shouldn't be bigger than 0.");				
			}
		
						}
						try {
							fid_tFileInputDelimited_1 = new org.talend.fileprocess.FileInputDelimited("C:/Users/ASUS/Downloads/Sports/Sports/script_tournois/tournament_apr.csv", "UTF-8",",","\n",true,1,0,
									limit_tFileInputDelimited_1
								,-1, false);
						} catch(java.lang.Exception e) {
globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE",e.getMessage());
							
								
								System.err.println(e.getMessage());
							
						}
					
				    
					while (fid_tFileInputDelimited_1!=null && fid_tFileInputDelimited_1.nextRecord()) {
						rowstate_tFileInputDelimited_1.reset();
						
			    						row1 = null;			
												
									boolean whetherReject_tFileInputDelimited_1 = false;
									row1 = new row1Struct();
									try {
										
				int columnIndexWithD_tFileInputDelimited_1 = 0;
				
					String temp = ""; 
				
					columnIndexWithD_tFileInputDelimited_1 = 0;
					
							row1.joueur1_nom = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 1;
					
							row1.joueur1_prenom = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 2;
					
							row1.joueur1_nationalite = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 3;
					
							row1.joueur2_nom = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 4;
					
							row1.joueur2_prenom = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 5;
					
							row1.joueur2_nationalite = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 6;
					
						temp = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						if(temp.length() > 0) {
							
								try {
								
    								row1.seed = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_1) {
globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE",ex_tFileInputDelimited_1.getMessage());
									rowstate_tFileInputDelimited_1.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"seed", "row1", temp, ex_tFileInputDelimited_1), ex_tFileInputDelimited_1));
								}
    							
						} else {						
							
								
									row1.seed = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_1 = 7;
					
							row1.round = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 8;
					
							row1.score = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 9;
					
							row1.resultat = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 10;
					
						temp = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						if(temp.length() > 0) {
							
								try {
								
    									row1.date_tournoi = ParserUtils.parseTo_Date(temp, "yyyy-MM-dd");
    								
    							} catch(java.lang.Exception ex_tFileInputDelimited_1) {
globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE",ex_tFileInputDelimited_1.getMessage());
									rowstate_tFileInputDelimited_1.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"date_tournoi", "row1", temp, ex_tFileInputDelimited_1), ex_tFileInputDelimited_1));
								}
    							
						} else {						
							
								
									row1.date_tournoi = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_1 = 11;
					
							row1.nom_tournoi = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 12;
					
							row1.lieu_tournoi = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 13;
					
						temp = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						if(temp.length() > 0) {
							
								try {
								
    								row1.prize_money = ParserUtils.parseTo_BigDecimal(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_1) {
globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE",ex_tFileInputDelimited_1.getMessage());
									rowstate_tFileInputDelimited_1.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"prize_money", "row1", temp, ex_tFileInputDelimited_1), ex_tFileInputDelimited_1));
								}
    							
						} else {						
							
								
									row1.prize_money = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_1 = 14;
					
						temp = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						if(temp.length() > 0) {
							
								try {
								
    								row1.points = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_1) {
globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE",ex_tFileInputDelimited_1.getMessage());
									rowstate_tFileInputDelimited_1.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"points", "row1", temp, ex_tFileInputDelimited_1), ex_tFileInputDelimited_1));
								}
    							
						} else {						
							
								
									row1.points = null;
								
							
						}
					
				
				
										
										if(rowstate_tFileInputDelimited_1.getException()!=null) {
											throw rowstate_tFileInputDelimited_1.getException();
										}
										
										
							
			    					} catch (java.lang.Exception e) {
globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE",e.getMessage());
			        					whetherReject_tFileInputDelimited_1 = true;
			        					
			                					System.err.println(e.getMessage());
			                					row1 = null;
			                				
										
			    					}
								

 



/**
 * [tFileInputDelimited_1 begin ] stop
 */
	
	/**
	 * [tFileInputDelimited_1 main ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_1";

	

 


	tos_count_tFileInputDelimited_1++;

/**
 * [tFileInputDelimited_1 main ] stop
 */
	
	/**
	 * [tFileInputDelimited_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_1";

	

 



/**
 * [tFileInputDelimited_1 process_data_begin ] stop
 */
// Start of branch "row1"
if(row1 != null) { 



	
	/**
	 * [tLogRow_1 main ] start
	 */

	

	
	
	currentComponent="tLogRow_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row1"
						
						);
					}
					
///////////////////////		
						

				
				String[] row_tLogRow_1 = new String[15];
   				
	    		if(row1.joueur1_nom != null) { //              
                 row_tLogRow_1[0]=    						    
				                String.valueOf(row1.joueur1_nom)			
					          ;	
							
	    		} //			
    			   				
	    		if(row1.joueur1_prenom != null) { //              
                 row_tLogRow_1[1]=    						    
				                String.valueOf(row1.joueur1_prenom)			
					          ;	
							
	    		} //			
    			   				
	    		if(row1.joueur1_nationalite != null) { //              
                 row_tLogRow_1[2]=    						    
				                String.valueOf(row1.joueur1_nationalite)			
					          ;	
							
	    		} //			
    			   				
	    		if(row1.joueur2_nom != null) { //              
                 row_tLogRow_1[3]=    						    
				                String.valueOf(row1.joueur2_nom)			
					          ;	
							
	    		} //			
    			   				
	    		if(row1.joueur2_prenom != null) { //              
                 row_tLogRow_1[4]=    						    
				                String.valueOf(row1.joueur2_prenom)			
					          ;	
							
	    		} //			
    			   				
	    		if(row1.joueur2_nationalite != null) { //              
                 row_tLogRow_1[5]=    						    
				                String.valueOf(row1.joueur2_nationalite)			
					          ;	
							
	    		} //			
    			   				
	    		if(row1.seed != null) { //              
                 row_tLogRow_1[6]=    						    
				                String.valueOf(row1.seed)			
					          ;	
							
	    		} //			
    			   				
	    		if(row1.round != null) { //              
                 row_tLogRow_1[7]=    						    
				                String.valueOf(row1.round)			
					          ;	
							
	    		} //			
    			   				
	    		if(row1.score != null) { //              
                 row_tLogRow_1[8]=    						    
				                String.valueOf(row1.score)			
					          ;	
							
	    		} //			
    			   				
	    		if(row1.resultat != null) { //              
                 row_tLogRow_1[9]=    						    
				                String.valueOf(row1.resultat)			
					          ;	
							
	    		} //			
    			   				
	    		if(row1.date_tournoi != null) { //              
                 row_tLogRow_1[10]=    						
								FormatterUtils.format_Date(row1.date_tournoi, "yyyy-MM-dd")
					          ;	
							
	    		} //			
    			   				
	    		if(row1.nom_tournoi != null) { //              
                 row_tLogRow_1[11]=    						    
				                String.valueOf(row1.nom_tournoi)			
					          ;	
							
	    		} //			
    			   				
	    		if(row1.lieu_tournoi != null) { //              
                 row_tLogRow_1[12]=    						    
				                String.valueOf(row1.lieu_tournoi)			
					          ;	
							
	    		} //			
    			   				
	    		if(row1.prize_money != null) { //              
                 row_tLogRow_1[13]=    						
								row1.prize_money.toPlainString()
					          ;	
							
	    		} //			
    			   				
	    		if(row1.points != null) { //              
                 row_tLogRow_1[14]=    						    
				                String.valueOf(row1.points)			
					          ;	
							
	    		} //			
    			 

				util_tLogRow_1.addRow(row_tLogRow_1);	
				nb_line_tLogRow_1++;
//////

//////                    
                    
///////////////////////    			

 
     row2 = row1;


	tos_count_tLogRow_1++;

/**
 * [tLogRow_1 main ] stop
 */
	
	/**
	 * [tLogRow_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tLogRow_1";

	

 



/**
 * [tLogRow_1 process_data_begin ] stop
 */

	
	/**
	 * [tDBOutput_1 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row2"
						
						);
					}
					



        whetherReject_tDBOutput_1 = false;
                    if(row2.joueur1_nom == null) {
pstmt_tDBOutput_1.setNull(1, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(1, row2.joueur1_nom);
}

                    if(row2.joueur1_prenom == null) {
pstmt_tDBOutput_1.setNull(2, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(2, row2.joueur1_prenom);
}

                    if(row2.joueur1_nationalite == null) {
pstmt_tDBOutput_1.setNull(3, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(3, row2.joueur1_nationalite);
}

                    if(row2.joueur2_nom == null) {
pstmt_tDBOutput_1.setNull(4, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(4, row2.joueur2_nom);
}

                    if(row2.joueur2_prenom == null) {
pstmt_tDBOutput_1.setNull(5, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(5, row2.joueur2_prenom);
}

                    if(row2.joueur2_nationalite == null) {
pstmt_tDBOutput_1.setNull(6, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(6, row2.joueur2_nationalite);
}

                    if(row2.seed == null) {
pstmt_tDBOutput_1.setNull(7, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_1.setInt(7, row2.seed);
}

                    if(row2.round == null) {
pstmt_tDBOutput_1.setNull(8, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(8, row2.round);
}

                    if(row2.score == null) {
pstmt_tDBOutput_1.setNull(9, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(9, row2.score);
}

                    if(row2.resultat == null) {
pstmt_tDBOutput_1.setNull(10, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(10, row2.resultat);
}

                    if(row2.date_tournoi != null) {
pstmt_tDBOutput_1.setTimestamp(11, new java.sql.Timestamp(row2.date_tournoi.getTime()));
} else {
pstmt_tDBOutput_1.setNull(11, java.sql.Types.TIMESTAMP);
}

                    if(row2.nom_tournoi == null) {
pstmt_tDBOutput_1.setNull(12, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(12, row2.nom_tournoi);
}

                    if(row2.lieu_tournoi == null) {
pstmt_tDBOutput_1.setNull(13, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(13, row2.lieu_tournoi);
}

                    pstmt_tDBOutput_1.setBigDecimal(14, row2.prize_money);

                    if(row2.points == null) {
pstmt_tDBOutput_1.setNull(15, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_1.setInt(15, row2.points);
}

			
    		pstmt_tDBOutput_1.addBatch();
    		nb_line_tDBOutput_1++;
    		  
    		  
    		  batchSizeCounter_tDBOutput_1++;
    		  
    			if ((batchSize_tDBOutput_1 > 0) && (batchSize_tDBOutput_1 <= batchSizeCounter_tDBOutput_1)) {
                try {
						int countSum_tDBOutput_1 = 0;
						    
						for(int countEach_tDBOutput_1: pstmt_tDBOutput_1.executeBatch()) {
							countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
						}
				    	rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
				    	
				    		insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
				    	
            	    	batchSizeCounter_tDBOutput_1 = 0;
                }catch (java.sql.BatchUpdateException e_tDBOutput_1){
globalMap.put("tDBOutput_1_ERROR_MESSAGE",e_tDBOutput_1.getMessage());
				    	java.sql.SQLException ne_tDBOutput_1 = e_tDBOutput_1.getNextException(),sqle_tDBOutput_1=null;
				    	String errormessage_tDBOutput_1;
						if (ne_tDBOutput_1 != null) {
							// build new exception to provide the original cause
							sqle_tDBOutput_1 = new java.sql.SQLException(e_tDBOutput_1.getMessage() + "\ncaused by: " + ne_tDBOutput_1.getMessage(), ne_tDBOutput_1.getSQLState(), ne_tDBOutput_1.getErrorCode(), ne_tDBOutput_1);
							errormessage_tDBOutput_1 = sqle_tDBOutput_1.getMessage();
						}else{
							errormessage_tDBOutput_1 = e_tDBOutput_1.getMessage();
						}
				    	
				    	int countSum_tDBOutput_1 = 0;
						for(int countEach_tDBOutput_1: e_tDBOutput_1.getUpdateCounts()) {
							countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
						}
						rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
						
				    		insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
				    	
				    	System.err.println(errormessage_tDBOutput_1);
				    	
					}
    			}
    		
    		    commitCounter_tDBOutput_1++;
                if(commitEvery_tDBOutput_1 <= commitCounter_tDBOutput_1) {
                if ((batchSize_tDBOutput_1 > 0) && (batchSizeCounter_tDBOutput_1 > 0)) {
                try {
                		int countSum_tDBOutput_1 = 0;
                		    
						for(int countEach_tDBOutput_1: pstmt_tDBOutput_1.executeBatch()) {
							countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
						}
            	    	rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
            	    	
            	    		insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
            	    	
                batchSizeCounter_tDBOutput_1 = 0;
               }catch (java.sql.BatchUpdateException e_tDBOutput_1){
globalMap.put("tDBOutput_1_ERROR_MESSAGE",e_tDBOutput_1.getMessage());
			    	java.sql.SQLException ne_tDBOutput_1 = e_tDBOutput_1.getNextException(),sqle_tDBOutput_1=null;
			    	String errormessage_tDBOutput_1;
					if (ne_tDBOutput_1 != null) {
						// build new exception to provide the original cause
						sqle_tDBOutput_1 = new java.sql.SQLException(e_tDBOutput_1.getMessage() + "\ncaused by: " + ne_tDBOutput_1.getMessage(), ne_tDBOutput_1.getSQLState(), ne_tDBOutput_1.getErrorCode(), ne_tDBOutput_1);
						errormessage_tDBOutput_1 = sqle_tDBOutput_1.getMessage();
					}else{
						errormessage_tDBOutput_1 = e_tDBOutput_1.getMessage();
					}
			    	
			    	int countSum_tDBOutput_1 = 0;
					for(int countEach_tDBOutput_1: e_tDBOutput_1.getUpdateCounts()) {
						countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
					}
					rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
					
			    		insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
			    	
			    	System.err.println(errormessage_tDBOutput_1);
			    	
				}
            }
                    if(rowsToCommitCount_tDBOutput_1 != 0){
                    	
                    }
                    conn_tDBOutput_1.commit();
                    if(rowsToCommitCount_tDBOutput_1 != 0){
                    	
                    	rowsToCommitCount_tDBOutput_1 = 0;
                    }
                    commitCounter_tDBOutput_1=0;
                }

 


	tos_count_tDBOutput_1++;

/**
 * [tDBOutput_1 main ] stop
 */
	
	/**
	 * [tDBOutput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	

 



/**
 * [tDBOutput_1 process_data_begin ] stop
 */
	
	/**
	 * [tDBOutput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	

 



/**
 * [tDBOutput_1 process_data_end ] stop
 */



	
	/**
	 * [tLogRow_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tLogRow_1";

	

 



/**
 * [tLogRow_1 process_data_end ] stop
 */

} // End of branch "row1"




	
	/**
	 * [tFileInputDelimited_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_1";

	

 



/**
 * [tFileInputDelimited_1 process_data_end ] stop
 */
	
	/**
	 * [tFileInputDelimited_1 end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_1";

	



            }
            }finally{
                if(!((Object)("C:/Users/ASUS/Downloads/Sports/Sports/script_tournois/tournament_apr.csv") instanceof java.io.InputStream)){
                	if(fid_tFileInputDelimited_1!=null){
                		fid_tFileInputDelimited_1.close();
                	}
                }
                if(fid_tFileInputDelimited_1!=null){
                	globalMap.put("tFileInputDelimited_1_NB_LINE", fid_tFileInputDelimited_1.getRowNumber());
					
                }
			}
			  

 

ok_Hash.put("tFileInputDelimited_1", true);
end_Hash.put("tFileInputDelimited_1", System.currentTimeMillis());




/**
 * [tFileInputDelimited_1 end ] stop
 */

	
	/**
	 * [tLogRow_1 end ] start
	 */

	

	
	
	currentComponent="tLogRow_1";

	


//////

                    
                    java.io.PrintStream consoleOut_tLogRow_1 = null;
                    if (globalMap.get("tLogRow_CONSOLE")!=null)
                    {
                    	consoleOut_tLogRow_1 = (java.io.PrintStream) globalMap.get("tLogRow_CONSOLE");
                    }
                    else
                    {
                    	consoleOut_tLogRow_1 = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));
                    	globalMap.put("tLogRow_CONSOLE",consoleOut_tLogRow_1);
                    }
                    
                    consoleOut_tLogRow_1.println(util_tLogRow_1.format().toString());
                    consoleOut_tLogRow_1.flush();
//////
globalMap.put("tLogRow_1_NB_LINE",nb_line_tLogRow_1);

///////////////////////    			

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row1");
			  	}
			  	
 

ok_Hash.put("tLogRow_1", true);
end_Hash.put("tLogRow_1", System.currentTimeMillis());




/**
 * [tLogRow_1 end ] stop
 */

	
	/**
	 * [tDBOutput_1 end ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	



	    try {
				int countSum_tDBOutput_1 = 0;
				if (pstmt_tDBOutput_1 != null && batchSizeCounter_tDBOutput_1 > 0) {
						
					for(int countEach_tDBOutput_1: pstmt_tDBOutput_1.executeBatch()) {
						countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
					}
					rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
						
				}
		    	
		    		insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
		    	
	    }catch (java.sql.BatchUpdateException e_tDBOutput_1){
globalMap.put("tDBOutput_1_ERROR_MESSAGE",e_tDBOutput_1.getMessage());
	    	java.sql.SQLException ne_tDBOutput_1 = e_tDBOutput_1.getNextException(),sqle_tDBOutput_1=null;
	    	String errormessage_tDBOutput_1;
			if (ne_tDBOutput_1 != null) {
				// build new exception to provide the original cause
				sqle_tDBOutput_1 = new java.sql.SQLException(e_tDBOutput_1.getMessage() + "\ncaused by: " + ne_tDBOutput_1.getMessage(), ne_tDBOutput_1.getSQLState(), ne_tDBOutput_1.getErrorCode(), ne_tDBOutput_1);
				errormessage_tDBOutput_1 = sqle_tDBOutput_1.getMessage();
			}else{
				errormessage_tDBOutput_1 = e_tDBOutput_1.getMessage();
			}
	    	
	    	int countSum_tDBOutput_1 = 0;
			for(int countEach_tDBOutput_1: e_tDBOutput_1.getUpdateCounts()) {
				countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
			}
			rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
			
	    		insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
	    	
	    	System.err.println(errormessage_tDBOutput_1);
	    	
		}
	    
        if(pstmt_tDBOutput_1 != null) {
        		
            pstmt_tDBOutput_1.close();
            resourceMap.remove("pstmt_tDBOutput_1");
        }
    resourceMap.put("statementClosed_tDBOutput_1", true);
			if(rowsToCommitCount_tDBOutput_1 != 0){
				
			}
			conn_tDBOutput_1.commit();
			if(rowsToCommitCount_tDBOutput_1 != 0){
				
				rowsToCommitCount_tDBOutput_1 = 0;
			}
			commitCounter_tDBOutput_1 = 0;
		
    	conn_tDBOutput_1 .close();
    	
    	resourceMap.put("finish_tDBOutput_1", true);
    	

	nb_line_deleted_tDBOutput_1=nb_line_deleted_tDBOutput_1+ deletedCount_tDBOutput_1;
	nb_line_update_tDBOutput_1=nb_line_update_tDBOutput_1 + updatedCount_tDBOutput_1;
	nb_line_inserted_tDBOutput_1=nb_line_inserted_tDBOutput_1 + insertedCount_tDBOutput_1;
	nb_line_rejected_tDBOutput_1=nb_line_rejected_tDBOutput_1 + rejectedCount_tDBOutput_1;
	
        globalMap.put("tDBOutput_1_NB_LINE",nb_line_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_UPDATED",nb_line_update_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_INSERTED",nb_line_inserted_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_DELETED",nb_line_deleted_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_1);
    

	


				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row2");
			  	}
			  	
 

ok_Hash.put("tDBOutput_1", true);
end_Hash.put("tDBOutput_1", System.currentTimeMillis());




/**
 * [tDBOutput_1 end ] stop
 */






				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tFileInputDelimited_1 finally ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_1";

	

 



/**
 * [tFileInputDelimited_1 finally ] stop
 */

	
	/**
	 * [tLogRow_1 finally ] start
	 */

	

	
	
	currentComponent="tLogRow_1";

	

 



/**
 * [tLogRow_1 finally ] stop
 */

	
	/**
	 * [tDBOutput_1 finally ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	



    try {
    if (resourceMap.get("statementClosed_tDBOutput_1") == null) {
                java.sql.PreparedStatement pstmtToClose_tDBOutput_1 = null;
                if ((pstmtToClose_tDBOutput_1 = (java.sql.PreparedStatement) resourceMap.remove("pstmt_tDBOutput_1")) != null) {
                    pstmtToClose_tDBOutput_1.close();
                }
    }
    } finally {
        if(resourceMap.get("finish_tDBOutput_1") == null){
            java.sql.Connection ctn_tDBOutput_1 = null;
            if((ctn_tDBOutput_1 = (java.sql.Connection)resourceMap.get("conn_tDBOutput_1")) != null){
                try {
                    ctn_tDBOutput_1.close();
                } catch (java.sql.SQLException sqlEx_tDBOutput_1) {
                    String errorMessage_tDBOutput_1 = "failed to close the connection in tDBOutput_1 :" + sqlEx_tDBOutput_1.getMessage();
                    System.err.println(errorMessage_tDBOutput_1);
                }
            }
        }
    }
 



/**
 * [tDBOutput_1 finally ] stop
 */






				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tFileInputDelimited_1_SUBPROCESS_STATE", 1);
	}
	


public static class row4Struct implements routines.system.IPersistableRow<row4Struct> {
    final static byte[] commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[0];
    static byte[] commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[0];

	
			    public String joueur1_nom;

				public String getJoueur1_nom () {
					return this.joueur1_nom;
				}
				
			    public String joueur1_prenom;

				public String getJoueur1_prenom () {
					return this.joueur1_prenom;
				}
				
			    public String joueur1_nationalite;

				public String getJoueur1_nationalite () {
					return this.joueur1_nationalite;
				}
				
			    public String joueur2_nom;

				public String getJoueur2_nom () {
					return this.joueur2_nom;
				}
				
			    public String joueur2_prenom;

				public String getJoueur2_prenom () {
					return this.joueur2_prenom;
				}
				
			    public String joueur2_nationalite;

				public String getJoueur2_nationalite () {
					return this.joueur2_nationalite;
				}
				
			    public Integer seed;

				public Integer getSeed () {
					return this.seed;
				}
				
			    public String round;

				public String getRound () {
					return this.round;
				}
				
			    public String score;

				public String getScore () {
					return this.score;
				}
				
			    public String resultat;

				public String getResultat () {
					return this.resultat;
				}
				
			    public java.util.Date date_tournoi;

				public java.util.Date getDate_tournoi () {
					return this.date_tournoi;
				}
				
			    public String nom_tournoi;

				public String getNom_tournoi () {
					return this.nom_tournoi;
				}
				
			    public String lieu_tournoi;

				public String getLieu_tournoi () {
					return this.lieu_tournoi;
				}
				
			    public BigDecimal prize_money;

				public BigDecimal getPrize_money () {
					return this.prize_money;
				}
				
			    public Integer points;

				public Integer getPoints () {
					return this.points;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length) {
				if(length < 1024 && commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length == 0) {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[1024];
				} else {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length);
			strReturn = new String(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length) {
				if(length < 1024 && commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length == 0) {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[1024];
				} else {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length);
			strReturn = new String(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep) {

        	try {

        		int length = 0;
		
					this.joueur1_nom = readString(dis);
					
					this.joueur1_prenom = readString(dis);
					
					this.joueur1_nationalite = readString(dis);
					
					this.joueur2_nom = readString(dis);
					
					this.joueur2_prenom = readString(dis);
					
					this.joueur2_nationalite = readString(dis);
					
						this.seed = readInteger(dis);
					
					this.round = readString(dis);
					
					this.score = readString(dis);
					
					this.resultat = readString(dis);
					
					this.date_tournoi = readDate(dis);
					
					this.nom_tournoi = readString(dis);
					
					this.lieu_tournoi = readString(dis);
					
						this.prize_money = (BigDecimal) dis.readObject();
					
						this.points = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep) {

        	try {

        		int length = 0;
		
					this.joueur1_nom = readString(dis);
					
					this.joueur1_prenom = readString(dis);
					
					this.joueur1_nationalite = readString(dis);
					
					this.joueur2_nom = readString(dis);
					
					this.joueur2_prenom = readString(dis);
					
					this.joueur2_nationalite = readString(dis);
					
						this.seed = readInteger(dis);
					
					this.round = readString(dis);
					
					this.score = readString(dis);
					
					this.resultat = readString(dis);
					
					this.date_tournoi = readDate(dis);
					
					this.nom_tournoi = readString(dis);
					
					this.lieu_tournoi = readString(dis);
					
						this.prize_money = (BigDecimal) dis.readObject();
					
						this.points = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.joueur1_nom,dos);
					
					// String
				
						writeString(this.joueur1_prenom,dos);
					
					// String
				
						writeString(this.joueur1_nationalite,dos);
					
					// String
				
						writeString(this.joueur2_nom,dos);
					
					// String
				
						writeString(this.joueur2_prenom,dos);
					
					// String
				
						writeString(this.joueur2_nationalite,dos);
					
					// Integer
				
						writeInteger(this.seed,dos);
					
					// String
				
						writeString(this.round,dos);
					
					// String
				
						writeString(this.score,dos);
					
					// String
				
						writeString(this.resultat,dos);
					
					// java.util.Date
				
						writeDate(this.date_tournoi,dos);
					
					// String
				
						writeString(this.nom_tournoi,dos);
					
					// String
				
						writeString(this.lieu_tournoi,dos);
					
					// BigDecimal
				
       			    	dos.writeObject(this.prize_money);
					
					// Integer
				
						writeInteger(this.points,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.joueur1_nom,dos);
					
					// String
				
						writeString(this.joueur1_prenom,dos);
					
					// String
				
						writeString(this.joueur1_nationalite,dos);
					
					// String
				
						writeString(this.joueur2_nom,dos);
					
					// String
				
						writeString(this.joueur2_prenom,dos);
					
					// String
				
						writeString(this.joueur2_nationalite,dos);
					
					// Integer
				
						writeInteger(this.seed,dos);
					
					// String
				
						writeString(this.round,dos);
					
					// String
				
						writeString(this.score,dos);
					
					// String
				
						writeString(this.resultat,dos);
					
					// java.util.Date
				
						writeDate(this.date_tournoi,dos);
					
					// String
				
						writeString(this.nom_tournoi,dos);
					
					// String
				
						writeString(this.lieu_tournoi,dos);
					
					// BigDecimal
				
       			    	dos.writeObject(this.prize_money);
					
					// Integer
				
						writeInteger(this.points,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("joueur1_nom="+joueur1_nom);
		sb.append(",joueur1_prenom="+joueur1_prenom);
		sb.append(",joueur1_nationalite="+joueur1_nationalite);
		sb.append(",joueur2_nom="+joueur2_nom);
		sb.append(",joueur2_prenom="+joueur2_prenom);
		sb.append(",joueur2_nationalite="+joueur2_nationalite);
		sb.append(",seed="+String.valueOf(seed));
		sb.append(",round="+round);
		sb.append(",score="+score);
		sb.append(",resultat="+resultat);
		sb.append(",date_tournoi="+String.valueOf(date_tournoi));
		sb.append(",nom_tournoi="+nom_tournoi);
		sb.append(",lieu_tournoi="+lieu_tournoi);
		sb.append(",prize_money="+String.valueOf(prize_money));
		sb.append(",points="+String.valueOf(points));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row4Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class row3Struct implements routines.system.IPersistableRow<row3Struct> {
    final static byte[] commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[0];
    static byte[] commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[0];

	
			    public String joueur1_nom;

				public String getJoueur1_nom () {
					return this.joueur1_nom;
				}
				
			    public String joueur1_prenom;

				public String getJoueur1_prenom () {
					return this.joueur1_prenom;
				}
				
			    public String joueur1_nationalite;

				public String getJoueur1_nationalite () {
					return this.joueur1_nationalite;
				}
				
			    public String joueur2_nom;

				public String getJoueur2_nom () {
					return this.joueur2_nom;
				}
				
			    public String joueur2_prenom;

				public String getJoueur2_prenom () {
					return this.joueur2_prenom;
				}
				
			    public String joueur2_nationalite;

				public String getJoueur2_nationalite () {
					return this.joueur2_nationalite;
				}
				
			    public Integer seed;

				public Integer getSeed () {
					return this.seed;
				}
				
			    public String round;

				public String getRound () {
					return this.round;
				}
				
			    public String score;

				public String getScore () {
					return this.score;
				}
				
			    public String resultat;

				public String getResultat () {
					return this.resultat;
				}
				
			    public java.util.Date date_tournoi;

				public java.util.Date getDate_tournoi () {
					return this.date_tournoi;
				}
				
			    public String nom_tournoi;

				public String getNom_tournoi () {
					return this.nom_tournoi;
				}
				
			    public String lieu_tournoi;

				public String getLieu_tournoi () {
					return this.lieu_tournoi;
				}
				
			    public BigDecimal prize_money;

				public BigDecimal getPrize_money () {
					return this.prize_money;
				}
				
			    public Integer points;

				public Integer getPoints () {
					return this.points;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length) {
				if(length < 1024 && commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length == 0) {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[1024];
				} else {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length);
			strReturn = new String(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length) {
				if(length < 1024 && commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length == 0) {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[1024];
				} else {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length);
			strReturn = new String(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep) {

        	try {

        		int length = 0;
		
					this.joueur1_nom = readString(dis);
					
					this.joueur1_prenom = readString(dis);
					
					this.joueur1_nationalite = readString(dis);
					
					this.joueur2_nom = readString(dis);
					
					this.joueur2_prenom = readString(dis);
					
					this.joueur2_nationalite = readString(dis);
					
						this.seed = readInteger(dis);
					
					this.round = readString(dis);
					
					this.score = readString(dis);
					
					this.resultat = readString(dis);
					
					this.date_tournoi = readDate(dis);
					
					this.nom_tournoi = readString(dis);
					
					this.lieu_tournoi = readString(dis);
					
						this.prize_money = (BigDecimal) dis.readObject();
					
						this.points = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep) {

        	try {

        		int length = 0;
		
					this.joueur1_nom = readString(dis);
					
					this.joueur1_prenom = readString(dis);
					
					this.joueur1_nationalite = readString(dis);
					
					this.joueur2_nom = readString(dis);
					
					this.joueur2_prenom = readString(dis);
					
					this.joueur2_nationalite = readString(dis);
					
						this.seed = readInteger(dis);
					
					this.round = readString(dis);
					
					this.score = readString(dis);
					
					this.resultat = readString(dis);
					
					this.date_tournoi = readDate(dis);
					
					this.nom_tournoi = readString(dis);
					
					this.lieu_tournoi = readString(dis);
					
						this.prize_money = (BigDecimal) dis.readObject();
					
						this.points = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.joueur1_nom,dos);
					
					// String
				
						writeString(this.joueur1_prenom,dos);
					
					// String
				
						writeString(this.joueur1_nationalite,dos);
					
					// String
				
						writeString(this.joueur2_nom,dos);
					
					// String
				
						writeString(this.joueur2_prenom,dos);
					
					// String
				
						writeString(this.joueur2_nationalite,dos);
					
					// Integer
				
						writeInteger(this.seed,dos);
					
					// String
				
						writeString(this.round,dos);
					
					// String
				
						writeString(this.score,dos);
					
					// String
				
						writeString(this.resultat,dos);
					
					// java.util.Date
				
						writeDate(this.date_tournoi,dos);
					
					// String
				
						writeString(this.nom_tournoi,dos);
					
					// String
				
						writeString(this.lieu_tournoi,dos);
					
					// BigDecimal
				
       			    	dos.writeObject(this.prize_money);
					
					// Integer
				
						writeInteger(this.points,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.joueur1_nom,dos);
					
					// String
				
						writeString(this.joueur1_prenom,dos);
					
					// String
				
						writeString(this.joueur1_nationalite,dos);
					
					// String
				
						writeString(this.joueur2_nom,dos);
					
					// String
				
						writeString(this.joueur2_prenom,dos);
					
					// String
				
						writeString(this.joueur2_nationalite,dos);
					
					// Integer
				
						writeInteger(this.seed,dos);
					
					// String
				
						writeString(this.round,dos);
					
					// String
				
						writeString(this.score,dos);
					
					// String
				
						writeString(this.resultat,dos);
					
					// java.util.Date
				
						writeDate(this.date_tournoi,dos);
					
					// String
				
						writeString(this.nom_tournoi,dos);
					
					// String
				
						writeString(this.lieu_tournoi,dos);
					
					// BigDecimal
				
       			    	dos.writeObject(this.prize_money);
					
					// Integer
				
						writeInteger(this.points,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("joueur1_nom="+joueur1_nom);
		sb.append(",joueur1_prenom="+joueur1_prenom);
		sb.append(",joueur1_nationalite="+joueur1_nationalite);
		sb.append(",joueur2_nom="+joueur2_nom);
		sb.append(",joueur2_prenom="+joueur2_prenom);
		sb.append(",joueur2_nationalite="+joueur2_nationalite);
		sb.append(",seed="+String.valueOf(seed));
		sb.append(",round="+round);
		sb.append(",score="+score);
		sb.append(",resultat="+resultat);
		sb.append(",date_tournoi="+String.valueOf(date_tournoi));
		sb.append(",nom_tournoi="+nom_tournoi);
		sb.append(",lieu_tournoi="+lieu_tournoi);
		sb.append(",prize_money="+String.valueOf(prize_money));
		sb.append(",points="+String.valueOf(points));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row3Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tFileInputDelimited_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tFileInputDelimited_2_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row3Struct row3 = new row3Struct();
row3Struct row4 = row3;





	
	/**
	 * [tDBOutput_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBOutput_2", false);
		start_Hash.put("tDBOutput_2", System.currentTimeMillis());
		
	
	currentComponent="tDBOutput_2";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row4");
					}
				
		int tos_count_tDBOutput_2 = 0;
		





String dbschema_tDBOutput_2 = null;
	dbschema_tDBOutput_2 = "sa";
	

String tableName_tDBOutput_2 = null;
if(dbschema_tDBOutput_2 == null || dbschema_tDBOutput_2.trim().length() == 0) {
	tableName_tDBOutput_2 = ("sa_tournament_jul");
} else {
	tableName_tDBOutput_2 = dbschema_tDBOutput_2 + "\".\"" + ("sa_tournament_jul");
}


int nb_line_tDBOutput_2 = 0;
int nb_line_update_tDBOutput_2 = 0;
int nb_line_inserted_tDBOutput_2 = 0;
int nb_line_deleted_tDBOutput_2 = 0;
int nb_line_rejected_tDBOutput_2 = 0;

int deletedCount_tDBOutput_2=0;
int updatedCount_tDBOutput_2=0;
int insertedCount_tDBOutput_2=0;
int rowsToCommitCount_tDBOutput_2=0;
int rejectedCount_tDBOutput_2=0;

boolean whetherReject_tDBOutput_2 = false;

java.sql.Connection conn_tDBOutput_2 = null;
String dbUser_tDBOutput_2 = null;

	
    java.lang.Class.forName("org.postgresql.Driver");
    
        String url_tDBOutput_2 = "jdbc:postgresql://"+"localhost"+":"+"5432"+"/"+"padel_bi_SA";
    dbUser_tDBOutput_2 = "postgres";
 
	final String decryptedPassword_tDBOutput_2 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:qpbLPzE2BhlvsYFtRHDtTak0mWD7lVTnengCdbyR3DlUtCsxDg==");

    String dbPwd_tDBOutput_2 = decryptedPassword_tDBOutput_2;

    conn_tDBOutput_2 = java.sql.DriverManager.getConnection(url_tDBOutput_2,dbUser_tDBOutput_2,dbPwd_tDBOutput_2);
	
	resourceMap.put("conn_tDBOutput_2", conn_tDBOutput_2);
        conn_tDBOutput_2.setAutoCommit(false);
        int commitEvery_tDBOutput_2 = 10000;
        int commitCounter_tDBOutput_2 = 0;


   int batchSize_tDBOutput_2 = 10000;
   int batchSizeCounter_tDBOutput_2=0;

int count_tDBOutput_2=0;
	    String insert_tDBOutput_2 = "INSERT INTO \"" + tableName_tDBOutput_2 + "\" (\"joueur1_nom\",\"joueur1_prenom\",\"joueur1_nationalite\",\"joueur2_nom\",\"joueur2_prenom\",\"joueur2_nationalite\",\"seed\",\"round\",\"score\",\"resultat\",\"date_tournoi\",\"nom_tournoi\",\"lieu_tournoi\",\"prize_money\",\"points\") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	    
	    java.sql.PreparedStatement pstmt_tDBOutput_2 = conn_tDBOutput_2.prepareStatement(insert_tDBOutput_2);
	    resourceMap.put("pstmt_tDBOutput_2", pstmt_tDBOutput_2);
	    

 



/**
 * [tDBOutput_2 begin ] stop
 */



	
	/**
	 * [tLogRow_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tLogRow_2", false);
		start_Hash.put("tLogRow_2", System.currentTimeMillis());
		
	
	currentComponent="tLogRow_2";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row3");
					}
				
		int tos_count_tLogRow_2 = 0;
		

	///////////////////////
	
         class Util_tLogRow_2 {

        String[] des_top = { ".", ".", "-", "+" };

        String[] des_head = { "|=", "=|", "-", "+" };

        String[] des_bottom = { "'", "'", "-", "+" };

        String name="";

        java.util.List<String[]> list = new java.util.ArrayList<String[]>();

        int[] colLengths = new int[15];

        public void addRow(String[] row) {

            for (int i = 0; i < 15; i++) {
                if (row[i]!=null) {
                  colLengths[i] = Math.max(colLengths[i], row[i].length());
                }
            }
            list.add(row);
        }

        public void setTableName(String name) {

            this.name = name;
        }

            public StringBuilder format() {
            
                StringBuilder sb = new StringBuilder();
  
            
                    sb.append(print(des_top));
    
                    int totals = 0;
                    for (int i = 0; i < colLengths.length; i++) {
                        totals = totals + colLengths[i];
                    }
    
                    // name
                    sb.append("|");
                    int k = 0;
                    for (k = 0; k < (totals + 14 - name.length()) / 2; k++) {
                        sb.append(' ');
                    }
                    sb.append(name);
                    for (int i = 0; i < totals + 14 - name.length() - k; i++) {
                        sb.append(' ');
                    }
                    sb.append("|\n");

                    // head and rows
                    sb.append(print(des_head));
                    for (int i = 0; i < list.size(); i++) {
    
                        String[] row = list.get(i);
    
                        java.util.Formatter formatter = new java.util.Formatter(new StringBuilder());
                        
                        StringBuilder sbformat = new StringBuilder();                                             
        			        sbformat.append("|%1$-");
        			        sbformat.append(colLengths[0]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%2$-");
        			        sbformat.append(colLengths[1]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%3$-");
        			        sbformat.append(colLengths[2]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%4$-");
        			        sbformat.append(colLengths[3]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%5$-");
        			        sbformat.append(colLengths[4]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%6$-");
        			        sbformat.append(colLengths[5]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%7$-");
        			        sbformat.append(colLengths[6]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%8$-");
        			        sbformat.append(colLengths[7]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%9$-");
        			        sbformat.append(colLengths[8]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%10$-");
        			        sbformat.append(colLengths[9]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%11$-");
        			        sbformat.append(colLengths[10]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%12$-");
        			        sbformat.append(colLengths[11]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%13$-");
        			        sbformat.append(colLengths[12]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%14$-");
        			        sbformat.append(colLengths[13]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%15$-");
        			        sbformat.append(colLengths[14]);
        			        sbformat.append("s");
        			                      
                        sbformat.append("|\n");                    
       
                        formatter.format(sbformat.toString(), (Object[])row);	
                                
                        sb.append(formatter.toString());
                        if (i == 0)
                            sb.append(print(des_head)); // print the head
                    }
    
                    // end
                    sb.append(print(des_bottom));
                    return sb;
                }
            

            private StringBuilder print(String[] fillChars) {
                StringBuilder sb = new StringBuilder();
                //first column
                sb.append(fillChars[0]);                
                    for (int i = 0; i < colLengths[0] - fillChars[0].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);	                

                    for (int i = 0; i < colLengths[1] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[2] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[3] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[4] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[5] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[6] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[7] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[8] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[9] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[10] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[11] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[12] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[13] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                
                    //last column
                    for (int i = 0; i < colLengths[14] - fillChars[1].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }         
                sb.append(fillChars[1]);
                sb.append("\n");               
                return sb;
            }
            
            public boolean isTableEmpty(){
            	if (list.size() > 1)
            		return false;
            	return true;
            }
        }
        Util_tLogRow_2 util_tLogRow_2 = new Util_tLogRow_2();
        util_tLogRow_2.setTableName("tLogRow_2");
        util_tLogRow_2.addRow(new String[]{"joueur1_nom","joueur1_prenom","joueur1_nationalite","joueur2_nom","joueur2_prenom","joueur2_nationalite","seed","round","score","resultat","date_tournoi","nom_tournoi","lieu_tournoi","prize_money","points",});        
 		StringBuilder strBuffer_tLogRow_2 = null;
		int nb_line_tLogRow_2 = 0;
///////////////////////    			



 



/**
 * [tLogRow_2 begin ] stop
 */



	
	/**
	 * [tFileInputDelimited_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tFileInputDelimited_2", false);
		start_Hash.put("tFileInputDelimited_2", System.currentTimeMillis());
		
	
	currentComponent="tFileInputDelimited_2";

	
		int tos_count_tFileInputDelimited_2 = 0;
		
	
	
	
 
	
	
	final routines.system.RowState rowstate_tFileInputDelimited_2 = new routines.system.RowState();
	
	
				int nb_line_tFileInputDelimited_2 = 0;
				org.talend.fileprocess.FileInputDelimited fid_tFileInputDelimited_2 = null;
				int limit_tFileInputDelimited_2 = -1;
				try{
					
						Object filename_tFileInputDelimited_2 = "C:/Users/ASUS/Downloads/Sports/Sports/script_tournois/jul.csv";
						if(filename_tFileInputDelimited_2 instanceof java.io.InputStream){
							
			int footer_value_tFileInputDelimited_2 = 0, random_value_tFileInputDelimited_2 = -1;
			if(footer_value_tFileInputDelimited_2 >0 || random_value_tFileInputDelimited_2 > 0){
				throw new java.lang.Exception("When the input source is a stream,footer and random shouldn't be bigger than 0.");				
			}
		
						}
						try {
							fid_tFileInputDelimited_2 = new org.talend.fileprocess.FileInputDelimited("C:/Users/ASUS/Downloads/Sports/Sports/script_tournois/jul.csv", "ISO-8859-15",";","\n",true,1,0,
									limit_tFileInputDelimited_2
								,-1, false);
						} catch(java.lang.Exception e) {
globalMap.put("tFileInputDelimited_2_ERROR_MESSAGE",e.getMessage());
							
								
								System.err.println(e.getMessage());
							
						}
					
				    
					while (fid_tFileInputDelimited_2!=null && fid_tFileInputDelimited_2.nextRecord()) {
						rowstate_tFileInputDelimited_2.reset();
						
			    						row3 = null;			
												
									boolean whetherReject_tFileInputDelimited_2 = false;
									row3 = new row3Struct();
									try {
										
				int columnIndexWithD_tFileInputDelimited_2 = 0;
				
					String temp = ""; 
				
					columnIndexWithD_tFileInputDelimited_2 = 0;
					
							row3.joueur1_nom = fid_tFileInputDelimited_2.get(columnIndexWithD_tFileInputDelimited_2);
						
				
					columnIndexWithD_tFileInputDelimited_2 = 1;
					
							row3.joueur1_prenom = fid_tFileInputDelimited_2.get(columnIndexWithD_tFileInputDelimited_2);
						
				
					columnIndexWithD_tFileInputDelimited_2 = 2;
					
							row3.joueur1_nationalite = fid_tFileInputDelimited_2.get(columnIndexWithD_tFileInputDelimited_2);
						
				
					columnIndexWithD_tFileInputDelimited_2 = 3;
					
							row3.joueur2_nom = fid_tFileInputDelimited_2.get(columnIndexWithD_tFileInputDelimited_2);
						
				
					columnIndexWithD_tFileInputDelimited_2 = 4;
					
							row3.joueur2_prenom = fid_tFileInputDelimited_2.get(columnIndexWithD_tFileInputDelimited_2);
						
				
					columnIndexWithD_tFileInputDelimited_2 = 5;
					
							row3.joueur2_nationalite = fid_tFileInputDelimited_2.get(columnIndexWithD_tFileInputDelimited_2);
						
				
					columnIndexWithD_tFileInputDelimited_2 = 6;
					
						temp = fid_tFileInputDelimited_2.get(columnIndexWithD_tFileInputDelimited_2);
						if(temp.length() > 0) {
							
								try {
								
    								row3.seed = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_2) {
globalMap.put("tFileInputDelimited_2_ERROR_MESSAGE",ex_tFileInputDelimited_2.getMessage());
									rowstate_tFileInputDelimited_2.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"seed", "row3", temp, ex_tFileInputDelimited_2), ex_tFileInputDelimited_2));
								}
    							
						} else {						
							
								
									row3.seed = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_2 = 7;
					
							row3.round = fid_tFileInputDelimited_2.get(columnIndexWithD_tFileInputDelimited_2);
						
				
					columnIndexWithD_tFileInputDelimited_2 = 8;
					
							row3.score = fid_tFileInputDelimited_2.get(columnIndexWithD_tFileInputDelimited_2);
						
				
					columnIndexWithD_tFileInputDelimited_2 = 9;
					
							row3.resultat = fid_tFileInputDelimited_2.get(columnIndexWithD_tFileInputDelimited_2);
						
				
					columnIndexWithD_tFileInputDelimited_2 = 10;
					
						temp = fid_tFileInputDelimited_2.get(columnIndexWithD_tFileInputDelimited_2);
						if(temp.length() > 0) {
							
								try {
								
    									row3.date_tournoi = ParserUtils.parseTo_Date(temp, "yyyy-MM-dd");
    								
    							} catch(java.lang.Exception ex_tFileInputDelimited_2) {
globalMap.put("tFileInputDelimited_2_ERROR_MESSAGE",ex_tFileInputDelimited_2.getMessage());
									rowstate_tFileInputDelimited_2.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"date_tournoi", "row3", temp, ex_tFileInputDelimited_2), ex_tFileInputDelimited_2));
								}
    							
						} else {						
							
								
									row3.date_tournoi = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_2 = 11;
					
							row3.nom_tournoi = fid_tFileInputDelimited_2.get(columnIndexWithD_tFileInputDelimited_2);
						
				
					columnIndexWithD_tFileInputDelimited_2 = 12;
					
							row3.lieu_tournoi = fid_tFileInputDelimited_2.get(columnIndexWithD_tFileInputDelimited_2);
						
				
					columnIndexWithD_tFileInputDelimited_2 = 13;
					
						temp = fid_tFileInputDelimited_2.get(columnIndexWithD_tFileInputDelimited_2);
						if(temp.length() > 0) {
							
								try {
								
    								row3.prize_money = ParserUtils.parseTo_BigDecimal(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_2) {
globalMap.put("tFileInputDelimited_2_ERROR_MESSAGE",ex_tFileInputDelimited_2.getMessage());
									rowstate_tFileInputDelimited_2.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"prize_money", "row3", temp, ex_tFileInputDelimited_2), ex_tFileInputDelimited_2));
								}
    							
						} else {						
							
								
									row3.prize_money = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_2 = 14;
					
						temp = fid_tFileInputDelimited_2.get(columnIndexWithD_tFileInputDelimited_2);
						if(temp.length() > 0) {
							
								try {
								
    								row3.points = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_2) {
globalMap.put("tFileInputDelimited_2_ERROR_MESSAGE",ex_tFileInputDelimited_2.getMessage());
									rowstate_tFileInputDelimited_2.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"points", "row3", temp, ex_tFileInputDelimited_2), ex_tFileInputDelimited_2));
								}
    							
						} else {						
							
								
									row3.points = null;
								
							
						}
					
				
				
										
										if(rowstate_tFileInputDelimited_2.getException()!=null) {
											throw rowstate_tFileInputDelimited_2.getException();
										}
										
										
							
			    					} catch (java.lang.Exception e) {
globalMap.put("tFileInputDelimited_2_ERROR_MESSAGE",e.getMessage());
			        					whetherReject_tFileInputDelimited_2 = true;
			        					
			                					System.err.println(e.getMessage());
			                					row3 = null;
			                				
										
			    					}
								

 



/**
 * [tFileInputDelimited_2 begin ] stop
 */
	
	/**
	 * [tFileInputDelimited_2 main ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_2";

	

 


	tos_count_tFileInputDelimited_2++;

/**
 * [tFileInputDelimited_2 main ] stop
 */
	
	/**
	 * [tFileInputDelimited_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_2";

	

 



/**
 * [tFileInputDelimited_2 process_data_begin ] stop
 */
// Start of branch "row3"
if(row3 != null) { 



	
	/**
	 * [tLogRow_2 main ] start
	 */

	

	
	
	currentComponent="tLogRow_2";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row3"
						
						);
					}
					
///////////////////////		
						

				
				String[] row_tLogRow_2 = new String[15];
   				
	    		if(row3.joueur1_nom != null) { //              
                 row_tLogRow_2[0]=    						    
				                String.valueOf(row3.joueur1_nom)			
					          ;	
							
	    		} //			
    			   				
	    		if(row3.joueur1_prenom != null) { //              
                 row_tLogRow_2[1]=    						    
				                String.valueOf(row3.joueur1_prenom)			
					          ;	
							
	    		} //			
    			   				
	    		if(row3.joueur1_nationalite != null) { //              
                 row_tLogRow_2[2]=    						    
				                String.valueOf(row3.joueur1_nationalite)			
					          ;	
							
	    		} //			
    			   				
	    		if(row3.joueur2_nom != null) { //              
                 row_tLogRow_2[3]=    						    
				                String.valueOf(row3.joueur2_nom)			
					          ;	
							
	    		} //			
    			   				
	    		if(row3.joueur2_prenom != null) { //              
                 row_tLogRow_2[4]=    						    
				                String.valueOf(row3.joueur2_prenom)			
					          ;	
							
	    		} //			
    			   				
	    		if(row3.joueur2_nationalite != null) { //              
                 row_tLogRow_2[5]=    						    
				                String.valueOf(row3.joueur2_nationalite)			
					          ;	
							
	    		} //			
    			   				
	    		if(row3.seed != null) { //              
                 row_tLogRow_2[6]=    						    
				                String.valueOf(row3.seed)			
					          ;	
							
	    		} //			
    			   				
	    		if(row3.round != null) { //              
                 row_tLogRow_2[7]=    						    
				                String.valueOf(row3.round)			
					          ;	
							
	    		} //			
    			   				
	    		if(row3.score != null) { //              
                 row_tLogRow_2[8]=    						    
				                String.valueOf(row3.score)			
					          ;	
							
	    		} //			
    			   				
	    		if(row3.resultat != null) { //              
                 row_tLogRow_2[9]=    						    
				                String.valueOf(row3.resultat)			
					          ;	
							
	    		} //			
    			   				
	    		if(row3.date_tournoi != null) { //              
                 row_tLogRow_2[10]=    						
								FormatterUtils.format_Date(row3.date_tournoi, "yyyy-MM-dd")
					          ;	
							
	    		} //			
    			   				
	    		if(row3.nom_tournoi != null) { //              
                 row_tLogRow_2[11]=    						    
				                String.valueOf(row3.nom_tournoi)			
					          ;	
							
	    		} //			
    			   				
	    		if(row3.lieu_tournoi != null) { //              
                 row_tLogRow_2[12]=    						    
				                String.valueOf(row3.lieu_tournoi)			
					          ;	
							
	    		} //			
    			   				
	    		if(row3.prize_money != null) { //              
                 row_tLogRow_2[13]=    						
								row3.prize_money.toPlainString()
					          ;	
							
	    		} //			
    			   				
	    		if(row3.points != null) { //              
                 row_tLogRow_2[14]=    						    
				                String.valueOf(row3.points)			
					          ;	
							
	    		} //			
    			 

				util_tLogRow_2.addRow(row_tLogRow_2);	
				nb_line_tLogRow_2++;
//////

//////                    
                    
///////////////////////    			

 
     row4 = row3;


	tos_count_tLogRow_2++;

/**
 * [tLogRow_2 main ] stop
 */
	
	/**
	 * [tLogRow_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tLogRow_2";

	

 



/**
 * [tLogRow_2 process_data_begin ] stop
 */

	
	/**
	 * [tDBOutput_2 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row4"
						
						);
					}
					



        whetherReject_tDBOutput_2 = false;
                    if(row4.joueur1_nom == null) {
pstmt_tDBOutput_2.setNull(1, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(1, row4.joueur1_nom);
}

                    if(row4.joueur1_prenom == null) {
pstmt_tDBOutput_2.setNull(2, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(2, row4.joueur1_prenom);
}

                    if(row4.joueur1_nationalite == null) {
pstmt_tDBOutput_2.setNull(3, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(3, row4.joueur1_nationalite);
}

                    if(row4.joueur2_nom == null) {
pstmt_tDBOutput_2.setNull(4, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(4, row4.joueur2_nom);
}

                    if(row4.joueur2_prenom == null) {
pstmt_tDBOutput_2.setNull(5, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(5, row4.joueur2_prenom);
}

                    if(row4.joueur2_nationalite == null) {
pstmt_tDBOutput_2.setNull(6, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(6, row4.joueur2_nationalite);
}

                    if(row4.seed == null) {
pstmt_tDBOutput_2.setNull(7, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_2.setInt(7, row4.seed);
}

                    if(row4.round == null) {
pstmt_tDBOutput_2.setNull(8, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(8, row4.round);
}

                    if(row4.score == null) {
pstmt_tDBOutput_2.setNull(9, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(9, row4.score);
}

                    if(row4.resultat == null) {
pstmt_tDBOutput_2.setNull(10, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(10, row4.resultat);
}

                    if(row4.date_tournoi != null) {
pstmt_tDBOutput_2.setTimestamp(11, new java.sql.Timestamp(row4.date_tournoi.getTime()));
} else {
pstmt_tDBOutput_2.setNull(11, java.sql.Types.TIMESTAMP);
}

                    if(row4.nom_tournoi == null) {
pstmt_tDBOutput_2.setNull(12, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(12, row4.nom_tournoi);
}

                    if(row4.lieu_tournoi == null) {
pstmt_tDBOutput_2.setNull(13, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(13, row4.lieu_tournoi);
}

                    pstmt_tDBOutput_2.setBigDecimal(14, row4.prize_money);

                    if(row4.points == null) {
pstmt_tDBOutput_2.setNull(15, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_2.setInt(15, row4.points);
}

			
    		pstmt_tDBOutput_2.addBatch();
    		nb_line_tDBOutput_2++;
    		  
    		  
    		  batchSizeCounter_tDBOutput_2++;
    		  
    			if ((batchSize_tDBOutput_2 > 0) && (batchSize_tDBOutput_2 <= batchSizeCounter_tDBOutput_2)) {
                try {
						int countSum_tDBOutput_2 = 0;
						    
						for(int countEach_tDBOutput_2: pstmt_tDBOutput_2.executeBatch()) {
							countSum_tDBOutput_2 += (countEach_tDBOutput_2 < 0 ? 0 : countEach_tDBOutput_2);
						}
				    	rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;
				    	
				    		insertedCount_tDBOutput_2 += countSum_tDBOutput_2;
				    	
            	    	batchSizeCounter_tDBOutput_2 = 0;
                }catch (java.sql.BatchUpdateException e_tDBOutput_2){
globalMap.put("tDBOutput_2_ERROR_MESSAGE",e_tDBOutput_2.getMessage());
				    	java.sql.SQLException ne_tDBOutput_2 = e_tDBOutput_2.getNextException(),sqle_tDBOutput_2=null;
				    	String errormessage_tDBOutput_2;
						if (ne_tDBOutput_2 != null) {
							// build new exception to provide the original cause
							sqle_tDBOutput_2 = new java.sql.SQLException(e_tDBOutput_2.getMessage() + "\ncaused by: " + ne_tDBOutput_2.getMessage(), ne_tDBOutput_2.getSQLState(), ne_tDBOutput_2.getErrorCode(), ne_tDBOutput_2);
							errormessage_tDBOutput_2 = sqle_tDBOutput_2.getMessage();
						}else{
							errormessage_tDBOutput_2 = e_tDBOutput_2.getMessage();
						}
				    	
				    	int countSum_tDBOutput_2 = 0;
						for(int countEach_tDBOutput_2: e_tDBOutput_2.getUpdateCounts()) {
							countSum_tDBOutput_2 += (countEach_tDBOutput_2 < 0 ? 0 : countEach_tDBOutput_2);
						}
						rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;
						
				    		insertedCount_tDBOutput_2 += countSum_tDBOutput_2;
				    	
				    	System.err.println(errormessage_tDBOutput_2);
				    	
					}
    			}
    		
    		    commitCounter_tDBOutput_2++;
                if(commitEvery_tDBOutput_2 <= commitCounter_tDBOutput_2) {
                if ((batchSize_tDBOutput_2 > 0) && (batchSizeCounter_tDBOutput_2 > 0)) {
                try {
                		int countSum_tDBOutput_2 = 0;
                		    
						for(int countEach_tDBOutput_2: pstmt_tDBOutput_2.executeBatch()) {
							countSum_tDBOutput_2 += (countEach_tDBOutput_2 < 0 ? 0 : countEach_tDBOutput_2);
						}
            	    	rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;
            	    	
            	    		insertedCount_tDBOutput_2 += countSum_tDBOutput_2;
            	    	
                batchSizeCounter_tDBOutput_2 = 0;
               }catch (java.sql.BatchUpdateException e_tDBOutput_2){
globalMap.put("tDBOutput_2_ERROR_MESSAGE",e_tDBOutput_2.getMessage());
			    	java.sql.SQLException ne_tDBOutput_2 = e_tDBOutput_2.getNextException(),sqle_tDBOutput_2=null;
			    	String errormessage_tDBOutput_2;
					if (ne_tDBOutput_2 != null) {
						// build new exception to provide the original cause
						sqle_tDBOutput_2 = new java.sql.SQLException(e_tDBOutput_2.getMessage() + "\ncaused by: " + ne_tDBOutput_2.getMessage(), ne_tDBOutput_2.getSQLState(), ne_tDBOutput_2.getErrorCode(), ne_tDBOutput_2);
						errormessage_tDBOutput_2 = sqle_tDBOutput_2.getMessage();
					}else{
						errormessage_tDBOutput_2 = e_tDBOutput_2.getMessage();
					}
			    	
			    	int countSum_tDBOutput_2 = 0;
					for(int countEach_tDBOutput_2: e_tDBOutput_2.getUpdateCounts()) {
						countSum_tDBOutput_2 += (countEach_tDBOutput_2 < 0 ? 0 : countEach_tDBOutput_2);
					}
					rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;
					
			    		insertedCount_tDBOutput_2 += countSum_tDBOutput_2;
			    	
			    	System.err.println(errormessage_tDBOutput_2);
			    	
				}
            }
                    if(rowsToCommitCount_tDBOutput_2 != 0){
                    	
                    }
                    conn_tDBOutput_2.commit();
                    if(rowsToCommitCount_tDBOutput_2 != 0){
                    	
                    	rowsToCommitCount_tDBOutput_2 = 0;
                    }
                    commitCounter_tDBOutput_2=0;
                }

 


	tos_count_tDBOutput_2++;

/**
 * [tDBOutput_2 main ] stop
 */
	
	/**
	 * [tDBOutput_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";

	

 



/**
 * [tDBOutput_2 process_data_begin ] stop
 */
	
	/**
	 * [tDBOutput_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";

	

 



/**
 * [tDBOutput_2 process_data_end ] stop
 */



	
	/**
	 * [tLogRow_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tLogRow_2";

	

 



/**
 * [tLogRow_2 process_data_end ] stop
 */

} // End of branch "row3"




	
	/**
	 * [tFileInputDelimited_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_2";

	

 



/**
 * [tFileInputDelimited_2 process_data_end ] stop
 */
	
	/**
	 * [tFileInputDelimited_2 end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_2";

	



            }
            }finally{
                if(!((Object)("C:/Users/ASUS/Downloads/Sports/Sports/script_tournois/jul.csv") instanceof java.io.InputStream)){
                	if(fid_tFileInputDelimited_2!=null){
                		fid_tFileInputDelimited_2.close();
                	}
                }
                if(fid_tFileInputDelimited_2!=null){
                	globalMap.put("tFileInputDelimited_2_NB_LINE", fid_tFileInputDelimited_2.getRowNumber());
					
                }
			}
			  

 

ok_Hash.put("tFileInputDelimited_2", true);
end_Hash.put("tFileInputDelimited_2", System.currentTimeMillis());




/**
 * [tFileInputDelimited_2 end ] stop
 */

	
	/**
	 * [tLogRow_2 end ] start
	 */

	

	
	
	currentComponent="tLogRow_2";

	


//////

                    
                    java.io.PrintStream consoleOut_tLogRow_2 = null;
                    if (globalMap.get("tLogRow_CONSOLE")!=null)
                    {
                    	consoleOut_tLogRow_2 = (java.io.PrintStream) globalMap.get("tLogRow_CONSOLE");
                    }
                    else
                    {
                    	consoleOut_tLogRow_2 = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));
                    	globalMap.put("tLogRow_CONSOLE",consoleOut_tLogRow_2);
                    }
                    
                    consoleOut_tLogRow_2.println(util_tLogRow_2.format().toString());
                    consoleOut_tLogRow_2.flush();
//////
globalMap.put("tLogRow_2_NB_LINE",nb_line_tLogRow_2);

///////////////////////    			

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row3");
			  	}
			  	
 

ok_Hash.put("tLogRow_2", true);
end_Hash.put("tLogRow_2", System.currentTimeMillis());




/**
 * [tLogRow_2 end ] stop
 */

	
	/**
	 * [tDBOutput_2 end ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";

	



	    try {
				int countSum_tDBOutput_2 = 0;
				if (pstmt_tDBOutput_2 != null && batchSizeCounter_tDBOutput_2 > 0) {
						
					for(int countEach_tDBOutput_2: pstmt_tDBOutput_2.executeBatch()) {
						countSum_tDBOutput_2 += (countEach_tDBOutput_2 < 0 ? 0 : countEach_tDBOutput_2);
					}
					rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;
						
				}
		    	
		    		insertedCount_tDBOutput_2 += countSum_tDBOutput_2;
		    	
	    }catch (java.sql.BatchUpdateException e_tDBOutput_2){
globalMap.put("tDBOutput_2_ERROR_MESSAGE",e_tDBOutput_2.getMessage());
	    	java.sql.SQLException ne_tDBOutput_2 = e_tDBOutput_2.getNextException(),sqle_tDBOutput_2=null;
	    	String errormessage_tDBOutput_2;
			if (ne_tDBOutput_2 != null) {
				// build new exception to provide the original cause
				sqle_tDBOutput_2 = new java.sql.SQLException(e_tDBOutput_2.getMessage() + "\ncaused by: " + ne_tDBOutput_2.getMessage(), ne_tDBOutput_2.getSQLState(), ne_tDBOutput_2.getErrorCode(), ne_tDBOutput_2);
				errormessage_tDBOutput_2 = sqle_tDBOutput_2.getMessage();
			}else{
				errormessage_tDBOutput_2 = e_tDBOutput_2.getMessage();
			}
	    	
	    	int countSum_tDBOutput_2 = 0;
			for(int countEach_tDBOutput_2: e_tDBOutput_2.getUpdateCounts()) {
				countSum_tDBOutput_2 += (countEach_tDBOutput_2 < 0 ? 0 : countEach_tDBOutput_2);
			}
			rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;
			
	    		insertedCount_tDBOutput_2 += countSum_tDBOutput_2;
	    	
	    	System.err.println(errormessage_tDBOutput_2);
	    	
		}
	    
        if(pstmt_tDBOutput_2 != null) {
        		
            pstmt_tDBOutput_2.close();
            resourceMap.remove("pstmt_tDBOutput_2");
        }
    resourceMap.put("statementClosed_tDBOutput_2", true);
			if(rowsToCommitCount_tDBOutput_2 != 0){
				
			}
			conn_tDBOutput_2.commit();
			if(rowsToCommitCount_tDBOutput_2 != 0){
				
				rowsToCommitCount_tDBOutput_2 = 0;
			}
			commitCounter_tDBOutput_2 = 0;
		
    	conn_tDBOutput_2 .close();
    	
    	resourceMap.put("finish_tDBOutput_2", true);
    	

	nb_line_deleted_tDBOutput_2=nb_line_deleted_tDBOutput_2+ deletedCount_tDBOutput_2;
	nb_line_update_tDBOutput_2=nb_line_update_tDBOutput_2 + updatedCount_tDBOutput_2;
	nb_line_inserted_tDBOutput_2=nb_line_inserted_tDBOutput_2 + insertedCount_tDBOutput_2;
	nb_line_rejected_tDBOutput_2=nb_line_rejected_tDBOutput_2 + rejectedCount_tDBOutput_2;
	
        globalMap.put("tDBOutput_2_NB_LINE",nb_line_tDBOutput_2);
        globalMap.put("tDBOutput_2_NB_LINE_UPDATED",nb_line_update_tDBOutput_2);
        globalMap.put("tDBOutput_2_NB_LINE_INSERTED",nb_line_inserted_tDBOutput_2);
        globalMap.put("tDBOutput_2_NB_LINE_DELETED",nb_line_deleted_tDBOutput_2);
        globalMap.put("tDBOutput_2_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_2);
    

	


				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row4");
			  	}
			  	
 

ok_Hash.put("tDBOutput_2", true);
end_Hash.put("tDBOutput_2", System.currentTimeMillis());




/**
 * [tDBOutput_2 end ] stop
 */






				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tFileInputDelimited_2 finally ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_2";

	

 



/**
 * [tFileInputDelimited_2 finally ] stop
 */

	
	/**
	 * [tLogRow_2 finally ] start
	 */

	

	
	
	currentComponent="tLogRow_2";

	

 



/**
 * [tLogRow_2 finally ] stop
 */

	
	/**
	 * [tDBOutput_2 finally ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";

	



    try {
    if (resourceMap.get("statementClosed_tDBOutput_2") == null) {
                java.sql.PreparedStatement pstmtToClose_tDBOutput_2 = null;
                if ((pstmtToClose_tDBOutput_2 = (java.sql.PreparedStatement) resourceMap.remove("pstmt_tDBOutput_2")) != null) {
                    pstmtToClose_tDBOutput_2.close();
                }
    }
    } finally {
        if(resourceMap.get("finish_tDBOutput_2") == null){
            java.sql.Connection ctn_tDBOutput_2 = null;
            if((ctn_tDBOutput_2 = (java.sql.Connection)resourceMap.get("conn_tDBOutput_2")) != null){
                try {
                    ctn_tDBOutput_2.close();
                } catch (java.sql.SQLException sqlEx_tDBOutput_2) {
                    String errorMessage_tDBOutput_2 = "failed to close the connection in tDBOutput_2 :" + sqlEx_tDBOutput_2.getMessage();
                    System.err.println(errorMessage_tDBOutput_2);
                }
            }
        }
    }
 



/**
 * [tDBOutput_2 finally ] stop
 */






				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tFileInputDelimited_2_SUBPROCESS_STATE", 1);
	}
	


public static class row6Struct implements routines.system.IPersistableRow<row6Struct> {
    final static byte[] commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[0];
    static byte[] commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[0];

	
			    public String joueur1_nom;

				public String getJoueur1_nom () {
					return this.joueur1_nom;
				}
				
			    public String joueur1_prenom;

				public String getJoueur1_prenom () {
					return this.joueur1_prenom;
				}
				
			    public String joueur1_nationalite;

				public String getJoueur1_nationalite () {
					return this.joueur1_nationalite;
				}
				
			    public String joueur2_nom;

				public String getJoueur2_nom () {
					return this.joueur2_nom;
				}
				
			    public String joueur2_prenom;

				public String getJoueur2_prenom () {
					return this.joueur2_prenom;
				}
				
			    public String joueur2_nationalite;

				public String getJoueur2_nationalite () {
					return this.joueur2_nationalite;
				}
				
			    public Integer seed;

				public Integer getSeed () {
					return this.seed;
				}
				
			    public String round;

				public String getRound () {
					return this.round;
				}
				
			    public String score;

				public String getScore () {
					return this.score;
				}
				
			    public String resultat;

				public String getResultat () {
					return this.resultat;
				}
				
			    public java.util.Date date_tournoi;

				public java.util.Date getDate_tournoi () {
					return this.date_tournoi;
				}
				
			    public String nom_tournoi;

				public String getNom_tournoi () {
					return this.nom_tournoi;
				}
				
			    public String lieu_tournoi;

				public String getLieu_tournoi () {
					return this.lieu_tournoi;
				}
				
			    public BigDecimal prize_money;

				public BigDecimal getPrize_money () {
					return this.prize_money;
				}
				
			    public Integer points;

				public Integer getPoints () {
					return this.points;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length) {
				if(length < 1024 && commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length == 0) {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[1024];
				} else {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length);
			strReturn = new String(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length) {
				if(length < 1024 && commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length == 0) {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[1024];
				} else {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length);
			strReturn = new String(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep) {

        	try {

        		int length = 0;
		
					this.joueur1_nom = readString(dis);
					
					this.joueur1_prenom = readString(dis);
					
					this.joueur1_nationalite = readString(dis);
					
					this.joueur2_nom = readString(dis);
					
					this.joueur2_prenom = readString(dis);
					
					this.joueur2_nationalite = readString(dis);
					
						this.seed = readInteger(dis);
					
					this.round = readString(dis);
					
					this.score = readString(dis);
					
					this.resultat = readString(dis);
					
					this.date_tournoi = readDate(dis);
					
					this.nom_tournoi = readString(dis);
					
					this.lieu_tournoi = readString(dis);
					
						this.prize_money = (BigDecimal) dis.readObject();
					
						this.points = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep) {

        	try {

        		int length = 0;
		
					this.joueur1_nom = readString(dis);
					
					this.joueur1_prenom = readString(dis);
					
					this.joueur1_nationalite = readString(dis);
					
					this.joueur2_nom = readString(dis);
					
					this.joueur2_prenom = readString(dis);
					
					this.joueur2_nationalite = readString(dis);
					
						this.seed = readInteger(dis);
					
					this.round = readString(dis);
					
					this.score = readString(dis);
					
					this.resultat = readString(dis);
					
					this.date_tournoi = readDate(dis);
					
					this.nom_tournoi = readString(dis);
					
					this.lieu_tournoi = readString(dis);
					
						this.prize_money = (BigDecimal) dis.readObject();
					
						this.points = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.joueur1_nom,dos);
					
					// String
				
						writeString(this.joueur1_prenom,dos);
					
					// String
				
						writeString(this.joueur1_nationalite,dos);
					
					// String
				
						writeString(this.joueur2_nom,dos);
					
					// String
				
						writeString(this.joueur2_prenom,dos);
					
					// String
				
						writeString(this.joueur2_nationalite,dos);
					
					// Integer
				
						writeInteger(this.seed,dos);
					
					// String
				
						writeString(this.round,dos);
					
					// String
				
						writeString(this.score,dos);
					
					// String
				
						writeString(this.resultat,dos);
					
					// java.util.Date
				
						writeDate(this.date_tournoi,dos);
					
					// String
				
						writeString(this.nom_tournoi,dos);
					
					// String
				
						writeString(this.lieu_tournoi,dos);
					
					// BigDecimal
				
       			    	dos.writeObject(this.prize_money);
					
					// Integer
				
						writeInteger(this.points,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.joueur1_nom,dos);
					
					// String
				
						writeString(this.joueur1_prenom,dos);
					
					// String
				
						writeString(this.joueur1_nationalite,dos);
					
					// String
				
						writeString(this.joueur2_nom,dos);
					
					// String
				
						writeString(this.joueur2_prenom,dos);
					
					// String
				
						writeString(this.joueur2_nationalite,dos);
					
					// Integer
				
						writeInteger(this.seed,dos);
					
					// String
				
						writeString(this.round,dos);
					
					// String
				
						writeString(this.score,dos);
					
					// String
				
						writeString(this.resultat,dos);
					
					// java.util.Date
				
						writeDate(this.date_tournoi,dos);
					
					// String
				
						writeString(this.nom_tournoi,dos);
					
					// String
				
						writeString(this.lieu_tournoi,dos);
					
					// BigDecimal
				
       			    	dos.writeObject(this.prize_money);
					
					// Integer
				
						writeInteger(this.points,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("joueur1_nom="+joueur1_nom);
		sb.append(",joueur1_prenom="+joueur1_prenom);
		sb.append(",joueur1_nationalite="+joueur1_nationalite);
		sb.append(",joueur2_nom="+joueur2_nom);
		sb.append(",joueur2_prenom="+joueur2_prenom);
		sb.append(",joueur2_nationalite="+joueur2_nationalite);
		sb.append(",seed="+String.valueOf(seed));
		sb.append(",round="+round);
		sb.append(",score="+score);
		sb.append(",resultat="+resultat);
		sb.append(",date_tournoi="+String.valueOf(date_tournoi));
		sb.append(",nom_tournoi="+nom_tournoi);
		sb.append(",lieu_tournoi="+lieu_tournoi);
		sb.append(",prize_money="+String.valueOf(prize_money));
		sb.append(",points="+String.valueOf(points));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row6Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class row5Struct implements routines.system.IPersistableRow<row5Struct> {
    final static byte[] commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[0];
    static byte[] commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[0];

	
			    public String joueur1_nom;

				public String getJoueur1_nom () {
					return this.joueur1_nom;
				}
				
			    public String joueur1_prenom;

				public String getJoueur1_prenom () {
					return this.joueur1_prenom;
				}
				
			    public String joueur1_nationalite;

				public String getJoueur1_nationalite () {
					return this.joueur1_nationalite;
				}
				
			    public String joueur2_nom;

				public String getJoueur2_nom () {
					return this.joueur2_nom;
				}
				
			    public String joueur2_prenom;

				public String getJoueur2_prenom () {
					return this.joueur2_prenom;
				}
				
			    public String joueur2_nationalite;

				public String getJoueur2_nationalite () {
					return this.joueur2_nationalite;
				}
				
			    public Integer seed;

				public Integer getSeed () {
					return this.seed;
				}
				
			    public String round;

				public String getRound () {
					return this.round;
				}
				
			    public String score;

				public String getScore () {
					return this.score;
				}
				
			    public String resultat;

				public String getResultat () {
					return this.resultat;
				}
				
			    public java.util.Date date_tournoi;

				public java.util.Date getDate_tournoi () {
					return this.date_tournoi;
				}
				
			    public String nom_tournoi;

				public String getNom_tournoi () {
					return this.nom_tournoi;
				}
				
			    public String lieu_tournoi;

				public String getLieu_tournoi () {
					return this.lieu_tournoi;
				}
				
			    public BigDecimal prize_money;

				public BigDecimal getPrize_money () {
					return this.prize_money;
				}
				
			    public Integer points;

				public Integer getPoints () {
					return this.points;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length) {
				if(length < 1024 && commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length == 0) {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[1024];
				} else {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length);
			strReturn = new String(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length) {
				if(length < 1024 && commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length == 0) {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[1024];
				} else {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length);
			strReturn = new String(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep) {

        	try {

        		int length = 0;
		
					this.joueur1_nom = readString(dis);
					
					this.joueur1_prenom = readString(dis);
					
					this.joueur1_nationalite = readString(dis);
					
					this.joueur2_nom = readString(dis);
					
					this.joueur2_prenom = readString(dis);
					
					this.joueur2_nationalite = readString(dis);
					
						this.seed = readInteger(dis);
					
					this.round = readString(dis);
					
					this.score = readString(dis);
					
					this.resultat = readString(dis);
					
					this.date_tournoi = readDate(dis);
					
					this.nom_tournoi = readString(dis);
					
					this.lieu_tournoi = readString(dis);
					
						this.prize_money = (BigDecimal) dis.readObject();
					
						this.points = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep) {

        	try {

        		int length = 0;
		
					this.joueur1_nom = readString(dis);
					
					this.joueur1_prenom = readString(dis);
					
					this.joueur1_nationalite = readString(dis);
					
					this.joueur2_nom = readString(dis);
					
					this.joueur2_prenom = readString(dis);
					
					this.joueur2_nationalite = readString(dis);
					
						this.seed = readInteger(dis);
					
					this.round = readString(dis);
					
					this.score = readString(dis);
					
					this.resultat = readString(dis);
					
					this.date_tournoi = readDate(dis);
					
					this.nom_tournoi = readString(dis);
					
					this.lieu_tournoi = readString(dis);
					
						this.prize_money = (BigDecimal) dis.readObject();
					
						this.points = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.joueur1_nom,dos);
					
					// String
				
						writeString(this.joueur1_prenom,dos);
					
					// String
				
						writeString(this.joueur1_nationalite,dos);
					
					// String
				
						writeString(this.joueur2_nom,dos);
					
					// String
				
						writeString(this.joueur2_prenom,dos);
					
					// String
				
						writeString(this.joueur2_nationalite,dos);
					
					// Integer
				
						writeInteger(this.seed,dos);
					
					// String
				
						writeString(this.round,dos);
					
					// String
				
						writeString(this.score,dos);
					
					// String
				
						writeString(this.resultat,dos);
					
					// java.util.Date
				
						writeDate(this.date_tournoi,dos);
					
					// String
				
						writeString(this.nom_tournoi,dos);
					
					// String
				
						writeString(this.lieu_tournoi,dos);
					
					// BigDecimal
				
       			    	dos.writeObject(this.prize_money);
					
					// Integer
				
						writeInteger(this.points,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.joueur1_nom,dos);
					
					// String
				
						writeString(this.joueur1_prenom,dos);
					
					// String
				
						writeString(this.joueur1_nationalite,dos);
					
					// String
				
						writeString(this.joueur2_nom,dos);
					
					// String
				
						writeString(this.joueur2_prenom,dos);
					
					// String
				
						writeString(this.joueur2_nationalite,dos);
					
					// Integer
				
						writeInteger(this.seed,dos);
					
					// String
				
						writeString(this.round,dos);
					
					// String
				
						writeString(this.score,dos);
					
					// String
				
						writeString(this.resultat,dos);
					
					// java.util.Date
				
						writeDate(this.date_tournoi,dos);
					
					// String
				
						writeString(this.nom_tournoi,dos);
					
					// String
				
						writeString(this.lieu_tournoi,dos);
					
					// BigDecimal
				
       			    	dos.writeObject(this.prize_money);
					
					// Integer
				
						writeInteger(this.points,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("joueur1_nom="+joueur1_nom);
		sb.append(",joueur1_prenom="+joueur1_prenom);
		sb.append(",joueur1_nationalite="+joueur1_nationalite);
		sb.append(",joueur2_nom="+joueur2_nom);
		sb.append(",joueur2_prenom="+joueur2_prenom);
		sb.append(",joueur2_nationalite="+joueur2_nationalite);
		sb.append(",seed="+String.valueOf(seed));
		sb.append(",round="+round);
		sb.append(",score="+score);
		sb.append(",resultat="+resultat);
		sb.append(",date_tournoi="+String.valueOf(date_tournoi));
		sb.append(",nom_tournoi="+nom_tournoi);
		sb.append(",lieu_tournoi="+lieu_tournoi);
		sb.append(",prize_money="+String.valueOf(prize_money));
		sb.append(",points="+String.valueOf(points));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row5Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tFileInputDelimited_3Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tFileInputDelimited_3_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row5Struct row5 = new row5Struct();
row5Struct row6 = row5;





	
	/**
	 * [tDBOutput_3 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBOutput_3", false);
		start_Hash.put("tDBOutput_3", System.currentTimeMillis());
		
	
	currentComponent="tDBOutput_3";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row6");
					}
				
		int tos_count_tDBOutput_3 = 0;
		





String dbschema_tDBOutput_3 = null;
	dbschema_tDBOutput_3 = "sa";
	

String tableName_tDBOutput_3 = null;
if(dbschema_tDBOutput_3 == null || dbschema_tDBOutput_3.trim().length() == 0) {
	tableName_tDBOutput_3 = ("sa_tournament_feb");
} else {
	tableName_tDBOutput_3 = dbschema_tDBOutput_3 + "\".\"" + ("sa_tournament_feb");
}


int nb_line_tDBOutput_3 = 0;
int nb_line_update_tDBOutput_3 = 0;
int nb_line_inserted_tDBOutput_3 = 0;
int nb_line_deleted_tDBOutput_3 = 0;
int nb_line_rejected_tDBOutput_3 = 0;

int deletedCount_tDBOutput_3=0;
int updatedCount_tDBOutput_3=0;
int insertedCount_tDBOutput_3=0;
int rowsToCommitCount_tDBOutput_3=0;
int rejectedCount_tDBOutput_3=0;

boolean whetherReject_tDBOutput_3 = false;

java.sql.Connection conn_tDBOutput_3 = null;
String dbUser_tDBOutput_3 = null;

	
    java.lang.Class.forName("org.postgresql.Driver");
    
        String url_tDBOutput_3 = "jdbc:postgresql://"+"localhost"+":"+"5432"+"/"+"padel_bi_SA";
    dbUser_tDBOutput_3 = "postgres";
 
	final String decryptedPassword_tDBOutput_3 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:iL2ldbvv4lfoUMosZEc/aVx+Gdaa2Oj6uB710nQKToeVDtAryw==");

    String dbPwd_tDBOutput_3 = decryptedPassword_tDBOutput_3;

    conn_tDBOutput_3 = java.sql.DriverManager.getConnection(url_tDBOutput_3,dbUser_tDBOutput_3,dbPwd_tDBOutput_3);
	
	resourceMap.put("conn_tDBOutput_3", conn_tDBOutput_3);
        conn_tDBOutput_3.setAutoCommit(false);
        int commitEvery_tDBOutput_3 = 10000;
        int commitCounter_tDBOutput_3 = 0;


   int batchSize_tDBOutput_3 = 10000;
   int batchSizeCounter_tDBOutput_3=0;

int count_tDBOutput_3=0;
	    String insert_tDBOutput_3 = "INSERT INTO \"" + tableName_tDBOutput_3 + "\" (\"joueur1_nom\",\"joueur1_prenom\",\"joueur1_nationalite\",\"joueur2_nom\",\"joueur2_prenom\",\"joueur2_nationalite\",\"seed\",\"round\",\"score\",\"resultat\",\"date_tournoi\",\"nom_tournoi\",\"lieu_tournoi\",\"prize_money\",\"points\") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	    
	    java.sql.PreparedStatement pstmt_tDBOutput_3 = conn_tDBOutput_3.prepareStatement(insert_tDBOutput_3);
	    resourceMap.put("pstmt_tDBOutput_3", pstmt_tDBOutput_3);
	    

 



/**
 * [tDBOutput_3 begin ] stop
 */



	
	/**
	 * [tLogRow_3 begin ] start
	 */

	

	
		
		ok_Hash.put("tLogRow_3", false);
		start_Hash.put("tLogRow_3", System.currentTimeMillis());
		
	
	currentComponent="tLogRow_3";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row5");
					}
				
		int tos_count_tLogRow_3 = 0;
		

	///////////////////////
	
         class Util_tLogRow_3 {

        String[] des_top = { ".", ".", "-", "+" };

        String[] des_head = { "|=", "=|", "-", "+" };

        String[] des_bottom = { "'", "'", "-", "+" };

        String name="";

        java.util.List<String[]> list = new java.util.ArrayList<String[]>();

        int[] colLengths = new int[15];

        public void addRow(String[] row) {

            for (int i = 0; i < 15; i++) {
                if (row[i]!=null) {
                  colLengths[i] = Math.max(colLengths[i], row[i].length());
                }
            }
            list.add(row);
        }

        public void setTableName(String name) {

            this.name = name;
        }

            public StringBuilder format() {
            
                StringBuilder sb = new StringBuilder();
  
            
                    sb.append(print(des_top));
    
                    int totals = 0;
                    for (int i = 0; i < colLengths.length; i++) {
                        totals = totals + colLengths[i];
                    }
    
                    // name
                    sb.append("|");
                    int k = 0;
                    for (k = 0; k < (totals + 14 - name.length()) / 2; k++) {
                        sb.append(' ');
                    }
                    sb.append(name);
                    for (int i = 0; i < totals + 14 - name.length() - k; i++) {
                        sb.append(' ');
                    }
                    sb.append("|\n");

                    // head and rows
                    sb.append(print(des_head));
                    for (int i = 0; i < list.size(); i++) {
    
                        String[] row = list.get(i);
    
                        java.util.Formatter formatter = new java.util.Formatter(new StringBuilder());
                        
                        StringBuilder sbformat = new StringBuilder();                                             
        			        sbformat.append("|%1$-");
        			        sbformat.append(colLengths[0]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%2$-");
        			        sbformat.append(colLengths[1]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%3$-");
        			        sbformat.append(colLengths[2]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%4$-");
        			        sbformat.append(colLengths[3]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%5$-");
        			        sbformat.append(colLengths[4]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%6$-");
        			        sbformat.append(colLengths[5]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%7$-");
        			        sbformat.append(colLengths[6]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%8$-");
        			        sbformat.append(colLengths[7]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%9$-");
        			        sbformat.append(colLengths[8]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%10$-");
        			        sbformat.append(colLengths[9]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%11$-");
        			        sbformat.append(colLengths[10]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%12$-");
        			        sbformat.append(colLengths[11]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%13$-");
        			        sbformat.append(colLengths[12]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%14$-");
        			        sbformat.append(colLengths[13]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%15$-");
        			        sbformat.append(colLengths[14]);
        			        sbformat.append("s");
        			                      
                        sbformat.append("|\n");                    
       
                        formatter.format(sbformat.toString(), (Object[])row);	
                                
                        sb.append(formatter.toString());
                        if (i == 0)
                            sb.append(print(des_head)); // print the head
                    }
    
                    // end
                    sb.append(print(des_bottom));
                    return sb;
                }
            

            private StringBuilder print(String[] fillChars) {
                StringBuilder sb = new StringBuilder();
                //first column
                sb.append(fillChars[0]);                
                    for (int i = 0; i < colLengths[0] - fillChars[0].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);	                

                    for (int i = 0; i < colLengths[1] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[2] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[3] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[4] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[5] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[6] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[7] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[8] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[9] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[10] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[11] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[12] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[13] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                
                    //last column
                    for (int i = 0; i < colLengths[14] - fillChars[1].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }         
                sb.append(fillChars[1]);
                sb.append("\n");               
                return sb;
            }
            
            public boolean isTableEmpty(){
            	if (list.size() > 1)
            		return false;
            	return true;
            }
        }
        Util_tLogRow_3 util_tLogRow_3 = new Util_tLogRow_3();
        util_tLogRow_3.setTableName("tLogRow_3");
        util_tLogRow_3.addRow(new String[]{"joueur1_nom","joueur1_prenom","joueur1_nationalite","joueur2_nom","joueur2_prenom","joueur2_nationalite","seed","round","score","resultat","date_tournoi","nom_tournoi","lieu_tournoi","prize_money","points",});        
 		StringBuilder strBuffer_tLogRow_3 = null;
		int nb_line_tLogRow_3 = 0;
///////////////////////    			



 



/**
 * [tLogRow_3 begin ] stop
 */



	
	/**
	 * [tFileInputDelimited_3 begin ] start
	 */

	

	
		
		ok_Hash.put("tFileInputDelimited_3", false);
		start_Hash.put("tFileInputDelimited_3", System.currentTimeMillis());
		
	
	currentComponent="tFileInputDelimited_3";

	
		int tos_count_tFileInputDelimited_3 = 0;
		
	
	
	
 
	
	
	final routines.system.RowState rowstate_tFileInputDelimited_3 = new routines.system.RowState();
	
	
				int nb_line_tFileInputDelimited_3 = 0;
				org.talend.fileprocess.FileInputDelimited fid_tFileInputDelimited_3 = null;
				int limit_tFileInputDelimited_3 = -1;
				try{
					
						Object filename_tFileInputDelimited_3 = "C:/Users/ASUS/Downloads/Sports/Sports/script_tournois/feb.csv";
						if(filename_tFileInputDelimited_3 instanceof java.io.InputStream){
							
			int footer_value_tFileInputDelimited_3 = 0, random_value_tFileInputDelimited_3 = -1;
			if(footer_value_tFileInputDelimited_3 >0 || random_value_tFileInputDelimited_3 > 0){
				throw new java.lang.Exception("When the input source is a stream,footer and random shouldn't be bigger than 0.");				
			}
		
						}
						try {
							fid_tFileInputDelimited_3 = new org.talend.fileprocess.FileInputDelimited("C:/Users/ASUS/Downloads/Sports/Sports/script_tournois/feb.csv", "ISO-8859-15",";","\n",true,1,0,
									limit_tFileInputDelimited_3
								,-1, false);
						} catch(java.lang.Exception e) {
globalMap.put("tFileInputDelimited_3_ERROR_MESSAGE",e.getMessage());
							
								
								System.err.println(e.getMessage());
							
						}
					
				    
					while (fid_tFileInputDelimited_3!=null && fid_tFileInputDelimited_3.nextRecord()) {
						rowstate_tFileInputDelimited_3.reset();
						
			    						row5 = null;			
												
									boolean whetherReject_tFileInputDelimited_3 = false;
									row5 = new row5Struct();
									try {
										
				int columnIndexWithD_tFileInputDelimited_3 = 0;
				
					String temp = ""; 
				
					columnIndexWithD_tFileInputDelimited_3 = 0;
					
							row5.joueur1_nom = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);
						
				
					columnIndexWithD_tFileInputDelimited_3 = 1;
					
							row5.joueur1_prenom = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);
						
				
					columnIndexWithD_tFileInputDelimited_3 = 2;
					
							row5.joueur1_nationalite = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);
						
				
					columnIndexWithD_tFileInputDelimited_3 = 3;
					
							row5.joueur2_nom = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);
						
				
					columnIndexWithD_tFileInputDelimited_3 = 4;
					
							row5.joueur2_prenom = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);
						
				
					columnIndexWithD_tFileInputDelimited_3 = 5;
					
							row5.joueur2_nationalite = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);
						
				
					columnIndexWithD_tFileInputDelimited_3 = 6;
					
						temp = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);
						if(temp.length() > 0) {
							
								try {
								
    								row5.seed = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_3) {
globalMap.put("tFileInputDelimited_3_ERROR_MESSAGE",ex_tFileInputDelimited_3.getMessage());
									rowstate_tFileInputDelimited_3.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"seed", "row5", temp, ex_tFileInputDelimited_3), ex_tFileInputDelimited_3));
								}
    							
						} else {						
							
								
									row5.seed = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_3 = 7;
					
							row5.round = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);
						
				
					columnIndexWithD_tFileInputDelimited_3 = 8;
					
							row5.score = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);
						
				
					columnIndexWithD_tFileInputDelimited_3 = 9;
					
							row5.resultat = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);
						
				
					columnIndexWithD_tFileInputDelimited_3 = 10;
					
						temp = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);
						if(temp.length() > 0) {
							
								try {
								
    									row5.date_tournoi = ParserUtils.parseTo_Date(temp, "yyyy-MM-dd");
    								
    							} catch(java.lang.Exception ex_tFileInputDelimited_3) {
globalMap.put("tFileInputDelimited_3_ERROR_MESSAGE",ex_tFileInputDelimited_3.getMessage());
									rowstate_tFileInputDelimited_3.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"date_tournoi", "row5", temp, ex_tFileInputDelimited_3), ex_tFileInputDelimited_3));
								}
    							
						} else {						
							
								
									row5.date_tournoi = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_3 = 11;
					
							row5.nom_tournoi = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);
						
				
					columnIndexWithD_tFileInputDelimited_3 = 12;
					
							row5.lieu_tournoi = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);
						
				
					columnIndexWithD_tFileInputDelimited_3 = 13;
					
						temp = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);
						if(temp.length() > 0) {
							
								try {
								
    								row5.prize_money = ParserUtils.parseTo_BigDecimal(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_3) {
globalMap.put("tFileInputDelimited_3_ERROR_MESSAGE",ex_tFileInputDelimited_3.getMessage());
									rowstate_tFileInputDelimited_3.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"prize_money", "row5", temp, ex_tFileInputDelimited_3), ex_tFileInputDelimited_3));
								}
    							
						} else {						
							
								
									row5.prize_money = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_3 = 14;
					
						temp = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);
						if(temp.length() > 0) {
							
								try {
								
    								row5.points = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_3) {
globalMap.put("tFileInputDelimited_3_ERROR_MESSAGE",ex_tFileInputDelimited_3.getMessage());
									rowstate_tFileInputDelimited_3.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"points", "row5", temp, ex_tFileInputDelimited_3), ex_tFileInputDelimited_3));
								}
    							
						} else {						
							
								
									row5.points = null;
								
							
						}
					
				
				
										
										if(rowstate_tFileInputDelimited_3.getException()!=null) {
											throw rowstate_tFileInputDelimited_3.getException();
										}
										
										
							
			    					} catch (java.lang.Exception e) {
globalMap.put("tFileInputDelimited_3_ERROR_MESSAGE",e.getMessage());
			        					whetherReject_tFileInputDelimited_3 = true;
			        					
			                					System.err.println(e.getMessage());
			                					row5 = null;
			                				
										
			    					}
								

 



/**
 * [tFileInputDelimited_3 begin ] stop
 */
	
	/**
	 * [tFileInputDelimited_3 main ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_3";

	

 


	tos_count_tFileInputDelimited_3++;

/**
 * [tFileInputDelimited_3 main ] stop
 */
	
	/**
	 * [tFileInputDelimited_3 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_3";

	

 



/**
 * [tFileInputDelimited_3 process_data_begin ] stop
 */
// Start of branch "row5"
if(row5 != null) { 



	
	/**
	 * [tLogRow_3 main ] start
	 */

	

	
	
	currentComponent="tLogRow_3";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row5"
						
						);
					}
					
///////////////////////		
						

				
				String[] row_tLogRow_3 = new String[15];
   				
	    		if(row5.joueur1_nom != null) { //              
                 row_tLogRow_3[0]=    						    
				                String.valueOf(row5.joueur1_nom)			
					          ;	
							
	    		} //			
    			   				
	    		if(row5.joueur1_prenom != null) { //              
                 row_tLogRow_3[1]=    						    
				                String.valueOf(row5.joueur1_prenom)			
					          ;	
							
	    		} //			
    			   				
	    		if(row5.joueur1_nationalite != null) { //              
                 row_tLogRow_3[2]=    						    
				                String.valueOf(row5.joueur1_nationalite)			
					          ;	
							
	    		} //			
    			   				
	    		if(row5.joueur2_nom != null) { //              
                 row_tLogRow_3[3]=    						    
				                String.valueOf(row5.joueur2_nom)			
					          ;	
							
	    		} //			
    			   				
	    		if(row5.joueur2_prenom != null) { //              
                 row_tLogRow_3[4]=    						    
				                String.valueOf(row5.joueur2_prenom)			
					          ;	
							
	    		} //			
    			   				
	    		if(row5.joueur2_nationalite != null) { //              
                 row_tLogRow_3[5]=    						    
				                String.valueOf(row5.joueur2_nationalite)			
					          ;	
							
	    		} //			
    			   				
	    		if(row5.seed != null) { //              
                 row_tLogRow_3[6]=    						    
				                String.valueOf(row5.seed)			
					          ;	
							
	    		} //			
    			   				
	    		if(row5.round != null) { //              
                 row_tLogRow_3[7]=    						    
				                String.valueOf(row5.round)			
					          ;	
							
	    		} //			
    			   				
	    		if(row5.score != null) { //              
                 row_tLogRow_3[8]=    						    
				                String.valueOf(row5.score)			
					          ;	
							
	    		} //			
    			   				
	    		if(row5.resultat != null) { //              
                 row_tLogRow_3[9]=    						    
				                String.valueOf(row5.resultat)			
					          ;	
							
	    		} //			
    			   				
	    		if(row5.date_tournoi != null) { //              
                 row_tLogRow_3[10]=    						
								FormatterUtils.format_Date(row5.date_tournoi, "yyyy-MM-dd")
					          ;	
							
	    		} //			
    			   				
	    		if(row5.nom_tournoi != null) { //              
                 row_tLogRow_3[11]=    						    
				                String.valueOf(row5.nom_tournoi)			
					          ;	
							
	    		} //			
    			   				
	    		if(row5.lieu_tournoi != null) { //              
                 row_tLogRow_3[12]=    						    
				                String.valueOf(row5.lieu_tournoi)			
					          ;	
							
	    		} //			
    			   				
	    		if(row5.prize_money != null) { //              
                 row_tLogRow_3[13]=    						
								row5.prize_money.toPlainString()
					          ;	
							
	    		} //			
    			   				
	    		if(row5.points != null) { //              
                 row_tLogRow_3[14]=    						    
				                String.valueOf(row5.points)			
					          ;	
							
	    		} //			
    			 

				util_tLogRow_3.addRow(row_tLogRow_3);	
				nb_line_tLogRow_3++;
//////

//////                    
                    
///////////////////////    			

 
     row6 = row5;


	tos_count_tLogRow_3++;

/**
 * [tLogRow_3 main ] stop
 */
	
	/**
	 * [tLogRow_3 process_data_begin ] start
	 */

	

	
	
	currentComponent="tLogRow_3";

	

 



/**
 * [tLogRow_3 process_data_begin ] stop
 */

	
	/**
	 * [tDBOutput_3 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_3";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row6"
						
						);
					}
					



        whetherReject_tDBOutput_3 = false;
                    if(row6.joueur1_nom == null) {
pstmt_tDBOutput_3.setNull(1, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_3.setString(1, row6.joueur1_nom);
}

                    if(row6.joueur1_prenom == null) {
pstmt_tDBOutput_3.setNull(2, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_3.setString(2, row6.joueur1_prenom);
}

                    if(row6.joueur1_nationalite == null) {
pstmt_tDBOutput_3.setNull(3, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_3.setString(3, row6.joueur1_nationalite);
}

                    if(row6.joueur2_nom == null) {
pstmt_tDBOutput_3.setNull(4, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_3.setString(4, row6.joueur2_nom);
}

                    if(row6.joueur2_prenom == null) {
pstmt_tDBOutput_3.setNull(5, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_3.setString(5, row6.joueur2_prenom);
}

                    if(row6.joueur2_nationalite == null) {
pstmt_tDBOutput_3.setNull(6, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_3.setString(6, row6.joueur2_nationalite);
}

                    if(row6.seed == null) {
pstmt_tDBOutput_3.setNull(7, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_3.setInt(7, row6.seed);
}

                    if(row6.round == null) {
pstmt_tDBOutput_3.setNull(8, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_3.setString(8, row6.round);
}

                    if(row6.score == null) {
pstmt_tDBOutput_3.setNull(9, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_3.setString(9, row6.score);
}

                    if(row6.resultat == null) {
pstmt_tDBOutput_3.setNull(10, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_3.setString(10, row6.resultat);
}

                    if(row6.date_tournoi != null) {
pstmt_tDBOutput_3.setTimestamp(11, new java.sql.Timestamp(row6.date_tournoi.getTime()));
} else {
pstmt_tDBOutput_3.setNull(11, java.sql.Types.TIMESTAMP);
}

                    if(row6.nom_tournoi == null) {
pstmt_tDBOutput_3.setNull(12, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_3.setString(12, row6.nom_tournoi);
}

                    if(row6.lieu_tournoi == null) {
pstmt_tDBOutput_3.setNull(13, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_3.setString(13, row6.lieu_tournoi);
}

                    pstmt_tDBOutput_3.setBigDecimal(14, row6.prize_money);

                    if(row6.points == null) {
pstmt_tDBOutput_3.setNull(15, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_3.setInt(15, row6.points);
}

			
    		pstmt_tDBOutput_3.addBatch();
    		nb_line_tDBOutput_3++;
    		  
    		  
    		  batchSizeCounter_tDBOutput_3++;
    		  
    			if ((batchSize_tDBOutput_3 > 0) && (batchSize_tDBOutput_3 <= batchSizeCounter_tDBOutput_3)) {
                try {
						int countSum_tDBOutput_3 = 0;
						    
						for(int countEach_tDBOutput_3: pstmt_tDBOutput_3.executeBatch()) {
							countSum_tDBOutput_3 += (countEach_tDBOutput_3 < 0 ? 0 : countEach_tDBOutput_3);
						}
				    	rowsToCommitCount_tDBOutput_3 += countSum_tDBOutput_3;
				    	
				    		insertedCount_tDBOutput_3 += countSum_tDBOutput_3;
				    	
            	    	batchSizeCounter_tDBOutput_3 = 0;
                }catch (java.sql.BatchUpdateException e_tDBOutput_3){
globalMap.put("tDBOutput_3_ERROR_MESSAGE",e_tDBOutput_3.getMessage());
				    	java.sql.SQLException ne_tDBOutput_3 = e_tDBOutput_3.getNextException(),sqle_tDBOutput_3=null;
				    	String errormessage_tDBOutput_3;
						if (ne_tDBOutput_3 != null) {
							// build new exception to provide the original cause
							sqle_tDBOutput_3 = new java.sql.SQLException(e_tDBOutput_3.getMessage() + "\ncaused by: " + ne_tDBOutput_3.getMessage(), ne_tDBOutput_3.getSQLState(), ne_tDBOutput_3.getErrorCode(), ne_tDBOutput_3);
							errormessage_tDBOutput_3 = sqle_tDBOutput_3.getMessage();
						}else{
							errormessage_tDBOutput_3 = e_tDBOutput_3.getMessage();
						}
				    	
				    	int countSum_tDBOutput_3 = 0;
						for(int countEach_tDBOutput_3: e_tDBOutput_3.getUpdateCounts()) {
							countSum_tDBOutput_3 += (countEach_tDBOutput_3 < 0 ? 0 : countEach_tDBOutput_3);
						}
						rowsToCommitCount_tDBOutput_3 += countSum_tDBOutput_3;
						
				    		insertedCount_tDBOutput_3 += countSum_tDBOutput_3;
				    	
				    	System.err.println(errormessage_tDBOutput_3);
				    	
					}
    			}
    		
    		    commitCounter_tDBOutput_3++;
                if(commitEvery_tDBOutput_3 <= commitCounter_tDBOutput_3) {
                if ((batchSize_tDBOutput_3 > 0) && (batchSizeCounter_tDBOutput_3 > 0)) {
                try {
                		int countSum_tDBOutput_3 = 0;
                		    
						for(int countEach_tDBOutput_3: pstmt_tDBOutput_3.executeBatch()) {
							countSum_tDBOutput_3 += (countEach_tDBOutput_3 < 0 ? 0 : countEach_tDBOutput_3);
						}
            	    	rowsToCommitCount_tDBOutput_3 += countSum_tDBOutput_3;
            	    	
            	    		insertedCount_tDBOutput_3 += countSum_tDBOutput_3;
            	    	
                batchSizeCounter_tDBOutput_3 = 0;
               }catch (java.sql.BatchUpdateException e_tDBOutput_3){
globalMap.put("tDBOutput_3_ERROR_MESSAGE",e_tDBOutput_3.getMessage());
			    	java.sql.SQLException ne_tDBOutput_3 = e_tDBOutput_3.getNextException(),sqle_tDBOutput_3=null;
			    	String errormessage_tDBOutput_3;
					if (ne_tDBOutput_3 != null) {
						// build new exception to provide the original cause
						sqle_tDBOutput_3 = new java.sql.SQLException(e_tDBOutput_3.getMessage() + "\ncaused by: " + ne_tDBOutput_3.getMessage(), ne_tDBOutput_3.getSQLState(), ne_tDBOutput_3.getErrorCode(), ne_tDBOutput_3);
						errormessage_tDBOutput_3 = sqle_tDBOutput_3.getMessage();
					}else{
						errormessage_tDBOutput_3 = e_tDBOutput_3.getMessage();
					}
			    	
			    	int countSum_tDBOutput_3 = 0;
					for(int countEach_tDBOutput_3: e_tDBOutput_3.getUpdateCounts()) {
						countSum_tDBOutput_3 += (countEach_tDBOutput_3 < 0 ? 0 : countEach_tDBOutput_3);
					}
					rowsToCommitCount_tDBOutput_3 += countSum_tDBOutput_3;
					
			    		insertedCount_tDBOutput_3 += countSum_tDBOutput_3;
			    	
			    	System.err.println(errormessage_tDBOutput_3);
			    	
				}
            }
                    if(rowsToCommitCount_tDBOutput_3 != 0){
                    	
                    }
                    conn_tDBOutput_3.commit();
                    if(rowsToCommitCount_tDBOutput_3 != 0){
                    	
                    	rowsToCommitCount_tDBOutput_3 = 0;
                    }
                    commitCounter_tDBOutput_3=0;
                }

 


	tos_count_tDBOutput_3++;

/**
 * [tDBOutput_3 main ] stop
 */
	
	/**
	 * [tDBOutput_3 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBOutput_3";

	

 



/**
 * [tDBOutput_3 process_data_begin ] stop
 */
	
	/**
	 * [tDBOutput_3 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBOutput_3";

	

 



/**
 * [tDBOutput_3 process_data_end ] stop
 */



	
	/**
	 * [tLogRow_3 process_data_end ] start
	 */

	

	
	
	currentComponent="tLogRow_3";

	

 



/**
 * [tLogRow_3 process_data_end ] stop
 */

} // End of branch "row5"




	
	/**
	 * [tFileInputDelimited_3 process_data_end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_3";

	

 



/**
 * [tFileInputDelimited_3 process_data_end ] stop
 */
	
	/**
	 * [tFileInputDelimited_3 end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_3";

	



            }
            }finally{
                if(!((Object)("C:/Users/ASUS/Downloads/Sports/Sports/script_tournois/feb.csv") instanceof java.io.InputStream)){
                	if(fid_tFileInputDelimited_3!=null){
                		fid_tFileInputDelimited_3.close();
                	}
                }
                if(fid_tFileInputDelimited_3!=null){
                	globalMap.put("tFileInputDelimited_3_NB_LINE", fid_tFileInputDelimited_3.getRowNumber());
					
                }
			}
			  

 

ok_Hash.put("tFileInputDelimited_3", true);
end_Hash.put("tFileInputDelimited_3", System.currentTimeMillis());




/**
 * [tFileInputDelimited_3 end ] stop
 */

	
	/**
	 * [tLogRow_3 end ] start
	 */

	

	
	
	currentComponent="tLogRow_3";

	


//////

                    
                    java.io.PrintStream consoleOut_tLogRow_3 = null;
                    if (globalMap.get("tLogRow_CONSOLE")!=null)
                    {
                    	consoleOut_tLogRow_3 = (java.io.PrintStream) globalMap.get("tLogRow_CONSOLE");
                    }
                    else
                    {
                    	consoleOut_tLogRow_3 = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));
                    	globalMap.put("tLogRow_CONSOLE",consoleOut_tLogRow_3);
                    }
                    
                    consoleOut_tLogRow_3.println(util_tLogRow_3.format().toString());
                    consoleOut_tLogRow_3.flush();
//////
globalMap.put("tLogRow_3_NB_LINE",nb_line_tLogRow_3);

///////////////////////    			

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row5");
			  	}
			  	
 

ok_Hash.put("tLogRow_3", true);
end_Hash.put("tLogRow_3", System.currentTimeMillis());




/**
 * [tLogRow_3 end ] stop
 */

	
	/**
	 * [tDBOutput_3 end ] start
	 */

	

	
	
	currentComponent="tDBOutput_3";

	



	    try {
				int countSum_tDBOutput_3 = 0;
				if (pstmt_tDBOutput_3 != null && batchSizeCounter_tDBOutput_3 > 0) {
						
					for(int countEach_tDBOutput_3: pstmt_tDBOutput_3.executeBatch()) {
						countSum_tDBOutput_3 += (countEach_tDBOutput_3 < 0 ? 0 : countEach_tDBOutput_3);
					}
					rowsToCommitCount_tDBOutput_3 += countSum_tDBOutput_3;
						
				}
		    	
		    		insertedCount_tDBOutput_3 += countSum_tDBOutput_3;
		    	
	    }catch (java.sql.BatchUpdateException e_tDBOutput_3){
globalMap.put("tDBOutput_3_ERROR_MESSAGE",e_tDBOutput_3.getMessage());
	    	java.sql.SQLException ne_tDBOutput_3 = e_tDBOutput_3.getNextException(),sqle_tDBOutput_3=null;
	    	String errormessage_tDBOutput_3;
			if (ne_tDBOutput_3 != null) {
				// build new exception to provide the original cause
				sqle_tDBOutput_3 = new java.sql.SQLException(e_tDBOutput_3.getMessage() + "\ncaused by: " + ne_tDBOutput_3.getMessage(), ne_tDBOutput_3.getSQLState(), ne_tDBOutput_3.getErrorCode(), ne_tDBOutput_3);
				errormessage_tDBOutput_3 = sqle_tDBOutput_3.getMessage();
			}else{
				errormessage_tDBOutput_3 = e_tDBOutput_3.getMessage();
			}
	    	
	    	int countSum_tDBOutput_3 = 0;
			for(int countEach_tDBOutput_3: e_tDBOutput_3.getUpdateCounts()) {
				countSum_tDBOutput_3 += (countEach_tDBOutput_3 < 0 ? 0 : countEach_tDBOutput_3);
			}
			rowsToCommitCount_tDBOutput_3 += countSum_tDBOutput_3;
			
	    		insertedCount_tDBOutput_3 += countSum_tDBOutput_3;
	    	
	    	System.err.println(errormessage_tDBOutput_3);
	    	
		}
	    
        if(pstmt_tDBOutput_3 != null) {
        		
            pstmt_tDBOutput_3.close();
            resourceMap.remove("pstmt_tDBOutput_3");
        }
    resourceMap.put("statementClosed_tDBOutput_3", true);
			if(rowsToCommitCount_tDBOutput_3 != 0){
				
			}
			conn_tDBOutput_3.commit();
			if(rowsToCommitCount_tDBOutput_3 != 0){
				
				rowsToCommitCount_tDBOutput_3 = 0;
			}
			commitCounter_tDBOutput_3 = 0;
		
    	conn_tDBOutput_3 .close();
    	
    	resourceMap.put("finish_tDBOutput_3", true);
    	

	nb_line_deleted_tDBOutput_3=nb_line_deleted_tDBOutput_3+ deletedCount_tDBOutput_3;
	nb_line_update_tDBOutput_3=nb_line_update_tDBOutput_3 + updatedCount_tDBOutput_3;
	nb_line_inserted_tDBOutput_3=nb_line_inserted_tDBOutput_3 + insertedCount_tDBOutput_3;
	nb_line_rejected_tDBOutput_3=nb_line_rejected_tDBOutput_3 + rejectedCount_tDBOutput_3;
	
        globalMap.put("tDBOutput_3_NB_LINE",nb_line_tDBOutput_3);
        globalMap.put("tDBOutput_3_NB_LINE_UPDATED",nb_line_update_tDBOutput_3);
        globalMap.put("tDBOutput_3_NB_LINE_INSERTED",nb_line_inserted_tDBOutput_3);
        globalMap.put("tDBOutput_3_NB_LINE_DELETED",nb_line_deleted_tDBOutput_3);
        globalMap.put("tDBOutput_3_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_3);
    

	


				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row6");
			  	}
			  	
 

ok_Hash.put("tDBOutput_3", true);
end_Hash.put("tDBOutput_3", System.currentTimeMillis());




/**
 * [tDBOutput_3 end ] stop
 */






				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tFileInputDelimited_3 finally ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_3";

	

 



/**
 * [tFileInputDelimited_3 finally ] stop
 */

	
	/**
	 * [tLogRow_3 finally ] start
	 */

	

	
	
	currentComponent="tLogRow_3";

	

 



/**
 * [tLogRow_3 finally ] stop
 */

	
	/**
	 * [tDBOutput_3 finally ] start
	 */

	

	
	
	currentComponent="tDBOutput_3";

	



    try {
    if (resourceMap.get("statementClosed_tDBOutput_3") == null) {
                java.sql.PreparedStatement pstmtToClose_tDBOutput_3 = null;
                if ((pstmtToClose_tDBOutput_3 = (java.sql.PreparedStatement) resourceMap.remove("pstmt_tDBOutput_3")) != null) {
                    pstmtToClose_tDBOutput_3.close();
                }
    }
    } finally {
        if(resourceMap.get("finish_tDBOutput_3") == null){
            java.sql.Connection ctn_tDBOutput_3 = null;
            if((ctn_tDBOutput_3 = (java.sql.Connection)resourceMap.get("conn_tDBOutput_3")) != null){
                try {
                    ctn_tDBOutput_3.close();
                } catch (java.sql.SQLException sqlEx_tDBOutput_3) {
                    String errorMessage_tDBOutput_3 = "failed to close the connection in tDBOutput_3 :" + sqlEx_tDBOutput_3.getMessage();
                    System.err.println(errorMessage_tDBOutput_3);
                }
            }
        }
    }
 



/**
 * [tDBOutput_3 finally ] stop
 */






				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tFileInputDelimited_3_SUBPROCESS_STATE", 1);
	}
	


public static class row8Struct implements routines.system.IPersistableRow<row8Struct> {
    final static byte[] commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[0];
    static byte[] commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[0];

	
			    public String joueur1_nom;

				public String getJoueur1_nom () {
					return this.joueur1_nom;
				}
				
			    public String joueur1_prenom;

				public String getJoueur1_prenom () {
					return this.joueur1_prenom;
				}
				
			    public String joueur1_nationalite;

				public String getJoueur1_nationalite () {
					return this.joueur1_nationalite;
				}
				
			    public String joueur2_nom;

				public String getJoueur2_nom () {
					return this.joueur2_nom;
				}
				
			    public String joueur2_prenom;

				public String getJoueur2_prenom () {
					return this.joueur2_prenom;
				}
				
			    public String joueur2_nationalite;

				public String getJoueur2_nationalite () {
					return this.joueur2_nationalite;
				}
				
			    public Integer seed;

				public Integer getSeed () {
					return this.seed;
				}
				
			    public String round;

				public String getRound () {
					return this.round;
				}
				
			    public String score;

				public String getScore () {
					return this.score;
				}
				
			    public String resultat;

				public String getResultat () {
					return this.resultat;
				}
				
			    public java.util.Date date_tournoi;

				public java.util.Date getDate_tournoi () {
					return this.date_tournoi;
				}
				
			    public String nom_tournoi;

				public String getNom_tournoi () {
					return this.nom_tournoi;
				}
				
			    public String lieu_tournoi;

				public String getLieu_tournoi () {
					return this.lieu_tournoi;
				}
				
			    public BigDecimal prize_money;

				public BigDecimal getPrize_money () {
					return this.prize_money;
				}
				
			    public Integer points;

				public Integer getPoints () {
					return this.points;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length) {
				if(length < 1024 && commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length == 0) {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[1024];
				} else {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length);
			strReturn = new String(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length) {
				if(length < 1024 && commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length == 0) {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[1024];
				} else {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length);
			strReturn = new String(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep) {

        	try {

        		int length = 0;
		
					this.joueur1_nom = readString(dis);
					
					this.joueur1_prenom = readString(dis);
					
					this.joueur1_nationalite = readString(dis);
					
					this.joueur2_nom = readString(dis);
					
					this.joueur2_prenom = readString(dis);
					
					this.joueur2_nationalite = readString(dis);
					
						this.seed = readInteger(dis);
					
					this.round = readString(dis);
					
					this.score = readString(dis);
					
					this.resultat = readString(dis);
					
					this.date_tournoi = readDate(dis);
					
					this.nom_tournoi = readString(dis);
					
					this.lieu_tournoi = readString(dis);
					
						this.prize_money = (BigDecimal) dis.readObject();
					
						this.points = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep) {

        	try {

        		int length = 0;
		
					this.joueur1_nom = readString(dis);
					
					this.joueur1_prenom = readString(dis);
					
					this.joueur1_nationalite = readString(dis);
					
					this.joueur2_nom = readString(dis);
					
					this.joueur2_prenom = readString(dis);
					
					this.joueur2_nationalite = readString(dis);
					
						this.seed = readInteger(dis);
					
					this.round = readString(dis);
					
					this.score = readString(dis);
					
					this.resultat = readString(dis);
					
					this.date_tournoi = readDate(dis);
					
					this.nom_tournoi = readString(dis);
					
					this.lieu_tournoi = readString(dis);
					
						this.prize_money = (BigDecimal) dis.readObject();
					
						this.points = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.joueur1_nom,dos);
					
					// String
				
						writeString(this.joueur1_prenom,dos);
					
					// String
				
						writeString(this.joueur1_nationalite,dos);
					
					// String
				
						writeString(this.joueur2_nom,dos);
					
					// String
				
						writeString(this.joueur2_prenom,dos);
					
					// String
				
						writeString(this.joueur2_nationalite,dos);
					
					// Integer
				
						writeInteger(this.seed,dos);
					
					// String
				
						writeString(this.round,dos);
					
					// String
				
						writeString(this.score,dos);
					
					// String
				
						writeString(this.resultat,dos);
					
					// java.util.Date
				
						writeDate(this.date_tournoi,dos);
					
					// String
				
						writeString(this.nom_tournoi,dos);
					
					// String
				
						writeString(this.lieu_tournoi,dos);
					
					// BigDecimal
				
       			    	dos.writeObject(this.prize_money);
					
					// Integer
				
						writeInteger(this.points,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.joueur1_nom,dos);
					
					// String
				
						writeString(this.joueur1_prenom,dos);
					
					// String
				
						writeString(this.joueur1_nationalite,dos);
					
					// String
				
						writeString(this.joueur2_nom,dos);
					
					// String
				
						writeString(this.joueur2_prenom,dos);
					
					// String
				
						writeString(this.joueur2_nationalite,dos);
					
					// Integer
				
						writeInteger(this.seed,dos);
					
					// String
				
						writeString(this.round,dos);
					
					// String
				
						writeString(this.score,dos);
					
					// String
				
						writeString(this.resultat,dos);
					
					// java.util.Date
				
						writeDate(this.date_tournoi,dos);
					
					// String
				
						writeString(this.nom_tournoi,dos);
					
					// String
				
						writeString(this.lieu_tournoi,dos);
					
					// BigDecimal
				
       			    	dos.writeObject(this.prize_money);
					
					// Integer
				
						writeInteger(this.points,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("joueur1_nom="+joueur1_nom);
		sb.append(",joueur1_prenom="+joueur1_prenom);
		sb.append(",joueur1_nationalite="+joueur1_nationalite);
		sb.append(",joueur2_nom="+joueur2_nom);
		sb.append(",joueur2_prenom="+joueur2_prenom);
		sb.append(",joueur2_nationalite="+joueur2_nationalite);
		sb.append(",seed="+String.valueOf(seed));
		sb.append(",round="+round);
		sb.append(",score="+score);
		sb.append(",resultat="+resultat);
		sb.append(",date_tournoi="+String.valueOf(date_tournoi));
		sb.append(",nom_tournoi="+nom_tournoi);
		sb.append(",lieu_tournoi="+lieu_tournoi);
		sb.append(",prize_money="+String.valueOf(prize_money));
		sb.append(",points="+String.valueOf(points));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row8Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class row7Struct implements routines.system.IPersistableRow<row7Struct> {
    final static byte[] commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[0];
    static byte[] commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[0];

	
			    public String joueur1_nom;

				public String getJoueur1_nom () {
					return this.joueur1_nom;
				}
				
			    public String joueur1_prenom;

				public String getJoueur1_prenom () {
					return this.joueur1_prenom;
				}
				
			    public String joueur1_nationalite;

				public String getJoueur1_nationalite () {
					return this.joueur1_nationalite;
				}
				
			    public String joueur2_nom;

				public String getJoueur2_nom () {
					return this.joueur2_nom;
				}
				
			    public String joueur2_prenom;

				public String getJoueur2_prenom () {
					return this.joueur2_prenom;
				}
				
			    public String joueur2_nationalite;

				public String getJoueur2_nationalite () {
					return this.joueur2_nationalite;
				}
				
			    public Integer seed;

				public Integer getSeed () {
					return this.seed;
				}
				
			    public String round;

				public String getRound () {
					return this.round;
				}
				
			    public String score;

				public String getScore () {
					return this.score;
				}
				
			    public String resultat;

				public String getResultat () {
					return this.resultat;
				}
				
			    public java.util.Date date_tournoi;

				public java.util.Date getDate_tournoi () {
					return this.date_tournoi;
				}
				
			    public String nom_tournoi;

				public String getNom_tournoi () {
					return this.nom_tournoi;
				}
				
			    public String lieu_tournoi;

				public String getLieu_tournoi () {
					return this.lieu_tournoi;
				}
				
			    public BigDecimal prize_money;

				public BigDecimal getPrize_money () {
					return this.prize_money;
				}
				
			    public Integer points;

				public Integer getPoints () {
					return this.points;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length) {
				if(length < 1024 && commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length == 0) {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[1024];
				} else {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length);
			strReturn = new String(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length) {
				if(length < 1024 && commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length == 0) {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[1024];
				} else {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length);
			strReturn = new String(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep) {

        	try {

        		int length = 0;
		
					this.joueur1_nom = readString(dis);
					
					this.joueur1_prenom = readString(dis);
					
					this.joueur1_nationalite = readString(dis);
					
					this.joueur2_nom = readString(dis);
					
					this.joueur2_prenom = readString(dis);
					
					this.joueur2_nationalite = readString(dis);
					
						this.seed = readInteger(dis);
					
					this.round = readString(dis);
					
					this.score = readString(dis);
					
					this.resultat = readString(dis);
					
					this.date_tournoi = readDate(dis);
					
					this.nom_tournoi = readString(dis);
					
					this.lieu_tournoi = readString(dis);
					
						this.prize_money = (BigDecimal) dis.readObject();
					
						this.points = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep) {

        	try {

        		int length = 0;
		
					this.joueur1_nom = readString(dis);
					
					this.joueur1_prenom = readString(dis);
					
					this.joueur1_nationalite = readString(dis);
					
					this.joueur2_nom = readString(dis);
					
					this.joueur2_prenom = readString(dis);
					
					this.joueur2_nationalite = readString(dis);
					
						this.seed = readInteger(dis);
					
					this.round = readString(dis);
					
					this.score = readString(dis);
					
					this.resultat = readString(dis);
					
					this.date_tournoi = readDate(dis);
					
					this.nom_tournoi = readString(dis);
					
					this.lieu_tournoi = readString(dis);
					
						this.prize_money = (BigDecimal) dis.readObject();
					
						this.points = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.joueur1_nom,dos);
					
					// String
				
						writeString(this.joueur1_prenom,dos);
					
					// String
				
						writeString(this.joueur1_nationalite,dos);
					
					// String
				
						writeString(this.joueur2_nom,dos);
					
					// String
				
						writeString(this.joueur2_prenom,dos);
					
					// String
				
						writeString(this.joueur2_nationalite,dos);
					
					// Integer
				
						writeInteger(this.seed,dos);
					
					// String
				
						writeString(this.round,dos);
					
					// String
				
						writeString(this.score,dos);
					
					// String
				
						writeString(this.resultat,dos);
					
					// java.util.Date
				
						writeDate(this.date_tournoi,dos);
					
					// String
				
						writeString(this.nom_tournoi,dos);
					
					// String
				
						writeString(this.lieu_tournoi,dos);
					
					// BigDecimal
				
       			    	dos.writeObject(this.prize_money);
					
					// Integer
				
						writeInteger(this.points,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.joueur1_nom,dos);
					
					// String
				
						writeString(this.joueur1_prenom,dos);
					
					// String
				
						writeString(this.joueur1_nationalite,dos);
					
					// String
				
						writeString(this.joueur2_nom,dos);
					
					// String
				
						writeString(this.joueur2_prenom,dos);
					
					// String
				
						writeString(this.joueur2_nationalite,dos);
					
					// Integer
				
						writeInteger(this.seed,dos);
					
					// String
				
						writeString(this.round,dos);
					
					// String
				
						writeString(this.score,dos);
					
					// String
				
						writeString(this.resultat,dos);
					
					// java.util.Date
				
						writeDate(this.date_tournoi,dos);
					
					// String
				
						writeString(this.nom_tournoi,dos);
					
					// String
				
						writeString(this.lieu_tournoi,dos);
					
					// BigDecimal
				
       			    	dos.writeObject(this.prize_money);
					
					// Integer
				
						writeInteger(this.points,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("joueur1_nom="+joueur1_nom);
		sb.append(",joueur1_prenom="+joueur1_prenom);
		sb.append(",joueur1_nationalite="+joueur1_nationalite);
		sb.append(",joueur2_nom="+joueur2_nom);
		sb.append(",joueur2_prenom="+joueur2_prenom);
		sb.append(",joueur2_nationalite="+joueur2_nationalite);
		sb.append(",seed="+String.valueOf(seed));
		sb.append(",round="+round);
		sb.append(",score="+score);
		sb.append(",resultat="+resultat);
		sb.append(",date_tournoi="+String.valueOf(date_tournoi));
		sb.append(",nom_tournoi="+nom_tournoi);
		sb.append(",lieu_tournoi="+lieu_tournoi);
		sb.append(",prize_money="+String.valueOf(prize_money));
		sb.append(",points="+String.valueOf(points));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row7Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tFileInputDelimited_4Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tFileInputDelimited_4_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row7Struct row7 = new row7Struct();
row7Struct row8 = row7;





	
	/**
	 * [tDBOutput_4 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBOutput_4", false);
		start_Hash.put("tDBOutput_4", System.currentTimeMillis());
		
	
	currentComponent="tDBOutput_4";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row8");
					}
				
		int tos_count_tDBOutput_4 = 0;
		





String dbschema_tDBOutput_4 = null;
	dbschema_tDBOutput_4 = "sa";
	

String tableName_tDBOutput_4 = null;
if(dbschema_tDBOutput_4 == null || dbschema_tDBOutput_4.trim().length() == 0) {
	tableName_tDBOutput_4 = ("sa_tournament_dec");
} else {
	tableName_tDBOutput_4 = dbschema_tDBOutput_4 + "\".\"" + ("sa_tournament_dec");
}


int nb_line_tDBOutput_4 = 0;
int nb_line_update_tDBOutput_4 = 0;
int nb_line_inserted_tDBOutput_4 = 0;
int nb_line_deleted_tDBOutput_4 = 0;
int nb_line_rejected_tDBOutput_4 = 0;

int deletedCount_tDBOutput_4=0;
int updatedCount_tDBOutput_4=0;
int insertedCount_tDBOutput_4=0;
int rowsToCommitCount_tDBOutput_4=0;
int rejectedCount_tDBOutput_4=0;

boolean whetherReject_tDBOutput_4 = false;

java.sql.Connection conn_tDBOutput_4 = null;
String dbUser_tDBOutput_4 = null;

	
    java.lang.Class.forName("org.postgresql.Driver");
    
        String url_tDBOutput_4 = "jdbc:postgresql://"+"localhost"+":"+"5432"+"/"+"padel_bi_SA";
    dbUser_tDBOutput_4 = "postgres";
 
	final String decryptedPassword_tDBOutput_4 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:u6Y97hCnLhtiQPx1yLLS13Kp9esbX8k0faNUudAX9nvmnduObQ==");

    String dbPwd_tDBOutput_4 = decryptedPassword_tDBOutput_4;

    conn_tDBOutput_4 = java.sql.DriverManager.getConnection(url_tDBOutput_4,dbUser_tDBOutput_4,dbPwd_tDBOutput_4);
	
	resourceMap.put("conn_tDBOutput_4", conn_tDBOutput_4);
        conn_tDBOutput_4.setAutoCommit(false);
        int commitEvery_tDBOutput_4 = 10000;
        int commitCounter_tDBOutput_4 = 0;


   int batchSize_tDBOutput_4 = 10000;
   int batchSizeCounter_tDBOutput_4=0;

int count_tDBOutput_4=0;
	    String insert_tDBOutput_4 = "INSERT INTO \"" + tableName_tDBOutput_4 + "\" (\"joueur1_nom\",\"joueur1_prenom\",\"joueur1_nationalite\",\"joueur2_nom\",\"joueur2_prenom\",\"joueur2_nationalite\",\"seed\",\"round\",\"score\",\"resultat\",\"date_tournoi\",\"nom_tournoi\",\"lieu_tournoi\",\"prize_money\",\"points\") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	    
	    java.sql.PreparedStatement pstmt_tDBOutput_4 = conn_tDBOutput_4.prepareStatement(insert_tDBOutput_4);
	    resourceMap.put("pstmt_tDBOutput_4", pstmt_tDBOutput_4);
	    

 



/**
 * [tDBOutput_4 begin ] stop
 */



	
	/**
	 * [tLogRow_4 begin ] start
	 */

	

	
		
		ok_Hash.put("tLogRow_4", false);
		start_Hash.put("tLogRow_4", System.currentTimeMillis());
		
	
	currentComponent="tLogRow_4";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row7");
					}
				
		int tos_count_tLogRow_4 = 0;
		

	///////////////////////
	
         class Util_tLogRow_4 {

        String[] des_top = { ".", ".", "-", "+" };

        String[] des_head = { "|=", "=|", "-", "+" };

        String[] des_bottom = { "'", "'", "-", "+" };

        String name="";

        java.util.List<String[]> list = new java.util.ArrayList<String[]>();

        int[] colLengths = new int[15];

        public void addRow(String[] row) {

            for (int i = 0; i < 15; i++) {
                if (row[i]!=null) {
                  colLengths[i] = Math.max(colLengths[i], row[i].length());
                }
            }
            list.add(row);
        }

        public void setTableName(String name) {

            this.name = name;
        }

            public StringBuilder format() {
            
                StringBuilder sb = new StringBuilder();
  
            
                    sb.append(print(des_top));
    
                    int totals = 0;
                    for (int i = 0; i < colLengths.length; i++) {
                        totals = totals + colLengths[i];
                    }
    
                    // name
                    sb.append("|");
                    int k = 0;
                    for (k = 0; k < (totals + 14 - name.length()) / 2; k++) {
                        sb.append(' ');
                    }
                    sb.append(name);
                    for (int i = 0; i < totals + 14 - name.length() - k; i++) {
                        sb.append(' ');
                    }
                    sb.append("|\n");

                    // head and rows
                    sb.append(print(des_head));
                    for (int i = 0; i < list.size(); i++) {
    
                        String[] row = list.get(i);
    
                        java.util.Formatter formatter = new java.util.Formatter(new StringBuilder());
                        
                        StringBuilder sbformat = new StringBuilder();                                             
        			        sbformat.append("|%1$-");
        			        sbformat.append(colLengths[0]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%2$-");
        			        sbformat.append(colLengths[1]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%3$-");
        			        sbformat.append(colLengths[2]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%4$-");
        			        sbformat.append(colLengths[3]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%5$-");
        			        sbformat.append(colLengths[4]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%6$-");
        			        sbformat.append(colLengths[5]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%7$-");
        			        sbformat.append(colLengths[6]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%8$-");
        			        sbformat.append(colLengths[7]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%9$-");
        			        sbformat.append(colLengths[8]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%10$-");
        			        sbformat.append(colLengths[9]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%11$-");
        			        sbformat.append(colLengths[10]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%12$-");
        			        sbformat.append(colLengths[11]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%13$-");
        			        sbformat.append(colLengths[12]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%14$-");
        			        sbformat.append(colLengths[13]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%15$-");
        			        sbformat.append(colLengths[14]);
        			        sbformat.append("s");
        			                      
                        sbformat.append("|\n");                    
       
                        formatter.format(sbformat.toString(), (Object[])row);	
                                
                        sb.append(formatter.toString());
                        if (i == 0)
                            sb.append(print(des_head)); // print the head
                    }
    
                    // end
                    sb.append(print(des_bottom));
                    return sb;
                }
            

            private StringBuilder print(String[] fillChars) {
                StringBuilder sb = new StringBuilder();
                //first column
                sb.append(fillChars[0]);                
                    for (int i = 0; i < colLengths[0] - fillChars[0].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);	                

                    for (int i = 0; i < colLengths[1] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[2] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[3] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[4] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[5] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[6] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[7] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[8] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[9] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[10] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[11] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[12] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[13] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                
                    //last column
                    for (int i = 0; i < colLengths[14] - fillChars[1].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }         
                sb.append(fillChars[1]);
                sb.append("\n");               
                return sb;
            }
            
            public boolean isTableEmpty(){
            	if (list.size() > 1)
            		return false;
            	return true;
            }
        }
        Util_tLogRow_4 util_tLogRow_4 = new Util_tLogRow_4();
        util_tLogRow_4.setTableName("tLogRow_4");
        util_tLogRow_4.addRow(new String[]{"joueur1_nom","joueur1_prenom","joueur1_nationalite","joueur2_nom","joueur2_prenom","joueur2_nationalite","seed","round","score","resultat","date_tournoi","nom_tournoi","lieu_tournoi","prize_money","points",});        
 		StringBuilder strBuffer_tLogRow_4 = null;
		int nb_line_tLogRow_4 = 0;
///////////////////////    			



 



/**
 * [tLogRow_4 begin ] stop
 */



	
	/**
	 * [tFileInputDelimited_4 begin ] start
	 */

	

	
		
		ok_Hash.put("tFileInputDelimited_4", false);
		start_Hash.put("tFileInputDelimited_4", System.currentTimeMillis());
		
	
	currentComponent="tFileInputDelimited_4";

	
		int tos_count_tFileInputDelimited_4 = 0;
		
	
	
	
 
	
	
	final routines.system.RowState rowstate_tFileInputDelimited_4 = new routines.system.RowState();
	
	
				int nb_line_tFileInputDelimited_4 = 0;
				org.talend.fileprocess.FileInputDelimited fid_tFileInputDelimited_4 = null;
				int limit_tFileInputDelimited_4 = -1;
				try{
					
						Object filename_tFileInputDelimited_4 = "C:/Users/ASUS/Downloads/Sports/Sports/script_tournois/dec.csv";
						if(filename_tFileInputDelimited_4 instanceof java.io.InputStream){
							
			int footer_value_tFileInputDelimited_4 = 0, random_value_tFileInputDelimited_4 = -1;
			if(footer_value_tFileInputDelimited_4 >0 || random_value_tFileInputDelimited_4 > 0){
				throw new java.lang.Exception("When the input source is a stream,footer and random shouldn't be bigger than 0.");				
			}
		
						}
						try {
							fid_tFileInputDelimited_4 = new org.talend.fileprocess.FileInputDelimited("C:/Users/ASUS/Downloads/Sports/Sports/script_tournois/dec.csv", "ISO-8859-15",";","\n",true,1,0,
									limit_tFileInputDelimited_4
								,-1, false);
						} catch(java.lang.Exception e) {
globalMap.put("tFileInputDelimited_4_ERROR_MESSAGE",e.getMessage());
							
								
								System.err.println(e.getMessage());
							
						}
					
				    
					while (fid_tFileInputDelimited_4!=null && fid_tFileInputDelimited_4.nextRecord()) {
						rowstate_tFileInputDelimited_4.reset();
						
			    						row7 = null;			
												
									boolean whetherReject_tFileInputDelimited_4 = false;
									row7 = new row7Struct();
									try {
										
				int columnIndexWithD_tFileInputDelimited_4 = 0;
				
					String temp = ""; 
				
					columnIndexWithD_tFileInputDelimited_4 = 0;
					
							row7.joueur1_nom = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						
				
					columnIndexWithD_tFileInputDelimited_4 = 1;
					
							row7.joueur1_prenom = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						
				
					columnIndexWithD_tFileInputDelimited_4 = 2;
					
							row7.joueur1_nationalite = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						
				
					columnIndexWithD_tFileInputDelimited_4 = 3;
					
							row7.joueur2_nom = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						
				
					columnIndexWithD_tFileInputDelimited_4 = 4;
					
							row7.joueur2_prenom = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						
				
					columnIndexWithD_tFileInputDelimited_4 = 5;
					
							row7.joueur2_nationalite = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						
				
					columnIndexWithD_tFileInputDelimited_4 = 6;
					
						temp = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						if(temp.length() > 0) {
							
								try {
								
    								row7.seed = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_4) {
globalMap.put("tFileInputDelimited_4_ERROR_MESSAGE",ex_tFileInputDelimited_4.getMessage());
									rowstate_tFileInputDelimited_4.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"seed", "row7", temp, ex_tFileInputDelimited_4), ex_tFileInputDelimited_4));
								}
    							
						} else {						
							
								
									row7.seed = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_4 = 7;
					
							row7.round = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						
				
					columnIndexWithD_tFileInputDelimited_4 = 8;
					
							row7.score = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						
				
					columnIndexWithD_tFileInputDelimited_4 = 9;
					
							row7.resultat = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						
				
					columnIndexWithD_tFileInputDelimited_4 = 10;
					
						temp = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						if(temp.length() > 0) {
							
								try {
								
    									row7.date_tournoi = ParserUtils.parseTo_Date(temp, "dd/MM/yyyy");
    								
    							} catch(java.lang.Exception ex_tFileInputDelimited_4) {
globalMap.put("tFileInputDelimited_4_ERROR_MESSAGE",ex_tFileInputDelimited_4.getMessage());
									rowstate_tFileInputDelimited_4.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"date_tournoi", "row7", temp, ex_tFileInputDelimited_4), ex_tFileInputDelimited_4));
								}
    							
						} else {						
							
								
									row7.date_tournoi = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_4 = 11;
					
							row7.nom_tournoi = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						
				
					columnIndexWithD_tFileInputDelimited_4 = 12;
					
							row7.lieu_tournoi = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						
				
					columnIndexWithD_tFileInputDelimited_4 = 13;
					
						temp = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						if(temp.length() > 0) {
							
								try {
								
    								row7.prize_money = ParserUtils.parseTo_BigDecimal(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_4) {
globalMap.put("tFileInputDelimited_4_ERROR_MESSAGE",ex_tFileInputDelimited_4.getMessage());
									rowstate_tFileInputDelimited_4.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"prize_money", "row7", temp, ex_tFileInputDelimited_4), ex_tFileInputDelimited_4));
								}
    							
						} else {						
							
								
									row7.prize_money = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_4 = 14;
					
						temp = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						if(temp.length() > 0) {
							
								try {
								
    								row7.points = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_4) {
globalMap.put("tFileInputDelimited_4_ERROR_MESSAGE",ex_tFileInputDelimited_4.getMessage());
									rowstate_tFileInputDelimited_4.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"points", "row7", temp, ex_tFileInputDelimited_4), ex_tFileInputDelimited_4));
								}
    							
						} else {						
							
								
									row7.points = null;
								
							
						}
					
				
				
										
										if(rowstate_tFileInputDelimited_4.getException()!=null) {
											throw rowstate_tFileInputDelimited_4.getException();
										}
										
										
							
			    					} catch (java.lang.Exception e) {
globalMap.put("tFileInputDelimited_4_ERROR_MESSAGE",e.getMessage());
			        					whetherReject_tFileInputDelimited_4 = true;
			        					
			                					System.err.println(e.getMessage());
			                					row7 = null;
			                				
										
			    					}
								

 



/**
 * [tFileInputDelimited_4 begin ] stop
 */
	
	/**
	 * [tFileInputDelimited_4 main ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_4";

	

 


	tos_count_tFileInputDelimited_4++;

/**
 * [tFileInputDelimited_4 main ] stop
 */
	
	/**
	 * [tFileInputDelimited_4 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_4";

	

 



/**
 * [tFileInputDelimited_4 process_data_begin ] stop
 */
// Start of branch "row7"
if(row7 != null) { 



	
	/**
	 * [tLogRow_4 main ] start
	 */

	

	
	
	currentComponent="tLogRow_4";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row7"
						
						);
					}
					
///////////////////////		
						

				
				String[] row_tLogRow_4 = new String[15];
   				
	    		if(row7.joueur1_nom != null) { //              
                 row_tLogRow_4[0]=    						    
				                String.valueOf(row7.joueur1_nom)			
					          ;	
							
	    		} //			
    			   				
	    		if(row7.joueur1_prenom != null) { //              
                 row_tLogRow_4[1]=    						    
				                String.valueOf(row7.joueur1_prenom)			
					          ;	
							
	    		} //			
    			   				
	    		if(row7.joueur1_nationalite != null) { //              
                 row_tLogRow_4[2]=    						    
				                String.valueOf(row7.joueur1_nationalite)			
					          ;	
							
	    		} //			
    			   				
	    		if(row7.joueur2_nom != null) { //              
                 row_tLogRow_4[3]=    						    
				                String.valueOf(row7.joueur2_nom)			
					          ;	
							
	    		} //			
    			   				
	    		if(row7.joueur2_prenom != null) { //              
                 row_tLogRow_4[4]=    						    
				                String.valueOf(row7.joueur2_prenom)			
					          ;	
							
	    		} //			
    			   				
	    		if(row7.joueur2_nationalite != null) { //              
                 row_tLogRow_4[5]=    						    
				                String.valueOf(row7.joueur2_nationalite)			
					          ;	
							
	    		} //			
    			   				
	    		if(row7.seed != null) { //              
                 row_tLogRow_4[6]=    						    
				                String.valueOf(row7.seed)			
					          ;	
							
	    		} //			
    			   				
	    		if(row7.round != null) { //              
                 row_tLogRow_4[7]=    						    
				                String.valueOf(row7.round)			
					          ;	
							
	    		} //			
    			   				
	    		if(row7.score != null) { //              
                 row_tLogRow_4[8]=    						    
				                String.valueOf(row7.score)			
					          ;	
							
	    		} //			
    			   				
	    		if(row7.resultat != null) { //              
                 row_tLogRow_4[9]=    						    
				                String.valueOf(row7.resultat)			
					          ;	
							
	    		} //			
    			   				
	    		if(row7.date_tournoi != null) { //              
                 row_tLogRow_4[10]=    						
								FormatterUtils.format_Date(row7.date_tournoi, "dd/MM/yyyy")
					          ;	
							
	    		} //			
    			   				
	    		if(row7.nom_tournoi != null) { //              
                 row_tLogRow_4[11]=    						    
				                String.valueOf(row7.nom_tournoi)			
					          ;	
							
	    		} //			
    			   				
	    		if(row7.lieu_tournoi != null) { //              
                 row_tLogRow_4[12]=    						    
				                String.valueOf(row7.lieu_tournoi)			
					          ;	
							
	    		} //			
    			   				
	    		if(row7.prize_money != null) { //              
                 row_tLogRow_4[13]=    						
								row7.prize_money.toPlainString()
					          ;	
							
	    		} //			
    			   				
	    		if(row7.points != null) { //              
                 row_tLogRow_4[14]=    						    
				                String.valueOf(row7.points)			
					          ;	
							
	    		} //			
    			 

				util_tLogRow_4.addRow(row_tLogRow_4);	
				nb_line_tLogRow_4++;
//////

//////                    
                    
///////////////////////    			

 
     row8 = row7;


	tos_count_tLogRow_4++;

/**
 * [tLogRow_4 main ] stop
 */
	
	/**
	 * [tLogRow_4 process_data_begin ] start
	 */

	

	
	
	currentComponent="tLogRow_4";

	

 



/**
 * [tLogRow_4 process_data_begin ] stop
 */

	
	/**
	 * [tDBOutput_4 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_4";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row8"
						
						);
					}
					



        whetherReject_tDBOutput_4 = false;
                    if(row8.joueur1_nom == null) {
pstmt_tDBOutput_4.setNull(1, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_4.setString(1, row8.joueur1_nom);
}

                    if(row8.joueur1_prenom == null) {
pstmt_tDBOutput_4.setNull(2, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_4.setString(2, row8.joueur1_prenom);
}

                    if(row8.joueur1_nationalite == null) {
pstmt_tDBOutput_4.setNull(3, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_4.setString(3, row8.joueur1_nationalite);
}

                    if(row8.joueur2_nom == null) {
pstmt_tDBOutput_4.setNull(4, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_4.setString(4, row8.joueur2_nom);
}

                    if(row8.joueur2_prenom == null) {
pstmt_tDBOutput_4.setNull(5, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_4.setString(5, row8.joueur2_prenom);
}

                    if(row8.joueur2_nationalite == null) {
pstmt_tDBOutput_4.setNull(6, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_4.setString(6, row8.joueur2_nationalite);
}

                    if(row8.seed == null) {
pstmt_tDBOutput_4.setNull(7, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_4.setInt(7, row8.seed);
}

                    if(row8.round == null) {
pstmt_tDBOutput_4.setNull(8, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_4.setString(8, row8.round);
}

                    if(row8.score == null) {
pstmt_tDBOutput_4.setNull(9, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_4.setString(9, row8.score);
}

                    if(row8.resultat == null) {
pstmt_tDBOutput_4.setNull(10, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_4.setString(10, row8.resultat);
}

                    if(row8.date_tournoi != null) {
pstmt_tDBOutput_4.setTimestamp(11, new java.sql.Timestamp(row8.date_tournoi.getTime()));
} else {
pstmt_tDBOutput_4.setNull(11, java.sql.Types.TIMESTAMP);
}

                    if(row8.nom_tournoi == null) {
pstmt_tDBOutput_4.setNull(12, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_4.setString(12, row8.nom_tournoi);
}

                    if(row8.lieu_tournoi == null) {
pstmt_tDBOutput_4.setNull(13, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_4.setString(13, row8.lieu_tournoi);
}

                    pstmt_tDBOutput_4.setBigDecimal(14, row8.prize_money);

                    if(row8.points == null) {
pstmt_tDBOutput_4.setNull(15, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_4.setInt(15, row8.points);
}

			
    		pstmt_tDBOutput_4.addBatch();
    		nb_line_tDBOutput_4++;
    		  
    		  
    		  batchSizeCounter_tDBOutput_4++;
    		  
    			if ((batchSize_tDBOutput_4 > 0) && (batchSize_tDBOutput_4 <= batchSizeCounter_tDBOutput_4)) {
                try {
						int countSum_tDBOutput_4 = 0;
						    
						for(int countEach_tDBOutput_4: pstmt_tDBOutput_4.executeBatch()) {
							countSum_tDBOutput_4 += (countEach_tDBOutput_4 < 0 ? 0 : countEach_tDBOutput_4);
						}
				    	rowsToCommitCount_tDBOutput_4 += countSum_tDBOutput_4;
				    	
				    		insertedCount_tDBOutput_4 += countSum_tDBOutput_4;
				    	
            	    	batchSizeCounter_tDBOutput_4 = 0;
                }catch (java.sql.BatchUpdateException e_tDBOutput_4){
globalMap.put("tDBOutput_4_ERROR_MESSAGE",e_tDBOutput_4.getMessage());
				    	java.sql.SQLException ne_tDBOutput_4 = e_tDBOutput_4.getNextException(),sqle_tDBOutput_4=null;
				    	String errormessage_tDBOutput_4;
						if (ne_tDBOutput_4 != null) {
							// build new exception to provide the original cause
							sqle_tDBOutput_4 = new java.sql.SQLException(e_tDBOutput_4.getMessage() + "\ncaused by: " + ne_tDBOutput_4.getMessage(), ne_tDBOutput_4.getSQLState(), ne_tDBOutput_4.getErrorCode(), ne_tDBOutput_4);
							errormessage_tDBOutput_4 = sqle_tDBOutput_4.getMessage();
						}else{
							errormessage_tDBOutput_4 = e_tDBOutput_4.getMessage();
						}
				    	
				    	int countSum_tDBOutput_4 = 0;
						for(int countEach_tDBOutput_4: e_tDBOutput_4.getUpdateCounts()) {
							countSum_tDBOutput_4 += (countEach_tDBOutput_4 < 0 ? 0 : countEach_tDBOutput_4);
						}
						rowsToCommitCount_tDBOutput_4 += countSum_tDBOutput_4;
						
				    		insertedCount_tDBOutput_4 += countSum_tDBOutput_4;
				    	
				    	System.err.println(errormessage_tDBOutput_4);
				    	
					}
    			}
    		
    		    commitCounter_tDBOutput_4++;
                if(commitEvery_tDBOutput_4 <= commitCounter_tDBOutput_4) {
                if ((batchSize_tDBOutput_4 > 0) && (batchSizeCounter_tDBOutput_4 > 0)) {
                try {
                		int countSum_tDBOutput_4 = 0;
                		    
						for(int countEach_tDBOutput_4: pstmt_tDBOutput_4.executeBatch()) {
							countSum_tDBOutput_4 += (countEach_tDBOutput_4 < 0 ? 0 : countEach_tDBOutput_4);
						}
            	    	rowsToCommitCount_tDBOutput_4 += countSum_tDBOutput_4;
            	    	
            	    		insertedCount_tDBOutput_4 += countSum_tDBOutput_4;
            	    	
                batchSizeCounter_tDBOutput_4 = 0;
               }catch (java.sql.BatchUpdateException e_tDBOutput_4){
globalMap.put("tDBOutput_4_ERROR_MESSAGE",e_tDBOutput_4.getMessage());
			    	java.sql.SQLException ne_tDBOutput_4 = e_tDBOutput_4.getNextException(),sqle_tDBOutput_4=null;
			    	String errormessage_tDBOutput_4;
					if (ne_tDBOutput_4 != null) {
						// build new exception to provide the original cause
						sqle_tDBOutput_4 = new java.sql.SQLException(e_tDBOutput_4.getMessage() + "\ncaused by: " + ne_tDBOutput_4.getMessage(), ne_tDBOutput_4.getSQLState(), ne_tDBOutput_4.getErrorCode(), ne_tDBOutput_4);
						errormessage_tDBOutput_4 = sqle_tDBOutput_4.getMessage();
					}else{
						errormessage_tDBOutput_4 = e_tDBOutput_4.getMessage();
					}
			    	
			    	int countSum_tDBOutput_4 = 0;
					for(int countEach_tDBOutput_4: e_tDBOutput_4.getUpdateCounts()) {
						countSum_tDBOutput_4 += (countEach_tDBOutput_4 < 0 ? 0 : countEach_tDBOutput_4);
					}
					rowsToCommitCount_tDBOutput_4 += countSum_tDBOutput_4;
					
			    		insertedCount_tDBOutput_4 += countSum_tDBOutput_4;
			    	
			    	System.err.println(errormessage_tDBOutput_4);
			    	
				}
            }
                    if(rowsToCommitCount_tDBOutput_4 != 0){
                    	
                    }
                    conn_tDBOutput_4.commit();
                    if(rowsToCommitCount_tDBOutput_4 != 0){
                    	
                    	rowsToCommitCount_tDBOutput_4 = 0;
                    }
                    commitCounter_tDBOutput_4=0;
                }

 


	tos_count_tDBOutput_4++;

/**
 * [tDBOutput_4 main ] stop
 */
	
	/**
	 * [tDBOutput_4 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBOutput_4";

	

 



/**
 * [tDBOutput_4 process_data_begin ] stop
 */
	
	/**
	 * [tDBOutput_4 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBOutput_4";

	

 



/**
 * [tDBOutput_4 process_data_end ] stop
 */



	
	/**
	 * [tLogRow_4 process_data_end ] start
	 */

	

	
	
	currentComponent="tLogRow_4";

	

 



/**
 * [tLogRow_4 process_data_end ] stop
 */

} // End of branch "row7"




	
	/**
	 * [tFileInputDelimited_4 process_data_end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_4";

	

 



/**
 * [tFileInputDelimited_4 process_data_end ] stop
 */
	
	/**
	 * [tFileInputDelimited_4 end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_4";

	



            }
            }finally{
                if(!((Object)("C:/Users/ASUS/Downloads/Sports/Sports/script_tournois/dec.csv") instanceof java.io.InputStream)){
                	if(fid_tFileInputDelimited_4!=null){
                		fid_tFileInputDelimited_4.close();
                	}
                }
                if(fid_tFileInputDelimited_4!=null){
                	globalMap.put("tFileInputDelimited_4_NB_LINE", fid_tFileInputDelimited_4.getRowNumber());
					
                }
			}
			  

 

ok_Hash.put("tFileInputDelimited_4", true);
end_Hash.put("tFileInputDelimited_4", System.currentTimeMillis());




/**
 * [tFileInputDelimited_4 end ] stop
 */

	
	/**
	 * [tLogRow_4 end ] start
	 */

	

	
	
	currentComponent="tLogRow_4";

	


//////

                    
                    java.io.PrintStream consoleOut_tLogRow_4 = null;
                    if (globalMap.get("tLogRow_CONSOLE")!=null)
                    {
                    	consoleOut_tLogRow_4 = (java.io.PrintStream) globalMap.get("tLogRow_CONSOLE");
                    }
                    else
                    {
                    	consoleOut_tLogRow_4 = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));
                    	globalMap.put("tLogRow_CONSOLE",consoleOut_tLogRow_4);
                    }
                    
                    consoleOut_tLogRow_4.println(util_tLogRow_4.format().toString());
                    consoleOut_tLogRow_4.flush();
//////
globalMap.put("tLogRow_4_NB_LINE",nb_line_tLogRow_4);

///////////////////////    			

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row7");
			  	}
			  	
 

ok_Hash.put("tLogRow_4", true);
end_Hash.put("tLogRow_4", System.currentTimeMillis());




/**
 * [tLogRow_4 end ] stop
 */

	
	/**
	 * [tDBOutput_4 end ] start
	 */

	

	
	
	currentComponent="tDBOutput_4";

	



	    try {
				int countSum_tDBOutput_4 = 0;
				if (pstmt_tDBOutput_4 != null && batchSizeCounter_tDBOutput_4 > 0) {
						
					for(int countEach_tDBOutput_4: pstmt_tDBOutput_4.executeBatch()) {
						countSum_tDBOutput_4 += (countEach_tDBOutput_4 < 0 ? 0 : countEach_tDBOutput_4);
					}
					rowsToCommitCount_tDBOutput_4 += countSum_tDBOutput_4;
						
				}
		    	
		    		insertedCount_tDBOutput_4 += countSum_tDBOutput_4;
		    	
	    }catch (java.sql.BatchUpdateException e_tDBOutput_4){
globalMap.put("tDBOutput_4_ERROR_MESSAGE",e_tDBOutput_4.getMessage());
	    	java.sql.SQLException ne_tDBOutput_4 = e_tDBOutput_4.getNextException(),sqle_tDBOutput_4=null;
	    	String errormessage_tDBOutput_4;
			if (ne_tDBOutput_4 != null) {
				// build new exception to provide the original cause
				sqle_tDBOutput_4 = new java.sql.SQLException(e_tDBOutput_4.getMessage() + "\ncaused by: " + ne_tDBOutput_4.getMessage(), ne_tDBOutput_4.getSQLState(), ne_tDBOutput_4.getErrorCode(), ne_tDBOutput_4);
				errormessage_tDBOutput_4 = sqle_tDBOutput_4.getMessage();
			}else{
				errormessage_tDBOutput_4 = e_tDBOutput_4.getMessage();
			}
	    	
	    	int countSum_tDBOutput_4 = 0;
			for(int countEach_tDBOutput_4: e_tDBOutput_4.getUpdateCounts()) {
				countSum_tDBOutput_4 += (countEach_tDBOutput_4 < 0 ? 0 : countEach_tDBOutput_4);
			}
			rowsToCommitCount_tDBOutput_4 += countSum_tDBOutput_4;
			
	    		insertedCount_tDBOutput_4 += countSum_tDBOutput_4;
	    	
	    	System.err.println(errormessage_tDBOutput_4);
	    	
		}
	    
        if(pstmt_tDBOutput_4 != null) {
        		
            pstmt_tDBOutput_4.close();
            resourceMap.remove("pstmt_tDBOutput_4");
        }
    resourceMap.put("statementClosed_tDBOutput_4", true);
			if(rowsToCommitCount_tDBOutput_4 != 0){
				
			}
			conn_tDBOutput_4.commit();
			if(rowsToCommitCount_tDBOutput_4 != 0){
				
				rowsToCommitCount_tDBOutput_4 = 0;
			}
			commitCounter_tDBOutput_4 = 0;
		
    	conn_tDBOutput_4 .close();
    	
    	resourceMap.put("finish_tDBOutput_4", true);
    	

	nb_line_deleted_tDBOutput_4=nb_line_deleted_tDBOutput_4+ deletedCount_tDBOutput_4;
	nb_line_update_tDBOutput_4=nb_line_update_tDBOutput_4 + updatedCount_tDBOutput_4;
	nb_line_inserted_tDBOutput_4=nb_line_inserted_tDBOutput_4 + insertedCount_tDBOutput_4;
	nb_line_rejected_tDBOutput_4=nb_line_rejected_tDBOutput_4 + rejectedCount_tDBOutput_4;
	
        globalMap.put("tDBOutput_4_NB_LINE",nb_line_tDBOutput_4);
        globalMap.put("tDBOutput_4_NB_LINE_UPDATED",nb_line_update_tDBOutput_4);
        globalMap.put("tDBOutput_4_NB_LINE_INSERTED",nb_line_inserted_tDBOutput_4);
        globalMap.put("tDBOutput_4_NB_LINE_DELETED",nb_line_deleted_tDBOutput_4);
        globalMap.put("tDBOutput_4_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_4);
    

	


				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row8");
			  	}
			  	
 

ok_Hash.put("tDBOutput_4", true);
end_Hash.put("tDBOutput_4", System.currentTimeMillis());




/**
 * [tDBOutput_4 end ] stop
 */






				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tFileInputDelimited_4 finally ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_4";

	

 



/**
 * [tFileInputDelimited_4 finally ] stop
 */

	
	/**
	 * [tLogRow_4 finally ] start
	 */

	

	
	
	currentComponent="tLogRow_4";

	

 



/**
 * [tLogRow_4 finally ] stop
 */

	
	/**
	 * [tDBOutput_4 finally ] start
	 */

	

	
	
	currentComponent="tDBOutput_4";

	



    try {
    if (resourceMap.get("statementClosed_tDBOutput_4") == null) {
                java.sql.PreparedStatement pstmtToClose_tDBOutput_4 = null;
                if ((pstmtToClose_tDBOutput_4 = (java.sql.PreparedStatement) resourceMap.remove("pstmt_tDBOutput_4")) != null) {
                    pstmtToClose_tDBOutput_4.close();
                }
    }
    } finally {
        if(resourceMap.get("finish_tDBOutput_4") == null){
            java.sql.Connection ctn_tDBOutput_4 = null;
            if((ctn_tDBOutput_4 = (java.sql.Connection)resourceMap.get("conn_tDBOutput_4")) != null){
                try {
                    ctn_tDBOutput_4.close();
                } catch (java.sql.SQLException sqlEx_tDBOutput_4) {
                    String errorMessage_tDBOutput_4 = "failed to close the connection in tDBOutput_4 :" + sqlEx_tDBOutput_4.getMessage();
                    System.err.println(errorMessage_tDBOutput_4);
                }
            }
        }
    }
 



/**
 * [tDBOutput_4 finally ] stop
 */






				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tFileInputDelimited_4_SUBPROCESS_STATE", 1);
	}
	


public static class row10Struct implements routines.system.IPersistableRow<row10Struct> {
    final static byte[] commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[0];
    static byte[] commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[0];

	
			    public String joueur1_nom;

				public String getJoueur1_nom () {
					return this.joueur1_nom;
				}
				
			    public String joueur1_prenom;

				public String getJoueur1_prenom () {
					return this.joueur1_prenom;
				}
				
			    public String joueur1_nationalite;

				public String getJoueur1_nationalite () {
					return this.joueur1_nationalite;
				}
				
			    public String joueur2_nom;

				public String getJoueur2_nom () {
					return this.joueur2_nom;
				}
				
			    public String joueur2_prenom;

				public String getJoueur2_prenom () {
					return this.joueur2_prenom;
				}
				
			    public String joueur2_nationalite;

				public String getJoueur2_nationalite () {
					return this.joueur2_nationalite;
				}
				
			    public Integer seed;

				public Integer getSeed () {
					return this.seed;
				}
				
			    public String round;

				public String getRound () {
					return this.round;
				}
				
			    public String score;

				public String getScore () {
					return this.score;
				}
				
			    public String resultat;

				public String getResultat () {
					return this.resultat;
				}
				
			    public java.util.Date date_tournoi;

				public java.util.Date getDate_tournoi () {
					return this.date_tournoi;
				}
				
			    public String nom_tournoi;

				public String getNom_tournoi () {
					return this.nom_tournoi;
				}
				
			    public String lieu_tournoi;

				public String getLieu_tournoi () {
					return this.lieu_tournoi;
				}
				
			    public BigDecimal prize_money;

				public BigDecimal getPrize_money () {
					return this.prize_money;
				}
				
			    public Integer points;

				public Integer getPoints () {
					return this.points;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length) {
				if(length < 1024 && commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length == 0) {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[1024];
				} else {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length);
			strReturn = new String(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length) {
				if(length < 1024 && commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length == 0) {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[1024];
				} else {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length);
			strReturn = new String(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep) {

        	try {

        		int length = 0;
		
					this.joueur1_nom = readString(dis);
					
					this.joueur1_prenom = readString(dis);
					
					this.joueur1_nationalite = readString(dis);
					
					this.joueur2_nom = readString(dis);
					
					this.joueur2_prenom = readString(dis);
					
					this.joueur2_nationalite = readString(dis);
					
						this.seed = readInteger(dis);
					
					this.round = readString(dis);
					
					this.score = readString(dis);
					
					this.resultat = readString(dis);
					
					this.date_tournoi = readDate(dis);
					
					this.nom_tournoi = readString(dis);
					
					this.lieu_tournoi = readString(dis);
					
						this.prize_money = (BigDecimal) dis.readObject();
					
						this.points = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep) {

        	try {

        		int length = 0;
		
					this.joueur1_nom = readString(dis);
					
					this.joueur1_prenom = readString(dis);
					
					this.joueur1_nationalite = readString(dis);
					
					this.joueur2_nom = readString(dis);
					
					this.joueur2_prenom = readString(dis);
					
					this.joueur2_nationalite = readString(dis);
					
						this.seed = readInteger(dis);
					
					this.round = readString(dis);
					
					this.score = readString(dis);
					
					this.resultat = readString(dis);
					
					this.date_tournoi = readDate(dis);
					
					this.nom_tournoi = readString(dis);
					
					this.lieu_tournoi = readString(dis);
					
						this.prize_money = (BigDecimal) dis.readObject();
					
						this.points = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.joueur1_nom,dos);
					
					// String
				
						writeString(this.joueur1_prenom,dos);
					
					// String
				
						writeString(this.joueur1_nationalite,dos);
					
					// String
				
						writeString(this.joueur2_nom,dos);
					
					// String
				
						writeString(this.joueur2_prenom,dos);
					
					// String
				
						writeString(this.joueur2_nationalite,dos);
					
					// Integer
				
						writeInteger(this.seed,dos);
					
					// String
				
						writeString(this.round,dos);
					
					// String
				
						writeString(this.score,dos);
					
					// String
				
						writeString(this.resultat,dos);
					
					// java.util.Date
				
						writeDate(this.date_tournoi,dos);
					
					// String
				
						writeString(this.nom_tournoi,dos);
					
					// String
				
						writeString(this.lieu_tournoi,dos);
					
					// BigDecimal
				
       			    	dos.writeObject(this.prize_money);
					
					// Integer
				
						writeInteger(this.points,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.joueur1_nom,dos);
					
					// String
				
						writeString(this.joueur1_prenom,dos);
					
					// String
				
						writeString(this.joueur1_nationalite,dos);
					
					// String
				
						writeString(this.joueur2_nom,dos);
					
					// String
				
						writeString(this.joueur2_prenom,dos);
					
					// String
				
						writeString(this.joueur2_nationalite,dos);
					
					// Integer
				
						writeInteger(this.seed,dos);
					
					// String
				
						writeString(this.round,dos);
					
					// String
				
						writeString(this.score,dos);
					
					// String
				
						writeString(this.resultat,dos);
					
					// java.util.Date
				
						writeDate(this.date_tournoi,dos);
					
					// String
				
						writeString(this.nom_tournoi,dos);
					
					// String
				
						writeString(this.lieu_tournoi,dos);
					
					// BigDecimal
				
       			    	dos.writeObject(this.prize_money);
					
					// Integer
				
						writeInteger(this.points,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("joueur1_nom="+joueur1_nom);
		sb.append(",joueur1_prenom="+joueur1_prenom);
		sb.append(",joueur1_nationalite="+joueur1_nationalite);
		sb.append(",joueur2_nom="+joueur2_nom);
		sb.append(",joueur2_prenom="+joueur2_prenom);
		sb.append(",joueur2_nationalite="+joueur2_nationalite);
		sb.append(",seed="+String.valueOf(seed));
		sb.append(",round="+round);
		sb.append(",score="+score);
		sb.append(",resultat="+resultat);
		sb.append(",date_tournoi="+String.valueOf(date_tournoi));
		sb.append(",nom_tournoi="+nom_tournoi);
		sb.append(",lieu_tournoi="+lieu_tournoi);
		sb.append(",prize_money="+String.valueOf(prize_money));
		sb.append(",points="+String.valueOf(points));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row10Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class row9Struct implements routines.system.IPersistableRow<row9Struct> {
    final static byte[] commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[0];
    static byte[] commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[0];

	
			    public String joueur1_nom;

				public String getJoueur1_nom () {
					return this.joueur1_nom;
				}
				
			    public String joueur1_prenom;

				public String getJoueur1_prenom () {
					return this.joueur1_prenom;
				}
				
			    public String joueur1_nationalite;

				public String getJoueur1_nationalite () {
					return this.joueur1_nationalite;
				}
				
			    public String joueur2_nom;

				public String getJoueur2_nom () {
					return this.joueur2_nom;
				}
				
			    public String joueur2_prenom;

				public String getJoueur2_prenom () {
					return this.joueur2_prenom;
				}
				
			    public String joueur2_nationalite;

				public String getJoueur2_nationalite () {
					return this.joueur2_nationalite;
				}
				
			    public Integer seed;

				public Integer getSeed () {
					return this.seed;
				}
				
			    public String round;

				public String getRound () {
					return this.round;
				}
				
			    public String score;

				public String getScore () {
					return this.score;
				}
				
			    public String resultat;

				public String getResultat () {
					return this.resultat;
				}
				
			    public java.util.Date date_tournoi;

				public java.util.Date getDate_tournoi () {
					return this.date_tournoi;
				}
				
			    public String nom_tournoi;

				public String getNom_tournoi () {
					return this.nom_tournoi;
				}
				
			    public String lieu_tournoi;

				public String getLieu_tournoi () {
					return this.lieu_tournoi;
				}
				
			    public BigDecimal prize_money;

				public BigDecimal getPrize_money () {
					return this.prize_money;
				}
				
			    public Integer points;

				public Integer getPoints () {
					return this.points;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length) {
				if(length < 1024 && commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length == 0) {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[1024];
				} else {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length);
			strReturn = new String(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length) {
				if(length < 1024 && commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length == 0) {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[1024];
				} else {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length);
			strReturn = new String(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep) {

        	try {

        		int length = 0;
		
					this.joueur1_nom = readString(dis);
					
					this.joueur1_prenom = readString(dis);
					
					this.joueur1_nationalite = readString(dis);
					
					this.joueur2_nom = readString(dis);
					
					this.joueur2_prenom = readString(dis);
					
					this.joueur2_nationalite = readString(dis);
					
						this.seed = readInteger(dis);
					
					this.round = readString(dis);
					
					this.score = readString(dis);
					
					this.resultat = readString(dis);
					
					this.date_tournoi = readDate(dis);
					
					this.nom_tournoi = readString(dis);
					
					this.lieu_tournoi = readString(dis);
					
						this.prize_money = (BigDecimal) dis.readObject();
					
						this.points = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep) {

        	try {

        		int length = 0;
		
					this.joueur1_nom = readString(dis);
					
					this.joueur1_prenom = readString(dis);
					
					this.joueur1_nationalite = readString(dis);
					
					this.joueur2_nom = readString(dis);
					
					this.joueur2_prenom = readString(dis);
					
					this.joueur2_nationalite = readString(dis);
					
						this.seed = readInteger(dis);
					
					this.round = readString(dis);
					
					this.score = readString(dis);
					
					this.resultat = readString(dis);
					
					this.date_tournoi = readDate(dis);
					
					this.nom_tournoi = readString(dis);
					
					this.lieu_tournoi = readString(dis);
					
						this.prize_money = (BigDecimal) dis.readObject();
					
						this.points = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.joueur1_nom,dos);
					
					// String
				
						writeString(this.joueur1_prenom,dos);
					
					// String
				
						writeString(this.joueur1_nationalite,dos);
					
					// String
				
						writeString(this.joueur2_nom,dos);
					
					// String
				
						writeString(this.joueur2_prenom,dos);
					
					// String
				
						writeString(this.joueur2_nationalite,dos);
					
					// Integer
				
						writeInteger(this.seed,dos);
					
					// String
				
						writeString(this.round,dos);
					
					// String
				
						writeString(this.score,dos);
					
					// String
				
						writeString(this.resultat,dos);
					
					// java.util.Date
				
						writeDate(this.date_tournoi,dos);
					
					// String
				
						writeString(this.nom_tournoi,dos);
					
					// String
				
						writeString(this.lieu_tournoi,dos);
					
					// BigDecimal
				
       			    	dos.writeObject(this.prize_money);
					
					// Integer
				
						writeInteger(this.points,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.joueur1_nom,dos);
					
					// String
				
						writeString(this.joueur1_prenom,dos);
					
					// String
				
						writeString(this.joueur1_nationalite,dos);
					
					// String
				
						writeString(this.joueur2_nom,dos);
					
					// String
				
						writeString(this.joueur2_prenom,dos);
					
					// String
				
						writeString(this.joueur2_nationalite,dos);
					
					// Integer
				
						writeInteger(this.seed,dos);
					
					// String
				
						writeString(this.round,dos);
					
					// String
				
						writeString(this.score,dos);
					
					// String
				
						writeString(this.resultat,dos);
					
					// java.util.Date
				
						writeDate(this.date_tournoi,dos);
					
					// String
				
						writeString(this.nom_tournoi,dos);
					
					// String
				
						writeString(this.lieu_tournoi,dos);
					
					// BigDecimal
				
       			    	dos.writeObject(this.prize_money);
					
					// Integer
				
						writeInteger(this.points,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("joueur1_nom="+joueur1_nom);
		sb.append(",joueur1_prenom="+joueur1_prenom);
		sb.append(",joueur1_nationalite="+joueur1_nationalite);
		sb.append(",joueur2_nom="+joueur2_nom);
		sb.append(",joueur2_prenom="+joueur2_prenom);
		sb.append(",joueur2_nationalite="+joueur2_nationalite);
		sb.append(",seed="+String.valueOf(seed));
		sb.append(",round="+round);
		sb.append(",score="+score);
		sb.append(",resultat="+resultat);
		sb.append(",date_tournoi="+String.valueOf(date_tournoi));
		sb.append(",nom_tournoi="+nom_tournoi);
		sb.append(",lieu_tournoi="+lieu_tournoi);
		sb.append(",prize_money="+String.valueOf(prize_money));
		sb.append(",points="+String.valueOf(points));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row9Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tFileInputDelimited_5Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tFileInputDelimited_5_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row9Struct row9 = new row9Struct();
row9Struct row10 = row9;





	
	/**
	 * [tDBOutput_5 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBOutput_5", false);
		start_Hash.put("tDBOutput_5", System.currentTimeMillis());
		
	
	currentComponent="tDBOutput_5";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row10");
					}
				
		int tos_count_tDBOutput_5 = 0;
		





String dbschema_tDBOutput_5 = null;
	dbschema_tDBOutput_5 = "sa";
	

String tableName_tDBOutput_5 = null;
if(dbschema_tDBOutput_5 == null || dbschema_tDBOutput_5.trim().length() == 0) {
	tableName_tDBOutput_5 = ("sa_tournament_aug");
} else {
	tableName_tDBOutput_5 = dbschema_tDBOutput_5 + "\".\"" + ("sa_tournament_aug");
}


int nb_line_tDBOutput_5 = 0;
int nb_line_update_tDBOutput_5 = 0;
int nb_line_inserted_tDBOutput_5 = 0;
int nb_line_deleted_tDBOutput_5 = 0;
int nb_line_rejected_tDBOutput_5 = 0;

int deletedCount_tDBOutput_5=0;
int updatedCount_tDBOutput_5=0;
int insertedCount_tDBOutput_5=0;
int rowsToCommitCount_tDBOutput_5=0;
int rejectedCount_tDBOutput_5=0;

boolean whetherReject_tDBOutput_5 = false;

java.sql.Connection conn_tDBOutput_5 = null;
String dbUser_tDBOutput_5 = null;

	
    java.lang.Class.forName("org.postgresql.Driver");
    
        String url_tDBOutput_5 = "jdbc:postgresql://"+"localhost"+":"+"5432"+"/"+"padel_bi_SA";
    dbUser_tDBOutput_5 = "postgres";
 
	final String decryptedPassword_tDBOutput_5 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:Fbc/Qc2w1qZK8RwZKyJKvAc8GEaA5rfzEL+kOIeAcmpm9KtiDA==");

    String dbPwd_tDBOutput_5 = decryptedPassword_tDBOutput_5;

    conn_tDBOutput_5 = java.sql.DriverManager.getConnection(url_tDBOutput_5,dbUser_tDBOutput_5,dbPwd_tDBOutput_5);
	
	resourceMap.put("conn_tDBOutput_5", conn_tDBOutput_5);
        conn_tDBOutput_5.setAutoCommit(false);
        int commitEvery_tDBOutput_5 = 10000;
        int commitCounter_tDBOutput_5 = 0;


   int batchSize_tDBOutput_5 = 10000;
   int batchSizeCounter_tDBOutput_5=0;

int count_tDBOutput_5=0;
	    String insert_tDBOutput_5 = "INSERT INTO \"" + tableName_tDBOutput_5 + "\" (\"joueur1_nom\",\"joueur1_prenom\",\"joueur1_nationalite\",\"joueur2_nom\",\"joueur2_prenom\",\"joueur2_nationalite\",\"seed\",\"round\",\"score\",\"resultat\",\"date_tournoi\",\"nom_tournoi\",\"lieu_tournoi\",\"prize_money\",\"points\") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	    
	    java.sql.PreparedStatement pstmt_tDBOutput_5 = conn_tDBOutput_5.prepareStatement(insert_tDBOutput_5);
	    resourceMap.put("pstmt_tDBOutput_5", pstmt_tDBOutput_5);
	    

 



/**
 * [tDBOutput_5 begin ] stop
 */



	
	/**
	 * [tLogRow_5 begin ] start
	 */

	

	
		
		ok_Hash.put("tLogRow_5", false);
		start_Hash.put("tLogRow_5", System.currentTimeMillis());
		
	
	currentComponent="tLogRow_5";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row9");
					}
				
		int tos_count_tLogRow_5 = 0;
		

	///////////////////////
	
         class Util_tLogRow_5 {

        String[] des_top = { ".", ".", "-", "+" };

        String[] des_head = { "|=", "=|", "-", "+" };

        String[] des_bottom = { "'", "'", "-", "+" };

        String name="";

        java.util.List<String[]> list = new java.util.ArrayList<String[]>();

        int[] colLengths = new int[15];

        public void addRow(String[] row) {

            for (int i = 0; i < 15; i++) {
                if (row[i]!=null) {
                  colLengths[i] = Math.max(colLengths[i], row[i].length());
                }
            }
            list.add(row);
        }

        public void setTableName(String name) {

            this.name = name;
        }

            public StringBuilder format() {
            
                StringBuilder sb = new StringBuilder();
  
            
                    sb.append(print(des_top));
    
                    int totals = 0;
                    for (int i = 0; i < colLengths.length; i++) {
                        totals = totals + colLengths[i];
                    }
    
                    // name
                    sb.append("|");
                    int k = 0;
                    for (k = 0; k < (totals + 14 - name.length()) / 2; k++) {
                        sb.append(' ');
                    }
                    sb.append(name);
                    for (int i = 0; i < totals + 14 - name.length() - k; i++) {
                        sb.append(' ');
                    }
                    sb.append("|\n");

                    // head and rows
                    sb.append(print(des_head));
                    for (int i = 0; i < list.size(); i++) {
    
                        String[] row = list.get(i);
    
                        java.util.Formatter formatter = new java.util.Formatter(new StringBuilder());
                        
                        StringBuilder sbformat = new StringBuilder();                                             
        			        sbformat.append("|%1$-");
        			        sbformat.append(colLengths[0]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%2$-");
        			        sbformat.append(colLengths[1]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%3$-");
        			        sbformat.append(colLengths[2]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%4$-");
        			        sbformat.append(colLengths[3]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%5$-");
        			        sbformat.append(colLengths[4]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%6$-");
        			        sbformat.append(colLengths[5]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%7$-");
        			        sbformat.append(colLengths[6]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%8$-");
        			        sbformat.append(colLengths[7]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%9$-");
        			        sbformat.append(colLengths[8]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%10$-");
        			        sbformat.append(colLengths[9]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%11$-");
        			        sbformat.append(colLengths[10]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%12$-");
        			        sbformat.append(colLengths[11]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%13$-");
        			        sbformat.append(colLengths[12]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%14$-");
        			        sbformat.append(colLengths[13]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%15$-");
        			        sbformat.append(colLengths[14]);
        			        sbformat.append("s");
        			                      
                        sbformat.append("|\n");                    
       
                        formatter.format(sbformat.toString(), (Object[])row);	
                                
                        sb.append(formatter.toString());
                        if (i == 0)
                            sb.append(print(des_head)); // print the head
                    }
    
                    // end
                    sb.append(print(des_bottom));
                    return sb;
                }
            

            private StringBuilder print(String[] fillChars) {
                StringBuilder sb = new StringBuilder();
                //first column
                sb.append(fillChars[0]);                
                    for (int i = 0; i < colLengths[0] - fillChars[0].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);	                

                    for (int i = 0; i < colLengths[1] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[2] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[3] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[4] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[5] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[6] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[7] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[8] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[9] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[10] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[11] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[12] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[13] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                
                    //last column
                    for (int i = 0; i < colLengths[14] - fillChars[1].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }         
                sb.append(fillChars[1]);
                sb.append("\n");               
                return sb;
            }
            
            public boolean isTableEmpty(){
            	if (list.size() > 1)
            		return false;
            	return true;
            }
        }
        Util_tLogRow_5 util_tLogRow_5 = new Util_tLogRow_5();
        util_tLogRow_5.setTableName("tLogRow_5");
        util_tLogRow_5.addRow(new String[]{"joueur1_nom","joueur1_prenom","joueur1_nationalite","joueur2_nom","joueur2_prenom","joueur2_nationalite","seed","round","score","resultat","date_tournoi","nom_tournoi","lieu_tournoi","prize_money","points",});        
 		StringBuilder strBuffer_tLogRow_5 = null;
		int nb_line_tLogRow_5 = 0;
///////////////////////    			



 



/**
 * [tLogRow_5 begin ] stop
 */



	
	/**
	 * [tFileInputDelimited_5 begin ] start
	 */

	

	
		
		ok_Hash.put("tFileInputDelimited_5", false);
		start_Hash.put("tFileInputDelimited_5", System.currentTimeMillis());
		
	
	currentComponent="tFileInputDelimited_5";

	
		int tos_count_tFileInputDelimited_5 = 0;
		
	
	
	
 
	
	
	final routines.system.RowState rowstate_tFileInputDelimited_5 = new routines.system.RowState();
	
	
				int nb_line_tFileInputDelimited_5 = 0;
				org.talend.fileprocess.FileInputDelimited fid_tFileInputDelimited_5 = null;
				int limit_tFileInputDelimited_5 = -1;
				try{
					
						Object filename_tFileInputDelimited_5 = "C:/Users/ASUS/Downloads/Sports/Sports/script_tournois/aug.csv";
						if(filename_tFileInputDelimited_5 instanceof java.io.InputStream){
							
			int footer_value_tFileInputDelimited_5 = 0, random_value_tFileInputDelimited_5 = -1;
			if(footer_value_tFileInputDelimited_5 >0 || random_value_tFileInputDelimited_5 > 0){
				throw new java.lang.Exception("When the input source is a stream,footer and random shouldn't be bigger than 0.");				
			}
		
						}
						try {
							fid_tFileInputDelimited_5 = new org.talend.fileprocess.FileInputDelimited("C:/Users/ASUS/Downloads/Sports/Sports/script_tournois/aug.csv", "ISO-8859-15",";","\n",true,1,0,
									limit_tFileInputDelimited_5
								,-1, false);
						} catch(java.lang.Exception e) {
globalMap.put("tFileInputDelimited_5_ERROR_MESSAGE",e.getMessage());
							
								
								System.err.println(e.getMessage());
							
						}
					
				    
					while (fid_tFileInputDelimited_5!=null && fid_tFileInputDelimited_5.nextRecord()) {
						rowstate_tFileInputDelimited_5.reset();
						
			    						row9 = null;			
												
									boolean whetherReject_tFileInputDelimited_5 = false;
									row9 = new row9Struct();
									try {
										
				int columnIndexWithD_tFileInputDelimited_5 = 0;
				
					String temp = ""; 
				
					columnIndexWithD_tFileInputDelimited_5 = 0;
					
							row9.joueur1_nom = fid_tFileInputDelimited_5.get(columnIndexWithD_tFileInputDelimited_5);
						
				
					columnIndexWithD_tFileInputDelimited_5 = 1;
					
							row9.joueur1_prenom = fid_tFileInputDelimited_5.get(columnIndexWithD_tFileInputDelimited_5);
						
				
					columnIndexWithD_tFileInputDelimited_5 = 2;
					
							row9.joueur1_nationalite = fid_tFileInputDelimited_5.get(columnIndexWithD_tFileInputDelimited_5);
						
				
					columnIndexWithD_tFileInputDelimited_5 = 3;
					
							row9.joueur2_nom = fid_tFileInputDelimited_5.get(columnIndexWithD_tFileInputDelimited_5);
						
				
					columnIndexWithD_tFileInputDelimited_5 = 4;
					
							row9.joueur2_prenom = fid_tFileInputDelimited_5.get(columnIndexWithD_tFileInputDelimited_5);
						
				
					columnIndexWithD_tFileInputDelimited_5 = 5;
					
							row9.joueur2_nationalite = fid_tFileInputDelimited_5.get(columnIndexWithD_tFileInputDelimited_5);
						
				
					columnIndexWithD_tFileInputDelimited_5 = 6;
					
						temp = fid_tFileInputDelimited_5.get(columnIndexWithD_tFileInputDelimited_5);
						if(temp.length() > 0) {
							
								try {
								
    								row9.seed = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_5) {
globalMap.put("tFileInputDelimited_5_ERROR_MESSAGE",ex_tFileInputDelimited_5.getMessage());
									rowstate_tFileInputDelimited_5.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"seed", "row9", temp, ex_tFileInputDelimited_5), ex_tFileInputDelimited_5));
								}
    							
						} else {						
							
								
									row9.seed = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_5 = 7;
					
							row9.round = fid_tFileInputDelimited_5.get(columnIndexWithD_tFileInputDelimited_5);
						
				
					columnIndexWithD_tFileInputDelimited_5 = 8;
					
							row9.score = fid_tFileInputDelimited_5.get(columnIndexWithD_tFileInputDelimited_5);
						
				
					columnIndexWithD_tFileInputDelimited_5 = 9;
					
							row9.resultat = fid_tFileInputDelimited_5.get(columnIndexWithD_tFileInputDelimited_5);
						
				
					columnIndexWithD_tFileInputDelimited_5 = 10;
					
						temp = fid_tFileInputDelimited_5.get(columnIndexWithD_tFileInputDelimited_5);
						if(temp.length() > 0) {
							
								try {
								
    									row9.date_tournoi = ParserUtils.parseTo_Date(temp, "yyyy-MM-dd");
    								
    							} catch(java.lang.Exception ex_tFileInputDelimited_5) {
globalMap.put("tFileInputDelimited_5_ERROR_MESSAGE",ex_tFileInputDelimited_5.getMessage());
									rowstate_tFileInputDelimited_5.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"date_tournoi", "row9", temp, ex_tFileInputDelimited_5), ex_tFileInputDelimited_5));
								}
    							
						} else {						
							
								
									row9.date_tournoi = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_5 = 11;
					
							row9.nom_tournoi = fid_tFileInputDelimited_5.get(columnIndexWithD_tFileInputDelimited_5);
						
				
					columnIndexWithD_tFileInputDelimited_5 = 12;
					
							row9.lieu_tournoi = fid_tFileInputDelimited_5.get(columnIndexWithD_tFileInputDelimited_5);
						
				
					columnIndexWithD_tFileInputDelimited_5 = 13;
					
						temp = fid_tFileInputDelimited_5.get(columnIndexWithD_tFileInputDelimited_5);
						if(temp.length() > 0) {
							
								try {
								
    								row9.prize_money = ParserUtils.parseTo_BigDecimal(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_5) {
globalMap.put("tFileInputDelimited_5_ERROR_MESSAGE",ex_tFileInputDelimited_5.getMessage());
									rowstate_tFileInputDelimited_5.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"prize_money", "row9", temp, ex_tFileInputDelimited_5), ex_tFileInputDelimited_5));
								}
    							
						} else {						
							
								
									row9.prize_money = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_5 = 14;
					
						temp = fid_tFileInputDelimited_5.get(columnIndexWithD_tFileInputDelimited_5);
						if(temp.length() > 0) {
							
								try {
								
    								row9.points = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_5) {
globalMap.put("tFileInputDelimited_5_ERROR_MESSAGE",ex_tFileInputDelimited_5.getMessage());
									rowstate_tFileInputDelimited_5.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"points", "row9", temp, ex_tFileInputDelimited_5), ex_tFileInputDelimited_5));
								}
    							
						} else {						
							
								
									row9.points = null;
								
							
						}
					
				
				
										
										if(rowstate_tFileInputDelimited_5.getException()!=null) {
											throw rowstate_tFileInputDelimited_5.getException();
										}
										
										
							
			    					} catch (java.lang.Exception e) {
globalMap.put("tFileInputDelimited_5_ERROR_MESSAGE",e.getMessage());
			        					whetherReject_tFileInputDelimited_5 = true;
			        					
			                					System.err.println(e.getMessage());
			                					row9 = null;
			                				
										
			    					}
								

 



/**
 * [tFileInputDelimited_5 begin ] stop
 */
	
	/**
	 * [tFileInputDelimited_5 main ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_5";

	

 


	tos_count_tFileInputDelimited_5++;

/**
 * [tFileInputDelimited_5 main ] stop
 */
	
	/**
	 * [tFileInputDelimited_5 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_5";

	

 



/**
 * [tFileInputDelimited_5 process_data_begin ] stop
 */
// Start of branch "row9"
if(row9 != null) { 



	
	/**
	 * [tLogRow_5 main ] start
	 */

	

	
	
	currentComponent="tLogRow_5";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row9"
						
						);
					}
					
///////////////////////		
						

				
				String[] row_tLogRow_5 = new String[15];
   				
	    		if(row9.joueur1_nom != null) { //              
                 row_tLogRow_5[0]=    						    
				                String.valueOf(row9.joueur1_nom)			
					          ;	
							
	    		} //			
    			   				
	    		if(row9.joueur1_prenom != null) { //              
                 row_tLogRow_5[1]=    						    
				                String.valueOf(row9.joueur1_prenom)			
					          ;	
							
	    		} //			
    			   				
	    		if(row9.joueur1_nationalite != null) { //              
                 row_tLogRow_5[2]=    						    
				                String.valueOf(row9.joueur1_nationalite)			
					          ;	
							
	    		} //			
    			   				
	    		if(row9.joueur2_nom != null) { //              
                 row_tLogRow_5[3]=    						    
				                String.valueOf(row9.joueur2_nom)			
					          ;	
							
	    		} //			
    			   				
	    		if(row9.joueur2_prenom != null) { //              
                 row_tLogRow_5[4]=    						    
				                String.valueOf(row9.joueur2_prenom)			
					          ;	
							
	    		} //			
    			   				
	    		if(row9.joueur2_nationalite != null) { //              
                 row_tLogRow_5[5]=    						    
				                String.valueOf(row9.joueur2_nationalite)			
					          ;	
							
	    		} //			
    			   				
	    		if(row9.seed != null) { //              
                 row_tLogRow_5[6]=    						    
				                String.valueOf(row9.seed)			
					          ;	
							
	    		} //			
    			   				
	    		if(row9.round != null) { //              
                 row_tLogRow_5[7]=    						    
				                String.valueOf(row9.round)			
					          ;	
							
	    		} //			
    			   				
	    		if(row9.score != null) { //              
                 row_tLogRow_5[8]=    						    
				                String.valueOf(row9.score)			
					          ;	
							
	    		} //			
    			   				
	    		if(row9.resultat != null) { //              
                 row_tLogRow_5[9]=    						    
				                String.valueOf(row9.resultat)			
					          ;	
							
	    		} //			
    			   				
	    		if(row9.date_tournoi != null) { //              
                 row_tLogRow_5[10]=    						
								FormatterUtils.format_Date(row9.date_tournoi, "yyyy-MM-dd")
					          ;	
							
	    		} //			
    			   				
	    		if(row9.nom_tournoi != null) { //              
                 row_tLogRow_5[11]=    						    
				                String.valueOf(row9.nom_tournoi)			
					          ;	
							
	    		} //			
    			   				
	    		if(row9.lieu_tournoi != null) { //              
                 row_tLogRow_5[12]=    						    
				                String.valueOf(row9.lieu_tournoi)			
					          ;	
							
	    		} //			
    			   				
	    		if(row9.prize_money != null) { //              
                 row_tLogRow_5[13]=    						
								row9.prize_money.toPlainString()
					          ;	
							
	    		} //			
    			   				
	    		if(row9.points != null) { //              
                 row_tLogRow_5[14]=    						    
				                String.valueOf(row9.points)			
					          ;	
							
	    		} //			
    			 

				util_tLogRow_5.addRow(row_tLogRow_5);	
				nb_line_tLogRow_5++;
//////

//////                    
                    
///////////////////////    			

 
     row10 = row9;


	tos_count_tLogRow_5++;

/**
 * [tLogRow_5 main ] stop
 */
	
	/**
	 * [tLogRow_5 process_data_begin ] start
	 */

	

	
	
	currentComponent="tLogRow_5";

	

 



/**
 * [tLogRow_5 process_data_begin ] stop
 */

	
	/**
	 * [tDBOutput_5 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_5";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row10"
						
						);
					}
					



        whetherReject_tDBOutput_5 = false;
                    if(row10.joueur1_nom == null) {
pstmt_tDBOutput_5.setNull(1, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_5.setString(1, row10.joueur1_nom);
}

                    if(row10.joueur1_prenom == null) {
pstmt_tDBOutput_5.setNull(2, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_5.setString(2, row10.joueur1_prenom);
}

                    if(row10.joueur1_nationalite == null) {
pstmt_tDBOutput_5.setNull(3, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_5.setString(3, row10.joueur1_nationalite);
}

                    if(row10.joueur2_nom == null) {
pstmt_tDBOutput_5.setNull(4, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_5.setString(4, row10.joueur2_nom);
}

                    if(row10.joueur2_prenom == null) {
pstmt_tDBOutput_5.setNull(5, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_5.setString(5, row10.joueur2_prenom);
}

                    if(row10.joueur2_nationalite == null) {
pstmt_tDBOutput_5.setNull(6, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_5.setString(6, row10.joueur2_nationalite);
}

                    if(row10.seed == null) {
pstmt_tDBOutput_5.setNull(7, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_5.setInt(7, row10.seed);
}

                    if(row10.round == null) {
pstmt_tDBOutput_5.setNull(8, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_5.setString(8, row10.round);
}

                    if(row10.score == null) {
pstmt_tDBOutput_5.setNull(9, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_5.setString(9, row10.score);
}

                    if(row10.resultat == null) {
pstmt_tDBOutput_5.setNull(10, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_5.setString(10, row10.resultat);
}

                    if(row10.date_tournoi != null) {
pstmt_tDBOutput_5.setTimestamp(11, new java.sql.Timestamp(row10.date_tournoi.getTime()));
} else {
pstmt_tDBOutput_5.setNull(11, java.sql.Types.TIMESTAMP);
}

                    if(row10.nom_tournoi == null) {
pstmt_tDBOutput_5.setNull(12, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_5.setString(12, row10.nom_tournoi);
}

                    if(row10.lieu_tournoi == null) {
pstmt_tDBOutput_5.setNull(13, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_5.setString(13, row10.lieu_tournoi);
}

                    pstmt_tDBOutput_5.setBigDecimal(14, row10.prize_money);

                    if(row10.points == null) {
pstmt_tDBOutput_5.setNull(15, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_5.setInt(15, row10.points);
}

			
    		pstmt_tDBOutput_5.addBatch();
    		nb_line_tDBOutput_5++;
    		  
    		  
    		  batchSizeCounter_tDBOutput_5++;
    		  
    			if ((batchSize_tDBOutput_5 > 0) && (batchSize_tDBOutput_5 <= batchSizeCounter_tDBOutput_5)) {
                try {
						int countSum_tDBOutput_5 = 0;
						    
						for(int countEach_tDBOutput_5: pstmt_tDBOutput_5.executeBatch()) {
							countSum_tDBOutput_5 += (countEach_tDBOutput_5 < 0 ? 0 : countEach_tDBOutput_5);
						}
				    	rowsToCommitCount_tDBOutput_5 += countSum_tDBOutput_5;
				    	
				    		insertedCount_tDBOutput_5 += countSum_tDBOutput_5;
				    	
            	    	batchSizeCounter_tDBOutput_5 = 0;
                }catch (java.sql.BatchUpdateException e_tDBOutput_5){
globalMap.put("tDBOutput_5_ERROR_MESSAGE",e_tDBOutput_5.getMessage());
				    	java.sql.SQLException ne_tDBOutput_5 = e_tDBOutput_5.getNextException(),sqle_tDBOutput_5=null;
				    	String errormessage_tDBOutput_5;
						if (ne_tDBOutput_5 != null) {
							// build new exception to provide the original cause
							sqle_tDBOutput_5 = new java.sql.SQLException(e_tDBOutput_5.getMessage() + "\ncaused by: " + ne_tDBOutput_5.getMessage(), ne_tDBOutput_5.getSQLState(), ne_tDBOutput_5.getErrorCode(), ne_tDBOutput_5);
							errormessage_tDBOutput_5 = sqle_tDBOutput_5.getMessage();
						}else{
							errormessage_tDBOutput_5 = e_tDBOutput_5.getMessage();
						}
				    	
				    	int countSum_tDBOutput_5 = 0;
						for(int countEach_tDBOutput_5: e_tDBOutput_5.getUpdateCounts()) {
							countSum_tDBOutput_5 += (countEach_tDBOutput_5 < 0 ? 0 : countEach_tDBOutput_5);
						}
						rowsToCommitCount_tDBOutput_5 += countSum_tDBOutput_5;
						
				    		insertedCount_tDBOutput_5 += countSum_tDBOutput_5;
				    	
				    	System.err.println(errormessage_tDBOutput_5);
				    	
					}
    			}
    		
    		    commitCounter_tDBOutput_5++;
                if(commitEvery_tDBOutput_5 <= commitCounter_tDBOutput_5) {
                if ((batchSize_tDBOutput_5 > 0) && (batchSizeCounter_tDBOutput_5 > 0)) {
                try {
                		int countSum_tDBOutput_5 = 0;
                		    
						for(int countEach_tDBOutput_5: pstmt_tDBOutput_5.executeBatch()) {
							countSum_tDBOutput_5 += (countEach_tDBOutput_5 < 0 ? 0 : countEach_tDBOutput_5);
						}
            	    	rowsToCommitCount_tDBOutput_5 += countSum_tDBOutput_5;
            	    	
            	    		insertedCount_tDBOutput_5 += countSum_tDBOutput_5;
            	    	
                batchSizeCounter_tDBOutput_5 = 0;
               }catch (java.sql.BatchUpdateException e_tDBOutput_5){
globalMap.put("tDBOutput_5_ERROR_MESSAGE",e_tDBOutput_5.getMessage());
			    	java.sql.SQLException ne_tDBOutput_5 = e_tDBOutput_5.getNextException(),sqle_tDBOutput_5=null;
			    	String errormessage_tDBOutput_5;
					if (ne_tDBOutput_5 != null) {
						// build new exception to provide the original cause
						sqle_tDBOutput_5 = new java.sql.SQLException(e_tDBOutput_5.getMessage() + "\ncaused by: " + ne_tDBOutput_5.getMessage(), ne_tDBOutput_5.getSQLState(), ne_tDBOutput_5.getErrorCode(), ne_tDBOutput_5);
						errormessage_tDBOutput_5 = sqle_tDBOutput_5.getMessage();
					}else{
						errormessage_tDBOutput_5 = e_tDBOutput_5.getMessage();
					}
			    	
			    	int countSum_tDBOutput_5 = 0;
					for(int countEach_tDBOutput_5: e_tDBOutput_5.getUpdateCounts()) {
						countSum_tDBOutput_5 += (countEach_tDBOutput_5 < 0 ? 0 : countEach_tDBOutput_5);
					}
					rowsToCommitCount_tDBOutput_5 += countSum_tDBOutput_5;
					
			    		insertedCount_tDBOutput_5 += countSum_tDBOutput_5;
			    	
			    	System.err.println(errormessage_tDBOutput_5);
			    	
				}
            }
                    if(rowsToCommitCount_tDBOutput_5 != 0){
                    	
                    }
                    conn_tDBOutput_5.commit();
                    if(rowsToCommitCount_tDBOutput_5 != 0){
                    	
                    	rowsToCommitCount_tDBOutput_5 = 0;
                    }
                    commitCounter_tDBOutput_5=0;
                }

 


	tos_count_tDBOutput_5++;

/**
 * [tDBOutput_5 main ] stop
 */
	
	/**
	 * [tDBOutput_5 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBOutput_5";

	

 



/**
 * [tDBOutput_5 process_data_begin ] stop
 */
	
	/**
	 * [tDBOutput_5 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBOutput_5";

	

 



/**
 * [tDBOutput_5 process_data_end ] stop
 */



	
	/**
	 * [tLogRow_5 process_data_end ] start
	 */

	

	
	
	currentComponent="tLogRow_5";

	

 



/**
 * [tLogRow_5 process_data_end ] stop
 */

} // End of branch "row9"




	
	/**
	 * [tFileInputDelimited_5 process_data_end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_5";

	

 



/**
 * [tFileInputDelimited_5 process_data_end ] stop
 */
	
	/**
	 * [tFileInputDelimited_5 end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_5";

	



            }
            }finally{
                if(!((Object)("C:/Users/ASUS/Downloads/Sports/Sports/script_tournois/aug.csv") instanceof java.io.InputStream)){
                	if(fid_tFileInputDelimited_5!=null){
                		fid_tFileInputDelimited_5.close();
                	}
                }
                if(fid_tFileInputDelimited_5!=null){
                	globalMap.put("tFileInputDelimited_5_NB_LINE", fid_tFileInputDelimited_5.getRowNumber());
					
                }
			}
			  

 

ok_Hash.put("tFileInputDelimited_5", true);
end_Hash.put("tFileInputDelimited_5", System.currentTimeMillis());




/**
 * [tFileInputDelimited_5 end ] stop
 */

	
	/**
	 * [tLogRow_5 end ] start
	 */

	

	
	
	currentComponent="tLogRow_5";

	


//////

                    
                    java.io.PrintStream consoleOut_tLogRow_5 = null;
                    if (globalMap.get("tLogRow_CONSOLE")!=null)
                    {
                    	consoleOut_tLogRow_5 = (java.io.PrintStream) globalMap.get("tLogRow_CONSOLE");
                    }
                    else
                    {
                    	consoleOut_tLogRow_5 = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));
                    	globalMap.put("tLogRow_CONSOLE",consoleOut_tLogRow_5);
                    }
                    
                    consoleOut_tLogRow_5.println(util_tLogRow_5.format().toString());
                    consoleOut_tLogRow_5.flush();
//////
globalMap.put("tLogRow_5_NB_LINE",nb_line_tLogRow_5);

///////////////////////    			

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row9");
			  	}
			  	
 

ok_Hash.put("tLogRow_5", true);
end_Hash.put("tLogRow_5", System.currentTimeMillis());




/**
 * [tLogRow_5 end ] stop
 */

	
	/**
	 * [tDBOutput_5 end ] start
	 */

	

	
	
	currentComponent="tDBOutput_5";

	



	    try {
				int countSum_tDBOutput_5 = 0;
				if (pstmt_tDBOutput_5 != null && batchSizeCounter_tDBOutput_5 > 0) {
						
					for(int countEach_tDBOutput_5: pstmt_tDBOutput_5.executeBatch()) {
						countSum_tDBOutput_5 += (countEach_tDBOutput_5 < 0 ? 0 : countEach_tDBOutput_5);
					}
					rowsToCommitCount_tDBOutput_5 += countSum_tDBOutput_5;
						
				}
		    	
		    		insertedCount_tDBOutput_5 += countSum_tDBOutput_5;
		    	
	    }catch (java.sql.BatchUpdateException e_tDBOutput_5){
globalMap.put("tDBOutput_5_ERROR_MESSAGE",e_tDBOutput_5.getMessage());
	    	java.sql.SQLException ne_tDBOutput_5 = e_tDBOutput_5.getNextException(),sqle_tDBOutput_5=null;
	    	String errormessage_tDBOutput_5;
			if (ne_tDBOutput_5 != null) {
				// build new exception to provide the original cause
				sqle_tDBOutput_5 = new java.sql.SQLException(e_tDBOutput_5.getMessage() + "\ncaused by: " + ne_tDBOutput_5.getMessage(), ne_tDBOutput_5.getSQLState(), ne_tDBOutput_5.getErrorCode(), ne_tDBOutput_5);
				errormessage_tDBOutput_5 = sqle_tDBOutput_5.getMessage();
			}else{
				errormessage_tDBOutput_5 = e_tDBOutput_5.getMessage();
			}
	    	
	    	int countSum_tDBOutput_5 = 0;
			for(int countEach_tDBOutput_5: e_tDBOutput_5.getUpdateCounts()) {
				countSum_tDBOutput_5 += (countEach_tDBOutput_5 < 0 ? 0 : countEach_tDBOutput_5);
			}
			rowsToCommitCount_tDBOutput_5 += countSum_tDBOutput_5;
			
	    		insertedCount_tDBOutput_5 += countSum_tDBOutput_5;
	    	
	    	System.err.println(errormessage_tDBOutput_5);
	    	
		}
	    
        if(pstmt_tDBOutput_5 != null) {
        		
            pstmt_tDBOutput_5.close();
            resourceMap.remove("pstmt_tDBOutput_5");
        }
    resourceMap.put("statementClosed_tDBOutput_5", true);
			if(rowsToCommitCount_tDBOutput_5 != 0){
				
			}
			conn_tDBOutput_5.commit();
			if(rowsToCommitCount_tDBOutput_5 != 0){
				
				rowsToCommitCount_tDBOutput_5 = 0;
			}
			commitCounter_tDBOutput_5 = 0;
		
    	conn_tDBOutput_5 .close();
    	
    	resourceMap.put("finish_tDBOutput_5", true);
    	

	nb_line_deleted_tDBOutput_5=nb_line_deleted_tDBOutput_5+ deletedCount_tDBOutput_5;
	nb_line_update_tDBOutput_5=nb_line_update_tDBOutput_5 + updatedCount_tDBOutput_5;
	nb_line_inserted_tDBOutput_5=nb_line_inserted_tDBOutput_5 + insertedCount_tDBOutput_5;
	nb_line_rejected_tDBOutput_5=nb_line_rejected_tDBOutput_5 + rejectedCount_tDBOutput_5;
	
        globalMap.put("tDBOutput_5_NB_LINE",nb_line_tDBOutput_5);
        globalMap.put("tDBOutput_5_NB_LINE_UPDATED",nb_line_update_tDBOutput_5);
        globalMap.put("tDBOutput_5_NB_LINE_INSERTED",nb_line_inserted_tDBOutput_5);
        globalMap.put("tDBOutput_5_NB_LINE_DELETED",nb_line_deleted_tDBOutput_5);
        globalMap.put("tDBOutput_5_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_5);
    

	


				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row10");
			  	}
			  	
 

ok_Hash.put("tDBOutput_5", true);
end_Hash.put("tDBOutput_5", System.currentTimeMillis());




/**
 * [tDBOutput_5 end ] stop
 */






				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tFileInputDelimited_5 finally ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_5";

	

 



/**
 * [tFileInputDelimited_5 finally ] stop
 */

	
	/**
	 * [tLogRow_5 finally ] start
	 */

	

	
	
	currentComponent="tLogRow_5";

	

 



/**
 * [tLogRow_5 finally ] stop
 */

	
	/**
	 * [tDBOutput_5 finally ] start
	 */

	

	
	
	currentComponent="tDBOutput_5";

	



    try {
    if (resourceMap.get("statementClosed_tDBOutput_5") == null) {
                java.sql.PreparedStatement pstmtToClose_tDBOutput_5 = null;
                if ((pstmtToClose_tDBOutput_5 = (java.sql.PreparedStatement) resourceMap.remove("pstmt_tDBOutput_5")) != null) {
                    pstmtToClose_tDBOutput_5.close();
                }
    }
    } finally {
        if(resourceMap.get("finish_tDBOutput_5") == null){
            java.sql.Connection ctn_tDBOutput_5 = null;
            if((ctn_tDBOutput_5 = (java.sql.Connection)resourceMap.get("conn_tDBOutput_5")) != null){
                try {
                    ctn_tDBOutput_5.close();
                } catch (java.sql.SQLException sqlEx_tDBOutput_5) {
                    String errorMessage_tDBOutput_5 = "failed to close the connection in tDBOutput_5 :" + sqlEx_tDBOutput_5.getMessage();
                    System.err.println(errorMessage_tDBOutput_5);
                }
            }
        }
    }
 



/**
 * [tDBOutput_5 finally ] stop
 */






				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tFileInputDelimited_5_SUBPROCESS_STATE", 1);
	}
	


public static class row12Struct implements routines.system.IPersistableRow<row12Struct> {
    final static byte[] commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[0];
    static byte[] commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[0];

	
			    public String joueur1_nom;

				public String getJoueur1_nom () {
					return this.joueur1_nom;
				}
				
			    public String joueur1_prenom;

				public String getJoueur1_prenom () {
					return this.joueur1_prenom;
				}
				
			    public String joueur1_nationalite;

				public String getJoueur1_nationalite () {
					return this.joueur1_nationalite;
				}
				
			    public String joueur2_nom;

				public String getJoueur2_nom () {
					return this.joueur2_nom;
				}
				
			    public String joueur2_prenom;

				public String getJoueur2_prenom () {
					return this.joueur2_prenom;
				}
				
			    public String joueur2_nationalite;

				public String getJoueur2_nationalite () {
					return this.joueur2_nationalite;
				}
				
			    public Integer seed;

				public Integer getSeed () {
					return this.seed;
				}
				
			    public String round;

				public String getRound () {
					return this.round;
				}
				
			    public String score;

				public String getScore () {
					return this.score;
				}
				
			    public String resultat;

				public String getResultat () {
					return this.resultat;
				}
				
			    public java.util.Date date_tournoi;

				public java.util.Date getDate_tournoi () {
					return this.date_tournoi;
				}
				
			    public String nom_tournoi;

				public String getNom_tournoi () {
					return this.nom_tournoi;
				}
				
			    public String lieu_tournoi;

				public String getLieu_tournoi () {
					return this.lieu_tournoi;
				}
				
			    public BigDecimal prize_money;

				public BigDecimal getPrize_money () {
					return this.prize_money;
				}
				
			    public Integer points;

				public Integer getPoints () {
					return this.points;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length) {
				if(length < 1024 && commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length == 0) {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[1024];
				} else {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length);
			strReturn = new String(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length) {
				if(length < 1024 && commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length == 0) {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[1024];
				} else {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length);
			strReturn = new String(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep) {

        	try {

        		int length = 0;
		
					this.joueur1_nom = readString(dis);
					
					this.joueur1_prenom = readString(dis);
					
					this.joueur1_nationalite = readString(dis);
					
					this.joueur2_nom = readString(dis);
					
					this.joueur2_prenom = readString(dis);
					
					this.joueur2_nationalite = readString(dis);
					
						this.seed = readInteger(dis);
					
					this.round = readString(dis);
					
					this.score = readString(dis);
					
					this.resultat = readString(dis);
					
					this.date_tournoi = readDate(dis);
					
					this.nom_tournoi = readString(dis);
					
					this.lieu_tournoi = readString(dis);
					
						this.prize_money = (BigDecimal) dis.readObject();
					
						this.points = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep) {

        	try {

        		int length = 0;
		
					this.joueur1_nom = readString(dis);
					
					this.joueur1_prenom = readString(dis);
					
					this.joueur1_nationalite = readString(dis);
					
					this.joueur2_nom = readString(dis);
					
					this.joueur2_prenom = readString(dis);
					
					this.joueur2_nationalite = readString(dis);
					
						this.seed = readInteger(dis);
					
					this.round = readString(dis);
					
					this.score = readString(dis);
					
					this.resultat = readString(dis);
					
					this.date_tournoi = readDate(dis);
					
					this.nom_tournoi = readString(dis);
					
					this.lieu_tournoi = readString(dis);
					
						this.prize_money = (BigDecimal) dis.readObject();
					
						this.points = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.joueur1_nom,dos);
					
					// String
				
						writeString(this.joueur1_prenom,dos);
					
					// String
				
						writeString(this.joueur1_nationalite,dos);
					
					// String
				
						writeString(this.joueur2_nom,dos);
					
					// String
				
						writeString(this.joueur2_prenom,dos);
					
					// String
				
						writeString(this.joueur2_nationalite,dos);
					
					// Integer
				
						writeInteger(this.seed,dos);
					
					// String
				
						writeString(this.round,dos);
					
					// String
				
						writeString(this.score,dos);
					
					// String
				
						writeString(this.resultat,dos);
					
					// java.util.Date
				
						writeDate(this.date_tournoi,dos);
					
					// String
				
						writeString(this.nom_tournoi,dos);
					
					// String
				
						writeString(this.lieu_tournoi,dos);
					
					// BigDecimal
				
       			    	dos.writeObject(this.prize_money);
					
					// Integer
				
						writeInteger(this.points,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.joueur1_nom,dos);
					
					// String
				
						writeString(this.joueur1_prenom,dos);
					
					// String
				
						writeString(this.joueur1_nationalite,dos);
					
					// String
				
						writeString(this.joueur2_nom,dos);
					
					// String
				
						writeString(this.joueur2_prenom,dos);
					
					// String
				
						writeString(this.joueur2_nationalite,dos);
					
					// Integer
				
						writeInteger(this.seed,dos);
					
					// String
				
						writeString(this.round,dos);
					
					// String
				
						writeString(this.score,dos);
					
					// String
				
						writeString(this.resultat,dos);
					
					// java.util.Date
				
						writeDate(this.date_tournoi,dos);
					
					// String
				
						writeString(this.nom_tournoi,dos);
					
					// String
				
						writeString(this.lieu_tournoi,dos);
					
					// BigDecimal
				
       			    	dos.writeObject(this.prize_money);
					
					// Integer
				
						writeInteger(this.points,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("joueur1_nom="+joueur1_nom);
		sb.append(",joueur1_prenom="+joueur1_prenom);
		sb.append(",joueur1_nationalite="+joueur1_nationalite);
		sb.append(",joueur2_nom="+joueur2_nom);
		sb.append(",joueur2_prenom="+joueur2_prenom);
		sb.append(",joueur2_nationalite="+joueur2_nationalite);
		sb.append(",seed="+String.valueOf(seed));
		sb.append(",round="+round);
		sb.append(",score="+score);
		sb.append(",resultat="+resultat);
		sb.append(",date_tournoi="+String.valueOf(date_tournoi));
		sb.append(",nom_tournoi="+nom_tournoi);
		sb.append(",lieu_tournoi="+lieu_tournoi);
		sb.append(",prize_money="+String.valueOf(prize_money));
		sb.append(",points="+String.valueOf(points));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row12Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class row11Struct implements routines.system.IPersistableRow<row11Struct> {
    final static byte[] commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[0];
    static byte[] commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[0];

	
			    public String joueur1_nom;

				public String getJoueur1_nom () {
					return this.joueur1_nom;
				}
				
			    public String joueur1_prenom;

				public String getJoueur1_prenom () {
					return this.joueur1_prenom;
				}
				
			    public String joueur1_nationalite;

				public String getJoueur1_nationalite () {
					return this.joueur1_nationalite;
				}
				
			    public String joueur2_nom;

				public String getJoueur2_nom () {
					return this.joueur2_nom;
				}
				
			    public String joueur2_prenom;

				public String getJoueur2_prenom () {
					return this.joueur2_prenom;
				}
				
			    public String joueur2_nationalite;

				public String getJoueur2_nationalite () {
					return this.joueur2_nationalite;
				}
				
			    public Integer seed;

				public Integer getSeed () {
					return this.seed;
				}
				
			    public String round;

				public String getRound () {
					return this.round;
				}
				
			    public String score;

				public String getScore () {
					return this.score;
				}
				
			    public String resultat;

				public String getResultat () {
					return this.resultat;
				}
				
			    public java.util.Date date_tournoi;

				public java.util.Date getDate_tournoi () {
					return this.date_tournoi;
				}
				
			    public String nom_tournoi;

				public String getNom_tournoi () {
					return this.nom_tournoi;
				}
				
			    public String lieu_tournoi;

				public String getLieu_tournoi () {
					return this.lieu_tournoi;
				}
				
			    public BigDecimal prize_money;

				public BigDecimal getPrize_money () {
					return this.prize_money;
				}
				
			    public Integer points;

				public Integer getPoints () {
					return this.points;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length) {
				if(length < 1024 && commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length == 0) {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[1024];
				} else {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length);
			strReturn = new String(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length) {
				if(length < 1024 && commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length == 0) {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[1024];
				} else {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length);
			strReturn = new String(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep) {

        	try {

        		int length = 0;
		
					this.joueur1_nom = readString(dis);
					
					this.joueur1_prenom = readString(dis);
					
					this.joueur1_nationalite = readString(dis);
					
					this.joueur2_nom = readString(dis);
					
					this.joueur2_prenom = readString(dis);
					
					this.joueur2_nationalite = readString(dis);
					
						this.seed = readInteger(dis);
					
					this.round = readString(dis);
					
					this.score = readString(dis);
					
					this.resultat = readString(dis);
					
					this.date_tournoi = readDate(dis);
					
					this.nom_tournoi = readString(dis);
					
					this.lieu_tournoi = readString(dis);
					
						this.prize_money = (BigDecimal) dis.readObject();
					
						this.points = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep) {

        	try {

        		int length = 0;
		
					this.joueur1_nom = readString(dis);
					
					this.joueur1_prenom = readString(dis);
					
					this.joueur1_nationalite = readString(dis);
					
					this.joueur2_nom = readString(dis);
					
					this.joueur2_prenom = readString(dis);
					
					this.joueur2_nationalite = readString(dis);
					
						this.seed = readInteger(dis);
					
					this.round = readString(dis);
					
					this.score = readString(dis);
					
					this.resultat = readString(dis);
					
					this.date_tournoi = readDate(dis);
					
					this.nom_tournoi = readString(dis);
					
					this.lieu_tournoi = readString(dis);
					
						this.prize_money = (BigDecimal) dis.readObject();
					
						this.points = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.joueur1_nom,dos);
					
					// String
				
						writeString(this.joueur1_prenom,dos);
					
					// String
				
						writeString(this.joueur1_nationalite,dos);
					
					// String
				
						writeString(this.joueur2_nom,dos);
					
					// String
				
						writeString(this.joueur2_prenom,dos);
					
					// String
				
						writeString(this.joueur2_nationalite,dos);
					
					// Integer
				
						writeInteger(this.seed,dos);
					
					// String
				
						writeString(this.round,dos);
					
					// String
				
						writeString(this.score,dos);
					
					// String
				
						writeString(this.resultat,dos);
					
					// java.util.Date
				
						writeDate(this.date_tournoi,dos);
					
					// String
				
						writeString(this.nom_tournoi,dos);
					
					// String
				
						writeString(this.lieu_tournoi,dos);
					
					// BigDecimal
				
       			    	dos.writeObject(this.prize_money);
					
					// Integer
				
						writeInteger(this.points,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.joueur1_nom,dos);
					
					// String
				
						writeString(this.joueur1_prenom,dos);
					
					// String
				
						writeString(this.joueur1_nationalite,dos);
					
					// String
				
						writeString(this.joueur2_nom,dos);
					
					// String
				
						writeString(this.joueur2_prenom,dos);
					
					// String
				
						writeString(this.joueur2_nationalite,dos);
					
					// Integer
				
						writeInteger(this.seed,dos);
					
					// String
				
						writeString(this.round,dos);
					
					// String
				
						writeString(this.score,dos);
					
					// String
				
						writeString(this.resultat,dos);
					
					// java.util.Date
				
						writeDate(this.date_tournoi,dos);
					
					// String
				
						writeString(this.nom_tournoi,dos);
					
					// String
				
						writeString(this.lieu_tournoi,dos);
					
					// BigDecimal
				
       			    	dos.writeObject(this.prize_money);
					
					// Integer
				
						writeInteger(this.points,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("joueur1_nom="+joueur1_nom);
		sb.append(",joueur1_prenom="+joueur1_prenom);
		sb.append(",joueur1_nationalite="+joueur1_nationalite);
		sb.append(",joueur2_nom="+joueur2_nom);
		sb.append(",joueur2_prenom="+joueur2_prenom);
		sb.append(",joueur2_nationalite="+joueur2_nationalite);
		sb.append(",seed="+String.valueOf(seed));
		sb.append(",round="+round);
		sb.append(",score="+score);
		sb.append(",resultat="+resultat);
		sb.append(",date_tournoi="+String.valueOf(date_tournoi));
		sb.append(",nom_tournoi="+nom_tournoi);
		sb.append(",lieu_tournoi="+lieu_tournoi);
		sb.append(",prize_money="+String.valueOf(prize_money));
		sb.append(",points="+String.valueOf(points));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row11Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tFileInputDelimited_6Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tFileInputDelimited_6_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row11Struct row11 = new row11Struct();
row11Struct row12 = row11;





	
	/**
	 * [tDBOutput_6 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBOutput_6", false);
		start_Hash.put("tDBOutput_6", System.currentTimeMillis());
		
	
	currentComponent="tDBOutput_6";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row12");
					}
				
		int tos_count_tDBOutput_6 = 0;
		





String dbschema_tDBOutput_6 = null;
	dbschema_tDBOutput_6 = "sa";
	

String tableName_tDBOutput_6 = null;
if(dbschema_tDBOutput_6 == null || dbschema_tDBOutput_6.trim().length() == 0) {
	tableName_tDBOutput_6 = ("sa_tournament_mai");
} else {
	tableName_tDBOutput_6 = dbschema_tDBOutput_6 + "\".\"" + ("sa_tournament_mai");
}


int nb_line_tDBOutput_6 = 0;
int nb_line_update_tDBOutput_6 = 0;
int nb_line_inserted_tDBOutput_6 = 0;
int nb_line_deleted_tDBOutput_6 = 0;
int nb_line_rejected_tDBOutput_6 = 0;

int deletedCount_tDBOutput_6=0;
int updatedCount_tDBOutput_6=0;
int insertedCount_tDBOutput_6=0;
int rowsToCommitCount_tDBOutput_6=0;
int rejectedCount_tDBOutput_6=0;

boolean whetherReject_tDBOutput_6 = false;

java.sql.Connection conn_tDBOutput_6 = null;
String dbUser_tDBOutput_6 = null;

	
    java.lang.Class.forName("org.postgresql.Driver");
    
        String url_tDBOutput_6 = "jdbc:postgresql://"+"localhost"+":"+"5432"+"/"+"padel_bi_SA";
    dbUser_tDBOutput_6 = "postgres";
 
	final String decryptedPassword_tDBOutput_6 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:F2xthxGNpH91w19OHYhlF/8D5MN0Luj1d+3dTKmzpvaDkjYgpw==");

    String dbPwd_tDBOutput_6 = decryptedPassword_tDBOutput_6;

    conn_tDBOutput_6 = java.sql.DriverManager.getConnection(url_tDBOutput_6,dbUser_tDBOutput_6,dbPwd_tDBOutput_6);
	
	resourceMap.put("conn_tDBOutput_6", conn_tDBOutput_6);
        conn_tDBOutput_6.setAutoCommit(false);
        int commitEvery_tDBOutput_6 = 10000;
        int commitCounter_tDBOutput_6 = 0;


   int batchSize_tDBOutput_6 = 10000;
   int batchSizeCounter_tDBOutput_6=0;

int count_tDBOutput_6=0;
	    String insert_tDBOutput_6 = "INSERT INTO \"" + tableName_tDBOutput_6 + "\" (\"joueur1_nom\",\"joueur1_prenom\",\"joueur1_nationalite\",\"joueur2_nom\",\"joueur2_prenom\",\"joueur2_nationalite\",\"seed\",\"round\",\"score\",\"resultat\",\"date_tournoi\",\"nom_tournoi\",\"lieu_tournoi\",\"prize_money\",\"points\") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	    
	    java.sql.PreparedStatement pstmt_tDBOutput_6 = conn_tDBOutput_6.prepareStatement(insert_tDBOutput_6);
	    resourceMap.put("pstmt_tDBOutput_6", pstmt_tDBOutput_6);
	    

 



/**
 * [tDBOutput_6 begin ] stop
 */



	
	/**
	 * [tLogRow_6 begin ] start
	 */

	

	
		
		ok_Hash.put("tLogRow_6", false);
		start_Hash.put("tLogRow_6", System.currentTimeMillis());
		
	
	currentComponent="tLogRow_6";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row11");
					}
				
		int tos_count_tLogRow_6 = 0;
		

	///////////////////////
	
         class Util_tLogRow_6 {

        String[] des_top = { ".", ".", "-", "+" };

        String[] des_head = { "|=", "=|", "-", "+" };

        String[] des_bottom = { "'", "'", "-", "+" };

        String name="";

        java.util.List<String[]> list = new java.util.ArrayList<String[]>();

        int[] colLengths = new int[15];

        public void addRow(String[] row) {

            for (int i = 0; i < 15; i++) {
                if (row[i]!=null) {
                  colLengths[i] = Math.max(colLengths[i], row[i].length());
                }
            }
            list.add(row);
        }

        public void setTableName(String name) {

            this.name = name;
        }

            public StringBuilder format() {
            
                StringBuilder sb = new StringBuilder();
  
            
                    sb.append(print(des_top));
    
                    int totals = 0;
                    for (int i = 0; i < colLengths.length; i++) {
                        totals = totals + colLengths[i];
                    }
    
                    // name
                    sb.append("|");
                    int k = 0;
                    for (k = 0; k < (totals + 14 - name.length()) / 2; k++) {
                        sb.append(' ');
                    }
                    sb.append(name);
                    for (int i = 0; i < totals + 14 - name.length() - k; i++) {
                        sb.append(' ');
                    }
                    sb.append("|\n");

                    // head and rows
                    sb.append(print(des_head));
                    for (int i = 0; i < list.size(); i++) {
    
                        String[] row = list.get(i);
    
                        java.util.Formatter formatter = new java.util.Formatter(new StringBuilder());
                        
                        StringBuilder sbformat = new StringBuilder();                                             
        			        sbformat.append("|%1$-");
        			        sbformat.append(colLengths[0]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%2$-");
        			        sbformat.append(colLengths[1]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%3$-");
        			        sbformat.append(colLengths[2]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%4$-");
        			        sbformat.append(colLengths[3]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%5$-");
        			        sbformat.append(colLengths[4]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%6$-");
        			        sbformat.append(colLengths[5]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%7$-");
        			        sbformat.append(colLengths[6]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%8$-");
        			        sbformat.append(colLengths[7]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%9$-");
        			        sbformat.append(colLengths[8]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%10$-");
        			        sbformat.append(colLengths[9]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%11$-");
        			        sbformat.append(colLengths[10]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%12$-");
        			        sbformat.append(colLengths[11]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%13$-");
        			        sbformat.append(colLengths[12]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%14$-");
        			        sbformat.append(colLengths[13]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%15$-");
        			        sbformat.append(colLengths[14]);
        			        sbformat.append("s");
        			                      
                        sbformat.append("|\n");                    
       
                        formatter.format(sbformat.toString(), (Object[])row);	
                                
                        sb.append(formatter.toString());
                        if (i == 0)
                            sb.append(print(des_head)); // print the head
                    }
    
                    // end
                    sb.append(print(des_bottom));
                    return sb;
                }
            

            private StringBuilder print(String[] fillChars) {
                StringBuilder sb = new StringBuilder();
                //first column
                sb.append(fillChars[0]);                
                    for (int i = 0; i < colLengths[0] - fillChars[0].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);	                

                    for (int i = 0; i < colLengths[1] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[2] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[3] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[4] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[5] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[6] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[7] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[8] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[9] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[10] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[11] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[12] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[13] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                
                    //last column
                    for (int i = 0; i < colLengths[14] - fillChars[1].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }         
                sb.append(fillChars[1]);
                sb.append("\n");               
                return sb;
            }
            
            public boolean isTableEmpty(){
            	if (list.size() > 1)
            		return false;
            	return true;
            }
        }
        Util_tLogRow_6 util_tLogRow_6 = new Util_tLogRow_6();
        util_tLogRow_6.setTableName("tLogRow_6");
        util_tLogRow_6.addRow(new String[]{"joueur1_nom","joueur1_prenom","joueur1_nationalite","joueur2_nom","joueur2_prenom","joueur2_nationalite","seed","round","score","resultat","date_tournoi","nom_tournoi","lieu_tournoi","prize_money","points",});        
 		StringBuilder strBuffer_tLogRow_6 = null;
		int nb_line_tLogRow_6 = 0;
///////////////////////    			



 



/**
 * [tLogRow_6 begin ] stop
 */



	
	/**
	 * [tFileInputDelimited_6 begin ] start
	 */

	

	
		
		ok_Hash.put("tFileInputDelimited_6", false);
		start_Hash.put("tFileInputDelimited_6", System.currentTimeMillis());
		
	
	currentComponent="tFileInputDelimited_6";

	
		int tos_count_tFileInputDelimited_6 = 0;
		
	
	
	
 
	
	
	final routines.system.RowState rowstate_tFileInputDelimited_6 = new routines.system.RowState();
	
	
				int nb_line_tFileInputDelimited_6 = 0;
				org.talend.fileprocess.FileInputDelimited fid_tFileInputDelimited_6 = null;
				int limit_tFileInputDelimited_6 = -1;
				try{
					
						Object filename_tFileInputDelimited_6 = "C:/Users/ASUS/Downloads/Sports/Sports/script_tournois/mai.csv";
						if(filename_tFileInputDelimited_6 instanceof java.io.InputStream){
							
			int footer_value_tFileInputDelimited_6 = 0, random_value_tFileInputDelimited_6 = -1;
			if(footer_value_tFileInputDelimited_6 >0 || random_value_tFileInputDelimited_6 > 0){
				throw new java.lang.Exception("When the input source is a stream,footer and random shouldn't be bigger than 0.");				
			}
		
						}
						try {
							fid_tFileInputDelimited_6 = new org.talend.fileprocess.FileInputDelimited("C:/Users/ASUS/Downloads/Sports/Sports/script_tournois/mai.csv", "ISO-8859-15",";","\n",true,1,0,
									limit_tFileInputDelimited_6
								,-1, false);
						} catch(java.lang.Exception e) {
globalMap.put("tFileInputDelimited_6_ERROR_MESSAGE",e.getMessage());
							
								
								System.err.println(e.getMessage());
							
						}
					
				    
					while (fid_tFileInputDelimited_6!=null && fid_tFileInputDelimited_6.nextRecord()) {
						rowstate_tFileInputDelimited_6.reset();
						
			    						row11 = null;			
												
									boolean whetherReject_tFileInputDelimited_6 = false;
									row11 = new row11Struct();
									try {
										
				int columnIndexWithD_tFileInputDelimited_6 = 0;
				
					String temp = ""; 
				
					columnIndexWithD_tFileInputDelimited_6 = 0;
					
							row11.joueur1_nom = fid_tFileInputDelimited_6.get(columnIndexWithD_tFileInputDelimited_6);
						
				
					columnIndexWithD_tFileInputDelimited_6 = 1;
					
							row11.joueur1_prenom = fid_tFileInputDelimited_6.get(columnIndexWithD_tFileInputDelimited_6);
						
				
					columnIndexWithD_tFileInputDelimited_6 = 2;
					
							row11.joueur1_nationalite = fid_tFileInputDelimited_6.get(columnIndexWithD_tFileInputDelimited_6);
						
				
					columnIndexWithD_tFileInputDelimited_6 = 3;
					
							row11.joueur2_nom = fid_tFileInputDelimited_6.get(columnIndexWithD_tFileInputDelimited_6);
						
				
					columnIndexWithD_tFileInputDelimited_6 = 4;
					
							row11.joueur2_prenom = fid_tFileInputDelimited_6.get(columnIndexWithD_tFileInputDelimited_6);
						
				
					columnIndexWithD_tFileInputDelimited_6 = 5;
					
							row11.joueur2_nationalite = fid_tFileInputDelimited_6.get(columnIndexWithD_tFileInputDelimited_6);
						
				
					columnIndexWithD_tFileInputDelimited_6 = 6;
					
						temp = fid_tFileInputDelimited_6.get(columnIndexWithD_tFileInputDelimited_6);
						if(temp.length() > 0) {
							
								try {
								
    								row11.seed = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_6) {
globalMap.put("tFileInputDelimited_6_ERROR_MESSAGE",ex_tFileInputDelimited_6.getMessage());
									rowstate_tFileInputDelimited_6.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"seed", "row11", temp, ex_tFileInputDelimited_6), ex_tFileInputDelimited_6));
								}
    							
						} else {						
							
								
									row11.seed = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_6 = 7;
					
							row11.round = fid_tFileInputDelimited_6.get(columnIndexWithD_tFileInputDelimited_6);
						
				
					columnIndexWithD_tFileInputDelimited_6 = 8;
					
							row11.score = fid_tFileInputDelimited_6.get(columnIndexWithD_tFileInputDelimited_6);
						
				
					columnIndexWithD_tFileInputDelimited_6 = 9;
					
							row11.resultat = fid_tFileInputDelimited_6.get(columnIndexWithD_tFileInputDelimited_6);
						
				
					columnIndexWithD_tFileInputDelimited_6 = 10;
					
						temp = fid_tFileInputDelimited_6.get(columnIndexWithD_tFileInputDelimited_6);
						if(temp.length() > 0) {
							
								try {
								
    									row11.date_tournoi = ParserUtils.parseTo_Date(temp, "yyyy-MM-dd");
    								
    							} catch(java.lang.Exception ex_tFileInputDelimited_6) {
globalMap.put("tFileInputDelimited_6_ERROR_MESSAGE",ex_tFileInputDelimited_6.getMessage());
									rowstate_tFileInputDelimited_6.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"date_tournoi", "row11", temp, ex_tFileInputDelimited_6), ex_tFileInputDelimited_6));
								}
    							
						} else {						
							
								
									row11.date_tournoi = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_6 = 11;
					
							row11.nom_tournoi = fid_tFileInputDelimited_6.get(columnIndexWithD_tFileInputDelimited_6);
						
				
					columnIndexWithD_tFileInputDelimited_6 = 12;
					
							row11.lieu_tournoi = fid_tFileInputDelimited_6.get(columnIndexWithD_tFileInputDelimited_6);
						
				
					columnIndexWithD_tFileInputDelimited_6 = 13;
					
						temp = fid_tFileInputDelimited_6.get(columnIndexWithD_tFileInputDelimited_6);
						if(temp.length() > 0) {
							
								try {
								
    								row11.prize_money = ParserUtils.parseTo_BigDecimal(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_6) {
globalMap.put("tFileInputDelimited_6_ERROR_MESSAGE",ex_tFileInputDelimited_6.getMessage());
									rowstate_tFileInputDelimited_6.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"prize_money", "row11", temp, ex_tFileInputDelimited_6), ex_tFileInputDelimited_6));
								}
    							
						} else {						
							
								
									row11.prize_money = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_6 = 14;
					
						temp = fid_tFileInputDelimited_6.get(columnIndexWithD_tFileInputDelimited_6);
						if(temp.length() > 0) {
							
								try {
								
    								row11.points = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_6) {
globalMap.put("tFileInputDelimited_6_ERROR_MESSAGE",ex_tFileInputDelimited_6.getMessage());
									rowstate_tFileInputDelimited_6.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"points", "row11", temp, ex_tFileInputDelimited_6), ex_tFileInputDelimited_6));
								}
    							
						} else {						
							
								
									row11.points = null;
								
							
						}
					
				
				
										
										if(rowstate_tFileInputDelimited_6.getException()!=null) {
											throw rowstate_tFileInputDelimited_6.getException();
										}
										
										
							
			    					} catch (java.lang.Exception e) {
globalMap.put("tFileInputDelimited_6_ERROR_MESSAGE",e.getMessage());
			        					whetherReject_tFileInputDelimited_6 = true;
			        					
			                					System.err.println(e.getMessage());
			                					row11 = null;
			                				
										
			    					}
								

 



/**
 * [tFileInputDelimited_6 begin ] stop
 */
	
	/**
	 * [tFileInputDelimited_6 main ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_6";

	

 


	tos_count_tFileInputDelimited_6++;

/**
 * [tFileInputDelimited_6 main ] stop
 */
	
	/**
	 * [tFileInputDelimited_6 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_6";

	

 



/**
 * [tFileInputDelimited_6 process_data_begin ] stop
 */
// Start of branch "row11"
if(row11 != null) { 



	
	/**
	 * [tLogRow_6 main ] start
	 */

	

	
	
	currentComponent="tLogRow_6";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row11"
						
						);
					}
					
///////////////////////		
						

				
				String[] row_tLogRow_6 = new String[15];
   				
	    		if(row11.joueur1_nom != null) { //              
                 row_tLogRow_6[0]=    						    
				                String.valueOf(row11.joueur1_nom)			
					          ;	
							
	    		} //			
    			   				
	    		if(row11.joueur1_prenom != null) { //              
                 row_tLogRow_6[1]=    						    
				                String.valueOf(row11.joueur1_prenom)			
					          ;	
							
	    		} //			
    			   				
	    		if(row11.joueur1_nationalite != null) { //              
                 row_tLogRow_6[2]=    						    
				                String.valueOf(row11.joueur1_nationalite)			
					          ;	
							
	    		} //			
    			   				
	    		if(row11.joueur2_nom != null) { //              
                 row_tLogRow_6[3]=    						    
				                String.valueOf(row11.joueur2_nom)			
					          ;	
							
	    		} //			
    			   				
	    		if(row11.joueur2_prenom != null) { //              
                 row_tLogRow_6[4]=    						    
				                String.valueOf(row11.joueur2_prenom)			
					          ;	
							
	    		} //			
    			   				
	    		if(row11.joueur2_nationalite != null) { //              
                 row_tLogRow_6[5]=    						    
				                String.valueOf(row11.joueur2_nationalite)			
					          ;	
							
	    		} //			
    			   				
	    		if(row11.seed != null) { //              
                 row_tLogRow_6[6]=    						    
				                String.valueOf(row11.seed)			
					          ;	
							
	    		} //			
    			   				
	    		if(row11.round != null) { //              
                 row_tLogRow_6[7]=    						    
				                String.valueOf(row11.round)			
					          ;	
							
	    		} //			
    			   				
	    		if(row11.score != null) { //              
                 row_tLogRow_6[8]=    						    
				                String.valueOf(row11.score)			
					          ;	
							
	    		} //			
    			   				
	    		if(row11.resultat != null) { //              
                 row_tLogRow_6[9]=    						    
				                String.valueOf(row11.resultat)			
					          ;	
							
	    		} //			
    			   				
	    		if(row11.date_tournoi != null) { //              
                 row_tLogRow_6[10]=    						
								FormatterUtils.format_Date(row11.date_tournoi, "yyyy-MM-dd")
					          ;	
							
	    		} //			
    			   				
	    		if(row11.nom_tournoi != null) { //              
                 row_tLogRow_6[11]=    						    
				                String.valueOf(row11.nom_tournoi)			
					          ;	
							
	    		} //			
    			   				
	    		if(row11.lieu_tournoi != null) { //              
                 row_tLogRow_6[12]=    						    
				                String.valueOf(row11.lieu_tournoi)			
					          ;	
							
	    		} //			
    			   				
	    		if(row11.prize_money != null) { //              
                 row_tLogRow_6[13]=    						
								row11.prize_money.toPlainString()
					          ;	
							
	    		} //			
    			   				
	    		if(row11.points != null) { //              
                 row_tLogRow_6[14]=    						    
				                String.valueOf(row11.points)			
					          ;	
							
	    		} //			
    			 

				util_tLogRow_6.addRow(row_tLogRow_6);	
				nb_line_tLogRow_6++;
//////

//////                    
                    
///////////////////////    			

 
     row12 = row11;


	tos_count_tLogRow_6++;

/**
 * [tLogRow_6 main ] stop
 */
	
	/**
	 * [tLogRow_6 process_data_begin ] start
	 */

	

	
	
	currentComponent="tLogRow_6";

	

 



/**
 * [tLogRow_6 process_data_begin ] stop
 */

	
	/**
	 * [tDBOutput_6 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_6";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row12"
						
						);
					}
					



        whetherReject_tDBOutput_6 = false;
                    if(row12.joueur1_nom == null) {
pstmt_tDBOutput_6.setNull(1, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_6.setString(1, row12.joueur1_nom);
}

                    if(row12.joueur1_prenom == null) {
pstmt_tDBOutput_6.setNull(2, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_6.setString(2, row12.joueur1_prenom);
}

                    if(row12.joueur1_nationalite == null) {
pstmt_tDBOutput_6.setNull(3, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_6.setString(3, row12.joueur1_nationalite);
}

                    if(row12.joueur2_nom == null) {
pstmt_tDBOutput_6.setNull(4, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_6.setString(4, row12.joueur2_nom);
}

                    if(row12.joueur2_prenom == null) {
pstmt_tDBOutput_6.setNull(5, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_6.setString(5, row12.joueur2_prenom);
}

                    if(row12.joueur2_nationalite == null) {
pstmt_tDBOutput_6.setNull(6, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_6.setString(6, row12.joueur2_nationalite);
}

                    if(row12.seed == null) {
pstmt_tDBOutput_6.setNull(7, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_6.setInt(7, row12.seed);
}

                    if(row12.round == null) {
pstmt_tDBOutput_6.setNull(8, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_6.setString(8, row12.round);
}

                    if(row12.score == null) {
pstmt_tDBOutput_6.setNull(9, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_6.setString(9, row12.score);
}

                    if(row12.resultat == null) {
pstmt_tDBOutput_6.setNull(10, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_6.setString(10, row12.resultat);
}

                    if(row12.date_tournoi != null) {
pstmt_tDBOutput_6.setTimestamp(11, new java.sql.Timestamp(row12.date_tournoi.getTime()));
} else {
pstmt_tDBOutput_6.setNull(11, java.sql.Types.TIMESTAMP);
}

                    if(row12.nom_tournoi == null) {
pstmt_tDBOutput_6.setNull(12, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_6.setString(12, row12.nom_tournoi);
}

                    if(row12.lieu_tournoi == null) {
pstmt_tDBOutput_6.setNull(13, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_6.setString(13, row12.lieu_tournoi);
}

                    pstmt_tDBOutput_6.setBigDecimal(14, row12.prize_money);

                    if(row12.points == null) {
pstmt_tDBOutput_6.setNull(15, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_6.setInt(15, row12.points);
}

			
    		pstmt_tDBOutput_6.addBatch();
    		nb_line_tDBOutput_6++;
    		  
    		  
    		  batchSizeCounter_tDBOutput_6++;
    		  
    			if ((batchSize_tDBOutput_6 > 0) && (batchSize_tDBOutput_6 <= batchSizeCounter_tDBOutput_6)) {
                try {
						int countSum_tDBOutput_6 = 0;
						    
						for(int countEach_tDBOutput_6: pstmt_tDBOutput_6.executeBatch()) {
							countSum_tDBOutput_6 += (countEach_tDBOutput_6 < 0 ? 0 : countEach_tDBOutput_6);
						}
				    	rowsToCommitCount_tDBOutput_6 += countSum_tDBOutput_6;
				    	
				    		insertedCount_tDBOutput_6 += countSum_tDBOutput_6;
				    	
            	    	batchSizeCounter_tDBOutput_6 = 0;
                }catch (java.sql.BatchUpdateException e_tDBOutput_6){
globalMap.put("tDBOutput_6_ERROR_MESSAGE",e_tDBOutput_6.getMessage());
				    	java.sql.SQLException ne_tDBOutput_6 = e_tDBOutput_6.getNextException(),sqle_tDBOutput_6=null;
				    	String errormessage_tDBOutput_6;
						if (ne_tDBOutput_6 != null) {
							// build new exception to provide the original cause
							sqle_tDBOutput_6 = new java.sql.SQLException(e_tDBOutput_6.getMessage() + "\ncaused by: " + ne_tDBOutput_6.getMessage(), ne_tDBOutput_6.getSQLState(), ne_tDBOutput_6.getErrorCode(), ne_tDBOutput_6);
							errormessage_tDBOutput_6 = sqle_tDBOutput_6.getMessage();
						}else{
							errormessage_tDBOutput_6 = e_tDBOutput_6.getMessage();
						}
				    	
				    	int countSum_tDBOutput_6 = 0;
						for(int countEach_tDBOutput_6: e_tDBOutput_6.getUpdateCounts()) {
							countSum_tDBOutput_6 += (countEach_tDBOutput_6 < 0 ? 0 : countEach_tDBOutput_6);
						}
						rowsToCommitCount_tDBOutput_6 += countSum_tDBOutput_6;
						
				    		insertedCount_tDBOutput_6 += countSum_tDBOutput_6;
				    	
				    	System.err.println(errormessage_tDBOutput_6);
				    	
					}
    			}
    		
    		    commitCounter_tDBOutput_6++;
                if(commitEvery_tDBOutput_6 <= commitCounter_tDBOutput_6) {
                if ((batchSize_tDBOutput_6 > 0) && (batchSizeCounter_tDBOutput_6 > 0)) {
                try {
                		int countSum_tDBOutput_6 = 0;
                		    
						for(int countEach_tDBOutput_6: pstmt_tDBOutput_6.executeBatch()) {
							countSum_tDBOutput_6 += (countEach_tDBOutput_6 < 0 ? 0 : countEach_tDBOutput_6);
						}
            	    	rowsToCommitCount_tDBOutput_6 += countSum_tDBOutput_6;
            	    	
            	    		insertedCount_tDBOutput_6 += countSum_tDBOutput_6;
            	    	
                batchSizeCounter_tDBOutput_6 = 0;
               }catch (java.sql.BatchUpdateException e_tDBOutput_6){
globalMap.put("tDBOutput_6_ERROR_MESSAGE",e_tDBOutput_6.getMessage());
			    	java.sql.SQLException ne_tDBOutput_6 = e_tDBOutput_6.getNextException(),sqle_tDBOutput_6=null;
			    	String errormessage_tDBOutput_6;
					if (ne_tDBOutput_6 != null) {
						// build new exception to provide the original cause
						sqle_tDBOutput_6 = new java.sql.SQLException(e_tDBOutput_6.getMessage() + "\ncaused by: " + ne_tDBOutput_6.getMessage(), ne_tDBOutput_6.getSQLState(), ne_tDBOutput_6.getErrorCode(), ne_tDBOutput_6);
						errormessage_tDBOutput_6 = sqle_tDBOutput_6.getMessage();
					}else{
						errormessage_tDBOutput_6 = e_tDBOutput_6.getMessage();
					}
			    	
			    	int countSum_tDBOutput_6 = 0;
					for(int countEach_tDBOutput_6: e_tDBOutput_6.getUpdateCounts()) {
						countSum_tDBOutput_6 += (countEach_tDBOutput_6 < 0 ? 0 : countEach_tDBOutput_6);
					}
					rowsToCommitCount_tDBOutput_6 += countSum_tDBOutput_6;
					
			    		insertedCount_tDBOutput_6 += countSum_tDBOutput_6;
			    	
			    	System.err.println(errormessage_tDBOutput_6);
			    	
				}
            }
                    if(rowsToCommitCount_tDBOutput_6 != 0){
                    	
                    }
                    conn_tDBOutput_6.commit();
                    if(rowsToCommitCount_tDBOutput_6 != 0){
                    	
                    	rowsToCommitCount_tDBOutput_6 = 0;
                    }
                    commitCounter_tDBOutput_6=0;
                }

 


	tos_count_tDBOutput_6++;

/**
 * [tDBOutput_6 main ] stop
 */
	
	/**
	 * [tDBOutput_6 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBOutput_6";

	

 



/**
 * [tDBOutput_6 process_data_begin ] stop
 */
	
	/**
	 * [tDBOutput_6 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBOutput_6";

	

 



/**
 * [tDBOutput_6 process_data_end ] stop
 */



	
	/**
	 * [tLogRow_6 process_data_end ] start
	 */

	

	
	
	currentComponent="tLogRow_6";

	

 



/**
 * [tLogRow_6 process_data_end ] stop
 */

} // End of branch "row11"




	
	/**
	 * [tFileInputDelimited_6 process_data_end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_6";

	

 



/**
 * [tFileInputDelimited_6 process_data_end ] stop
 */
	
	/**
	 * [tFileInputDelimited_6 end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_6";

	



            }
            }finally{
                if(!((Object)("C:/Users/ASUS/Downloads/Sports/Sports/script_tournois/mai.csv") instanceof java.io.InputStream)){
                	if(fid_tFileInputDelimited_6!=null){
                		fid_tFileInputDelimited_6.close();
                	}
                }
                if(fid_tFileInputDelimited_6!=null){
                	globalMap.put("tFileInputDelimited_6_NB_LINE", fid_tFileInputDelimited_6.getRowNumber());
					
                }
			}
			  

 

ok_Hash.put("tFileInputDelimited_6", true);
end_Hash.put("tFileInputDelimited_6", System.currentTimeMillis());




/**
 * [tFileInputDelimited_6 end ] stop
 */

	
	/**
	 * [tLogRow_6 end ] start
	 */

	

	
	
	currentComponent="tLogRow_6";

	


//////

                    
                    java.io.PrintStream consoleOut_tLogRow_6 = null;
                    if (globalMap.get("tLogRow_CONSOLE")!=null)
                    {
                    	consoleOut_tLogRow_6 = (java.io.PrintStream) globalMap.get("tLogRow_CONSOLE");
                    }
                    else
                    {
                    	consoleOut_tLogRow_6 = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));
                    	globalMap.put("tLogRow_CONSOLE",consoleOut_tLogRow_6);
                    }
                    
                    consoleOut_tLogRow_6.println(util_tLogRow_6.format().toString());
                    consoleOut_tLogRow_6.flush();
//////
globalMap.put("tLogRow_6_NB_LINE",nb_line_tLogRow_6);

///////////////////////    			

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row11");
			  	}
			  	
 

ok_Hash.put("tLogRow_6", true);
end_Hash.put("tLogRow_6", System.currentTimeMillis());




/**
 * [tLogRow_6 end ] stop
 */

	
	/**
	 * [tDBOutput_6 end ] start
	 */

	

	
	
	currentComponent="tDBOutput_6";

	



	    try {
				int countSum_tDBOutput_6 = 0;
				if (pstmt_tDBOutput_6 != null && batchSizeCounter_tDBOutput_6 > 0) {
						
					for(int countEach_tDBOutput_6: pstmt_tDBOutput_6.executeBatch()) {
						countSum_tDBOutput_6 += (countEach_tDBOutput_6 < 0 ? 0 : countEach_tDBOutput_6);
					}
					rowsToCommitCount_tDBOutput_6 += countSum_tDBOutput_6;
						
				}
		    	
		    		insertedCount_tDBOutput_6 += countSum_tDBOutput_6;
		    	
	    }catch (java.sql.BatchUpdateException e_tDBOutput_6){
globalMap.put("tDBOutput_6_ERROR_MESSAGE",e_tDBOutput_6.getMessage());
	    	java.sql.SQLException ne_tDBOutput_6 = e_tDBOutput_6.getNextException(),sqle_tDBOutput_6=null;
	    	String errormessage_tDBOutput_6;
			if (ne_tDBOutput_6 != null) {
				// build new exception to provide the original cause
				sqle_tDBOutput_6 = new java.sql.SQLException(e_tDBOutput_6.getMessage() + "\ncaused by: " + ne_tDBOutput_6.getMessage(), ne_tDBOutput_6.getSQLState(), ne_tDBOutput_6.getErrorCode(), ne_tDBOutput_6);
				errormessage_tDBOutput_6 = sqle_tDBOutput_6.getMessage();
			}else{
				errormessage_tDBOutput_6 = e_tDBOutput_6.getMessage();
			}
	    	
	    	int countSum_tDBOutput_6 = 0;
			for(int countEach_tDBOutput_6: e_tDBOutput_6.getUpdateCounts()) {
				countSum_tDBOutput_6 += (countEach_tDBOutput_6 < 0 ? 0 : countEach_tDBOutput_6);
			}
			rowsToCommitCount_tDBOutput_6 += countSum_tDBOutput_6;
			
	    		insertedCount_tDBOutput_6 += countSum_tDBOutput_6;
	    	
	    	System.err.println(errormessage_tDBOutput_6);
	    	
		}
	    
        if(pstmt_tDBOutput_6 != null) {
        		
            pstmt_tDBOutput_6.close();
            resourceMap.remove("pstmt_tDBOutput_6");
        }
    resourceMap.put("statementClosed_tDBOutput_6", true);
			if(rowsToCommitCount_tDBOutput_6 != 0){
				
			}
			conn_tDBOutput_6.commit();
			if(rowsToCommitCount_tDBOutput_6 != 0){
				
				rowsToCommitCount_tDBOutput_6 = 0;
			}
			commitCounter_tDBOutput_6 = 0;
		
    	conn_tDBOutput_6 .close();
    	
    	resourceMap.put("finish_tDBOutput_6", true);
    	

	nb_line_deleted_tDBOutput_6=nb_line_deleted_tDBOutput_6+ deletedCount_tDBOutput_6;
	nb_line_update_tDBOutput_6=nb_line_update_tDBOutput_6 + updatedCount_tDBOutput_6;
	nb_line_inserted_tDBOutput_6=nb_line_inserted_tDBOutput_6 + insertedCount_tDBOutput_6;
	nb_line_rejected_tDBOutput_6=nb_line_rejected_tDBOutput_6 + rejectedCount_tDBOutput_6;
	
        globalMap.put("tDBOutput_6_NB_LINE",nb_line_tDBOutput_6);
        globalMap.put("tDBOutput_6_NB_LINE_UPDATED",nb_line_update_tDBOutput_6);
        globalMap.put("tDBOutput_6_NB_LINE_INSERTED",nb_line_inserted_tDBOutput_6);
        globalMap.put("tDBOutput_6_NB_LINE_DELETED",nb_line_deleted_tDBOutput_6);
        globalMap.put("tDBOutput_6_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_6);
    

	


				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row12");
			  	}
			  	
 

ok_Hash.put("tDBOutput_6", true);
end_Hash.put("tDBOutput_6", System.currentTimeMillis());




/**
 * [tDBOutput_6 end ] stop
 */






				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tFileInputDelimited_6 finally ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_6";

	

 



/**
 * [tFileInputDelimited_6 finally ] stop
 */

	
	/**
	 * [tLogRow_6 finally ] start
	 */

	

	
	
	currentComponent="tLogRow_6";

	

 



/**
 * [tLogRow_6 finally ] stop
 */

	
	/**
	 * [tDBOutput_6 finally ] start
	 */

	

	
	
	currentComponent="tDBOutput_6";

	



    try {
    if (resourceMap.get("statementClosed_tDBOutput_6") == null) {
                java.sql.PreparedStatement pstmtToClose_tDBOutput_6 = null;
                if ((pstmtToClose_tDBOutput_6 = (java.sql.PreparedStatement) resourceMap.remove("pstmt_tDBOutput_6")) != null) {
                    pstmtToClose_tDBOutput_6.close();
                }
    }
    } finally {
        if(resourceMap.get("finish_tDBOutput_6") == null){
            java.sql.Connection ctn_tDBOutput_6 = null;
            if((ctn_tDBOutput_6 = (java.sql.Connection)resourceMap.get("conn_tDBOutput_6")) != null){
                try {
                    ctn_tDBOutput_6.close();
                } catch (java.sql.SQLException sqlEx_tDBOutput_6) {
                    String errorMessage_tDBOutput_6 = "failed to close the connection in tDBOutput_6 :" + sqlEx_tDBOutput_6.getMessage();
                    System.err.println(errorMessage_tDBOutput_6);
                }
            }
        }
    }
 



/**
 * [tDBOutput_6 finally ] stop
 */






				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tFileInputDelimited_6_SUBPROCESS_STATE", 1);
	}
	


public static class row14Struct implements routines.system.IPersistableRow<row14Struct> {
    final static byte[] commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[0];
    static byte[] commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[0];

	
			    public String joueur1_nom;

				public String getJoueur1_nom () {
					return this.joueur1_nom;
				}
				
			    public String joueur1_prenom;

				public String getJoueur1_prenom () {
					return this.joueur1_prenom;
				}
				
			    public String joueur1_nationalite;

				public String getJoueur1_nationalite () {
					return this.joueur1_nationalite;
				}
				
			    public String joueur2_nom;

				public String getJoueur2_nom () {
					return this.joueur2_nom;
				}
				
			    public String joueur2_prenom;

				public String getJoueur2_prenom () {
					return this.joueur2_prenom;
				}
				
			    public String joueur2_nationalite;

				public String getJoueur2_nationalite () {
					return this.joueur2_nationalite;
				}
				
			    public Integer seed;

				public Integer getSeed () {
					return this.seed;
				}
				
			    public String round;

				public String getRound () {
					return this.round;
				}
				
			    public String score;

				public String getScore () {
					return this.score;
				}
				
			    public String resultat;

				public String getResultat () {
					return this.resultat;
				}
				
			    public java.util.Date date_tournoi;

				public java.util.Date getDate_tournoi () {
					return this.date_tournoi;
				}
				
			    public String nom_tournoi;

				public String getNom_tournoi () {
					return this.nom_tournoi;
				}
				
			    public String lieu_tournoi;

				public String getLieu_tournoi () {
					return this.lieu_tournoi;
				}
				
			    public BigDecimal prize_money;

				public BigDecimal getPrize_money () {
					return this.prize_money;
				}
				
			    public Integer points;

				public Integer getPoints () {
					return this.points;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length) {
				if(length < 1024 && commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length == 0) {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[1024];
				} else {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length);
			strReturn = new String(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length) {
				if(length < 1024 && commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length == 0) {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[1024];
				} else {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length);
			strReturn = new String(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep) {

        	try {

        		int length = 0;
		
					this.joueur1_nom = readString(dis);
					
					this.joueur1_prenom = readString(dis);
					
					this.joueur1_nationalite = readString(dis);
					
					this.joueur2_nom = readString(dis);
					
					this.joueur2_prenom = readString(dis);
					
					this.joueur2_nationalite = readString(dis);
					
						this.seed = readInteger(dis);
					
					this.round = readString(dis);
					
					this.score = readString(dis);
					
					this.resultat = readString(dis);
					
					this.date_tournoi = readDate(dis);
					
					this.nom_tournoi = readString(dis);
					
					this.lieu_tournoi = readString(dis);
					
						this.prize_money = (BigDecimal) dis.readObject();
					
						this.points = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep) {

        	try {

        		int length = 0;
		
					this.joueur1_nom = readString(dis);
					
					this.joueur1_prenom = readString(dis);
					
					this.joueur1_nationalite = readString(dis);
					
					this.joueur2_nom = readString(dis);
					
					this.joueur2_prenom = readString(dis);
					
					this.joueur2_nationalite = readString(dis);
					
						this.seed = readInteger(dis);
					
					this.round = readString(dis);
					
					this.score = readString(dis);
					
					this.resultat = readString(dis);
					
					this.date_tournoi = readDate(dis);
					
					this.nom_tournoi = readString(dis);
					
					this.lieu_tournoi = readString(dis);
					
						this.prize_money = (BigDecimal) dis.readObject();
					
						this.points = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.joueur1_nom,dos);
					
					// String
				
						writeString(this.joueur1_prenom,dos);
					
					// String
				
						writeString(this.joueur1_nationalite,dos);
					
					// String
				
						writeString(this.joueur2_nom,dos);
					
					// String
				
						writeString(this.joueur2_prenom,dos);
					
					// String
				
						writeString(this.joueur2_nationalite,dos);
					
					// Integer
				
						writeInteger(this.seed,dos);
					
					// String
				
						writeString(this.round,dos);
					
					// String
				
						writeString(this.score,dos);
					
					// String
				
						writeString(this.resultat,dos);
					
					// java.util.Date
				
						writeDate(this.date_tournoi,dos);
					
					// String
				
						writeString(this.nom_tournoi,dos);
					
					// String
				
						writeString(this.lieu_tournoi,dos);
					
					// BigDecimal
				
       			    	dos.writeObject(this.prize_money);
					
					// Integer
				
						writeInteger(this.points,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.joueur1_nom,dos);
					
					// String
				
						writeString(this.joueur1_prenom,dos);
					
					// String
				
						writeString(this.joueur1_nationalite,dos);
					
					// String
				
						writeString(this.joueur2_nom,dos);
					
					// String
				
						writeString(this.joueur2_prenom,dos);
					
					// String
				
						writeString(this.joueur2_nationalite,dos);
					
					// Integer
				
						writeInteger(this.seed,dos);
					
					// String
				
						writeString(this.round,dos);
					
					// String
				
						writeString(this.score,dos);
					
					// String
				
						writeString(this.resultat,dos);
					
					// java.util.Date
				
						writeDate(this.date_tournoi,dos);
					
					// String
				
						writeString(this.nom_tournoi,dos);
					
					// String
				
						writeString(this.lieu_tournoi,dos);
					
					// BigDecimal
				
       			    	dos.writeObject(this.prize_money);
					
					// Integer
				
						writeInteger(this.points,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("joueur1_nom="+joueur1_nom);
		sb.append(",joueur1_prenom="+joueur1_prenom);
		sb.append(",joueur1_nationalite="+joueur1_nationalite);
		sb.append(",joueur2_nom="+joueur2_nom);
		sb.append(",joueur2_prenom="+joueur2_prenom);
		sb.append(",joueur2_nationalite="+joueur2_nationalite);
		sb.append(",seed="+String.valueOf(seed));
		sb.append(",round="+round);
		sb.append(",score="+score);
		sb.append(",resultat="+resultat);
		sb.append(",date_tournoi="+String.valueOf(date_tournoi));
		sb.append(",nom_tournoi="+nom_tournoi);
		sb.append(",lieu_tournoi="+lieu_tournoi);
		sb.append(",prize_money="+String.valueOf(prize_money));
		sb.append(",points="+String.valueOf(points));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row14Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class row13Struct implements routines.system.IPersistableRow<row13Struct> {
    final static byte[] commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[0];
    static byte[] commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[0];

	
			    public String joueur1_nom;

				public String getJoueur1_nom () {
					return this.joueur1_nom;
				}
				
			    public String joueur1_prenom;

				public String getJoueur1_prenom () {
					return this.joueur1_prenom;
				}
				
			    public String joueur1_nationalite;

				public String getJoueur1_nationalite () {
					return this.joueur1_nationalite;
				}
				
			    public String joueur2_nom;

				public String getJoueur2_nom () {
					return this.joueur2_nom;
				}
				
			    public String joueur2_prenom;

				public String getJoueur2_prenom () {
					return this.joueur2_prenom;
				}
				
			    public String joueur2_nationalite;

				public String getJoueur2_nationalite () {
					return this.joueur2_nationalite;
				}
				
			    public Integer seed;

				public Integer getSeed () {
					return this.seed;
				}
				
			    public String round;

				public String getRound () {
					return this.round;
				}
				
			    public String score;

				public String getScore () {
					return this.score;
				}
				
			    public String resultat;

				public String getResultat () {
					return this.resultat;
				}
				
			    public java.util.Date date_tournoi;

				public java.util.Date getDate_tournoi () {
					return this.date_tournoi;
				}
				
			    public String nom_tournoi;

				public String getNom_tournoi () {
					return this.nom_tournoi;
				}
				
			    public String lieu_tournoi;

				public String getLieu_tournoi () {
					return this.lieu_tournoi;
				}
				
			    public BigDecimal prize_money;

				public BigDecimal getPrize_money () {
					return this.prize_money;
				}
				
			    public Integer points;

				public Integer getPoints () {
					return this.points;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length) {
				if(length < 1024 && commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length == 0) {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[1024];
				} else {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length);
			strReturn = new String(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length) {
				if(length < 1024 && commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length == 0) {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[1024];
				} else {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length);
			strReturn = new String(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep) {

        	try {

        		int length = 0;
		
					this.joueur1_nom = readString(dis);
					
					this.joueur1_prenom = readString(dis);
					
					this.joueur1_nationalite = readString(dis);
					
					this.joueur2_nom = readString(dis);
					
					this.joueur2_prenom = readString(dis);
					
					this.joueur2_nationalite = readString(dis);
					
						this.seed = readInteger(dis);
					
					this.round = readString(dis);
					
					this.score = readString(dis);
					
					this.resultat = readString(dis);
					
					this.date_tournoi = readDate(dis);
					
					this.nom_tournoi = readString(dis);
					
					this.lieu_tournoi = readString(dis);
					
						this.prize_money = (BigDecimal) dis.readObject();
					
						this.points = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep) {

        	try {

        		int length = 0;
		
					this.joueur1_nom = readString(dis);
					
					this.joueur1_prenom = readString(dis);
					
					this.joueur1_nationalite = readString(dis);
					
					this.joueur2_nom = readString(dis);
					
					this.joueur2_prenom = readString(dis);
					
					this.joueur2_nationalite = readString(dis);
					
						this.seed = readInteger(dis);
					
					this.round = readString(dis);
					
					this.score = readString(dis);
					
					this.resultat = readString(dis);
					
					this.date_tournoi = readDate(dis);
					
					this.nom_tournoi = readString(dis);
					
					this.lieu_tournoi = readString(dis);
					
						this.prize_money = (BigDecimal) dis.readObject();
					
						this.points = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.joueur1_nom,dos);
					
					// String
				
						writeString(this.joueur1_prenom,dos);
					
					// String
				
						writeString(this.joueur1_nationalite,dos);
					
					// String
				
						writeString(this.joueur2_nom,dos);
					
					// String
				
						writeString(this.joueur2_prenom,dos);
					
					// String
				
						writeString(this.joueur2_nationalite,dos);
					
					// Integer
				
						writeInteger(this.seed,dos);
					
					// String
				
						writeString(this.round,dos);
					
					// String
				
						writeString(this.score,dos);
					
					// String
				
						writeString(this.resultat,dos);
					
					// java.util.Date
				
						writeDate(this.date_tournoi,dos);
					
					// String
				
						writeString(this.nom_tournoi,dos);
					
					// String
				
						writeString(this.lieu_tournoi,dos);
					
					// BigDecimal
				
       			    	dos.writeObject(this.prize_money);
					
					// Integer
				
						writeInteger(this.points,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.joueur1_nom,dos);
					
					// String
				
						writeString(this.joueur1_prenom,dos);
					
					// String
				
						writeString(this.joueur1_nationalite,dos);
					
					// String
				
						writeString(this.joueur2_nom,dos);
					
					// String
				
						writeString(this.joueur2_prenom,dos);
					
					// String
				
						writeString(this.joueur2_nationalite,dos);
					
					// Integer
				
						writeInteger(this.seed,dos);
					
					// String
				
						writeString(this.round,dos);
					
					// String
				
						writeString(this.score,dos);
					
					// String
				
						writeString(this.resultat,dos);
					
					// java.util.Date
				
						writeDate(this.date_tournoi,dos);
					
					// String
				
						writeString(this.nom_tournoi,dos);
					
					// String
				
						writeString(this.lieu_tournoi,dos);
					
					// BigDecimal
				
       			    	dos.writeObject(this.prize_money);
					
					// Integer
				
						writeInteger(this.points,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("joueur1_nom="+joueur1_nom);
		sb.append(",joueur1_prenom="+joueur1_prenom);
		sb.append(",joueur1_nationalite="+joueur1_nationalite);
		sb.append(",joueur2_nom="+joueur2_nom);
		sb.append(",joueur2_prenom="+joueur2_prenom);
		sb.append(",joueur2_nationalite="+joueur2_nationalite);
		sb.append(",seed="+String.valueOf(seed));
		sb.append(",round="+round);
		sb.append(",score="+score);
		sb.append(",resultat="+resultat);
		sb.append(",date_tournoi="+String.valueOf(date_tournoi));
		sb.append(",nom_tournoi="+nom_tournoi);
		sb.append(",lieu_tournoi="+lieu_tournoi);
		sb.append(",prize_money="+String.valueOf(prize_money));
		sb.append(",points="+String.valueOf(points));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row13Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tFileInputDelimited_7Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tFileInputDelimited_7_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row13Struct row13 = new row13Struct();
row13Struct row14 = row13;





	
	/**
	 * [tDBOutput_7 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBOutput_7", false);
		start_Hash.put("tDBOutput_7", System.currentTimeMillis());
		
	
	currentComponent="tDBOutput_7";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row14");
					}
				
		int tos_count_tDBOutput_7 = 0;
		





String dbschema_tDBOutput_7 = null;
	dbschema_tDBOutput_7 = "sa";
	

String tableName_tDBOutput_7 = null;
if(dbschema_tDBOutput_7 == null || dbschema_tDBOutput_7.trim().length() == 0) {
	tableName_tDBOutput_7 = ("sa_tournament_mar");
} else {
	tableName_tDBOutput_7 = dbschema_tDBOutput_7 + "\".\"" + ("sa_tournament_mar");
}


int nb_line_tDBOutput_7 = 0;
int nb_line_update_tDBOutput_7 = 0;
int nb_line_inserted_tDBOutput_7 = 0;
int nb_line_deleted_tDBOutput_7 = 0;
int nb_line_rejected_tDBOutput_7 = 0;

int deletedCount_tDBOutput_7=0;
int updatedCount_tDBOutput_7=0;
int insertedCount_tDBOutput_7=0;
int rowsToCommitCount_tDBOutput_7=0;
int rejectedCount_tDBOutput_7=0;

boolean whetherReject_tDBOutput_7 = false;

java.sql.Connection conn_tDBOutput_7 = null;
String dbUser_tDBOutput_7 = null;

	
    java.lang.Class.forName("org.postgresql.Driver");
    
        String url_tDBOutput_7 = "jdbc:postgresql://"+"localhost"+":"+"5432"+"/"+"padel_bi_SA";
    dbUser_tDBOutput_7 = "postgres";
 
	final String decryptedPassword_tDBOutput_7 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:g0ISNCZOz5e3u7jcGQGg0jPBnFj45+FCQF22FwqdC9ARvaJ6LA==");

    String dbPwd_tDBOutput_7 = decryptedPassword_tDBOutput_7;

    conn_tDBOutput_7 = java.sql.DriverManager.getConnection(url_tDBOutput_7,dbUser_tDBOutput_7,dbPwd_tDBOutput_7);
	
	resourceMap.put("conn_tDBOutput_7", conn_tDBOutput_7);
        conn_tDBOutput_7.setAutoCommit(false);
        int commitEvery_tDBOutput_7 = 10000;
        int commitCounter_tDBOutput_7 = 0;


   int batchSize_tDBOutput_7 = 10000;
   int batchSizeCounter_tDBOutput_7=0;

int count_tDBOutput_7=0;
	    String insert_tDBOutput_7 = "INSERT INTO \"" + tableName_tDBOutput_7 + "\" (\"joueur1_nom\",\"joueur1_prenom\",\"joueur1_nationalite\",\"joueur2_nom\",\"joueur2_prenom\",\"joueur2_nationalite\",\"seed\",\"round\",\"score\",\"resultat\",\"date_tournoi\",\"nom_tournoi\",\"lieu_tournoi\",\"prize_money\",\"points\") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	    
	    java.sql.PreparedStatement pstmt_tDBOutput_7 = conn_tDBOutput_7.prepareStatement(insert_tDBOutput_7);
	    resourceMap.put("pstmt_tDBOutput_7", pstmt_tDBOutput_7);
	    

 



/**
 * [tDBOutput_7 begin ] stop
 */



	
	/**
	 * [tLogRow_7 begin ] start
	 */

	

	
		
		ok_Hash.put("tLogRow_7", false);
		start_Hash.put("tLogRow_7", System.currentTimeMillis());
		
	
	currentComponent="tLogRow_7";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row13");
					}
				
		int tos_count_tLogRow_7 = 0;
		

	///////////////////////
	
         class Util_tLogRow_7 {

        String[] des_top = { ".", ".", "-", "+" };

        String[] des_head = { "|=", "=|", "-", "+" };

        String[] des_bottom = { "'", "'", "-", "+" };

        String name="";

        java.util.List<String[]> list = new java.util.ArrayList<String[]>();

        int[] colLengths = new int[15];

        public void addRow(String[] row) {

            for (int i = 0; i < 15; i++) {
                if (row[i]!=null) {
                  colLengths[i] = Math.max(colLengths[i], row[i].length());
                }
            }
            list.add(row);
        }

        public void setTableName(String name) {

            this.name = name;
        }

            public StringBuilder format() {
            
                StringBuilder sb = new StringBuilder();
  
            
                    sb.append(print(des_top));
    
                    int totals = 0;
                    for (int i = 0; i < colLengths.length; i++) {
                        totals = totals + colLengths[i];
                    }
    
                    // name
                    sb.append("|");
                    int k = 0;
                    for (k = 0; k < (totals + 14 - name.length()) / 2; k++) {
                        sb.append(' ');
                    }
                    sb.append(name);
                    for (int i = 0; i < totals + 14 - name.length() - k; i++) {
                        sb.append(' ');
                    }
                    sb.append("|\n");

                    // head and rows
                    sb.append(print(des_head));
                    for (int i = 0; i < list.size(); i++) {
    
                        String[] row = list.get(i);
    
                        java.util.Formatter formatter = new java.util.Formatter(new StringBuilder());
                        
                        StringBuilder sbformat = new StringBuilder();                                             
        			        sbformat.append("|%1$-");
        			        sbformat.append(colLengths[0]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%2$-");
        			        sbformat.append(colLengths[1]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%3$-");
        			        sbformat.append(colLengths[2]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%4$-");
        			        sbformat.append(colLengths[3]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%5$-");
        			        sbformat.append(colLengths[4]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%6$-");
        			        sbformat.append(colLengths[5]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%7$-");
        			        sbformat.append(colLengths[6]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%8$-");
        			        sbformat.append(colLengths[7]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%9$-");
        			        sbformat.append(colLengths[8]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%10$-");
        			        sbformat.append(colLengths[9]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%11$-");
        			        sbformat.append(colLengths[10]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%12$-");
        			        sbformat.append(colLengths[11]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%13$-");
        			        sbformat.append(colLengths[12]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%14$-");
        			        sbformat.append(colLengths[13]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%15$-");
        			        sbformat.append(colLengths[14]);
        			        sbformat.append("s");
        			                      
                        sbformat.append("|\n");                    
       
                        formatter.format(sbformat.toString(), (Object[])row);	
                                
                        sb.append(formatter.toString());
                        if (i == 0)
                            sb.append(print(des_head)); // print the head
                    }
    
                    // end
                    sb.append(print(des_bottom));
                    return sb;
                }
            

            private StringBuilder print(String[] fillChars) {
                StringBuilder sb = new StringBuilder();
                //first column
                sb.append(fillChars[0]);                
                    for (int i = 0; i < colLengths[0] - fillChars[0].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);	                

                    for (int i = 0; i < colLengths[1] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[2] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[3] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[4] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[5] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[6] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[7] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[8] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[9] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[10] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[11] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[12] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[13] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                
                    //last column
                    for (int i = 0; i < colLengths[14] - fillChars[1].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }         
                sb.append(fillChars[1]);
                sb.append("\n");               
                return sb;
            }
            
            public boolean isTableEmpty(){
            	if (list.size() > 1)
            		return false;
            	return true;
            }
        }
        Util_tLogRow_7 util_tLogRow_7 = new Util_tLogRow_7();
        util_tLogRow_7.setTableName("tLogRow_7");
        util_tLogRow_7.addRow(new String[]{"joueur1_nom","joueur1_prenom","joueur1_nationalite","joueur2_nom","joueur2_prenom","joueur2_nationalite","seed","round","score","resultat","date_tournoi","nom_tournoi","lieu_tournoi","prize_money","points",});        
 		StringBuilder strBuffer_tLogRow_7 = null;
		int nb_line_tLogRow_7 = 0;
///////////////////////    			



 



/**
 * [tLogRow_7 begin ] stop
 */



	
	/**
	 * [tFileInputDelimited_7 begin ] start
	 */

	

	
		
		ok_Hash.put("tFileInputDelimited_7", false);
		start_Hash.put("tFileInputDelimited_7", System.currentTimeMillis());
		
	
	currentComponent="tFileInputDelimited_7";

	
		int tos_count_tFileInputDelimited_7 = 0;
		
	
	
	
 
	
	
	final routines.system.RowState rowstate_tFileInputDelimited_7 = new routines.system.RowState();
	
	
				int nb_line_tFileInputDelimited_7 = 0;
				org.talend.fileprocess.FileInputDelimited fid_tFileInputDelimited_7 = null;
				int limit_tFileInputDelimited_7 = -1;
				try{
					
						Object filename_tFileInputDelimited_7 = "C:/Users/ASUS/Downloads/Sports/Sports/script_tournois/mar.csv";
						if(filename_tFileInputDelimited_7 instanceof java.io.InputStream){
							
			int footer_value_tFileInputDelimited_7 = 0, random_value_tFileInputDelimited_7 = -1;
			if(footer_value_tFileInputDelimited_7 >0 || random_value_tFileInputDelimited_7 > 0){
				throw new java.lang.Exception("When the input source is a stream,footer and random shouldn't be bigger than 0.");				
			}
		
						}
						try {
							fid_tFileInputDelimited_7 = new org.talend.fileprocess.FileInputDelimited("C:/Users/ASUS/Downloads/Sports/Sports/script_tournois/mar.csv", "ISO-8859-15",";","\n",true,1,0,
									limit_tFileInputDelimited_7
								,-1, false);
						} catch(java.lang.Exception e) {
globalMap.put("tFileInputDelimited_7_ERROR_MESSAGE",e.getMessage());
							
								
								System.err.println(e.getMessage());
							
						}
					
				    
					while (fid_tFileInputDelimited_7!=null && fid_tFileInputDelimited_7.nextRecord()) {
						rowstate_tFileInputDelimited_7.reset();
						
			    						row13 = null;			
												
									boolean whetherReject_tFileInputDelimited_7 = false;
									row13 = new row13Struct();
									try {
										
				int columnIndexWithD_tFileInputDelimited_7 = 0;
				
					String temp = ""; 
				
					columnIndexWithD_tFileInputDelimited_7 = 0;
					
							row13.joueur1_nom = fid_tFileInputDelimited_7.get(columnIndexWithD_tFileInputDelimited_7);
						
				
					columnIndexWithD_tFileInputDelimited_7 = 1;
					
							row13.joueur1_prenom = fid_tFileInputDelimited_7.get(columnIndexWithD_tFileInputDelimited_7);
						
				
					columnIndexWithD_tFileInputDelimited_7 = 2;
					
							row13.joueur1_nationalite = fid_tFileInputDelimited_7.get(columnIndexWithD_tFileInputDelimited_7);
						
				
					columnIndexWithD_tFileInputDelimited_7 = 3;
					
							row13.joueur2_nom = fid_tFileInputDelimited_7.get(columnIndexWithD_tFileInputDelimited_7);
						
				
					columnIndexWithD_tFileInputDelimited_7 = 4;
					
							row13.joueur2_prenom = fid_tFileInputDelimited_7.get(columnIndexWithD_tFileInputDelimited_7);
						
				
					columnIndexWithD_tFileInputDelimited_7 = 5;
					
							row13.joueur2_nationalite = fid_tFileInputDelimited_7.get(columnIndexWithD_tFileInputDelimited_7);
						
				
					columnIndexWithD_tFileInputDelimited_7 = 6;
					
						temp = fid_tFileInputDelimited_7.get(columnIndexWithD_tFileInputDelimited_7);
						if(temp.length() > 0) {
							
								try {
								
    								row13.seed = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_7) {
globalMap.put("tFileInputDelimited_7_ERROR_MESSAGE",ex_tFileInputDelimited_7.getMessage());
									rowstate_tFileInputDelimited_7.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"seed", "row13", temp, ex_tFileInputDelimited_7), ex_tFileInputDelimited_7));
								}
    							
						} else {						
							
								
									row13.seed = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_7 = 7;
					
							row13.round = fid_tFileInputDelimited_7.get(columnIndexWithD_tFileInputDelimited_7);
						
				
					columnIndexWithD_tFileInputDelimited_7 = 8;
					
							row13.score = fid_tFileInputDelimited_7.get(columnIndexWithD_tFileInputDelimited_7);
						
				
					columnIndexWithD_tFileInputDelimited_7 = 9;
					
							row13.resultat = fid_tFileInputDelimited_7.get(columnIndexWithD_tFileInputDelimited_7);
						
				
					columnIndexWithD_tFileInputDelimited_7 = 10;
					
						temp = fid_tFileInputDelimited_7.get(columnIndexWithD_tFileInputDelimited_7);
						if(temp.length() > 0) {
							
								try {
								
    									row13.date_tournoi = ParserUtils.parseTo_Date(temp, "yyyy-MM-dd");
    								
    							} catch(java.lang.Exception ex_tFileInputDelimited_7) {
globalMap.put("tFileInputDelimited_7_ERROR_MESSAGE",ex_tFileInputDelimited_7.getMessage());
									rowstate_tFileInputDelimited_7.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"date_tournoi", "row13", temp, ex_tFileInputDelimited_7), ex_tFileInputDelimited_7));
								}
    							
						} else {						
							
								
									row13.date_tournoi = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_7 = 11;
					
							row13.nom_tournoi = fid_tFileInputDelimited_7.get(columnIndexWithD_tFileInputDelimited_7);
						
				
					columnIndexWithD_tFileInputDelimited_7 = 12;
					
							row13.lieu_tournoi = fid_tFileInputDelimited_7.get(columnIndexWithD_tFileInputDelimited_7);
						
				
					columnIndexWithD_tFileInputDelimited_7 = 13;
					
						temp = fid_tFileInputDelimited_7.get(columnIndexWithD_tFileInputDelimited_7);
						if(temp.length() > 0) {
							
								try {
								
    								row13.prize_money = ParserUtils.parseTo_BigDecimal(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_7) {
globalMap.put("tFileInputDelimited_7_ERROR_MESSAGE",ex_tFileInputDelimited_7.getMessage());
									rowstate_tFileInputDelimited_7.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"prize_money", "row13", temp, ex_tFileInputDelimited_7), ex_tFileInputDelimited_7));
								}
    							
						} else {						
							
								
									row13.prize_money = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_7 = 14;
					
						temp = fid_tFileInputDelimited_7.get(columnIndexWithD_tFileInputDelimited_7);
						if(temp.length() > 0) {
							
								try {
								
    								row13.points = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_7) {
globalMap.put("tFileInputDelimited_7_ERROR_MESSAGE",ex_tFileInputDelimited_7.getMessage());
									rowstate_tFileInputDelimited_7.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"points", "row13", temp, ex_tFileInputDelimited_7), ex_tFileInputDelimited_7));
								}
    							
						} else {						
							
								
									row13.points = null;
								
							
						}
					
				
				
										
										if(rowstate_tFileInputDelimited_7.getException()!=null) {
											throw rowstate_tFileInputDelimited_7.getException();
										}
										
										
							
			    					} catch (java.lang.Exception e) {
globalMap.put("tFileInputDelimited_7_ERROR_MESSAGE",e.getMessage());
			        					whetherReject_tFileInputDelimited_7 = true;
			        					
			                					System.err.println(e.getMessage());
			                					row13 = null;
			                				
										
			    					}
								

 



/**
 * [tFileInputDelimited_7 begin ] stop
 */
	
	/**
	 * [tFileInputDelimited_7 main ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_7";

	

 


	tos_count_tFileInputDelimited_7++;

/**
 * [tFileInputDelimited_7 main ] stop
 */
	
	/**
	 * [tFileInputDelimited_7 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_7";

	

 



/**
 * [tFileInputDelimited_7 process_data_begin ] stop
 */
// Start of branch "row13"
if(row13 != null) { 



	
	/**
	 * [tLogRow_7 main ] start
	 */

	

	
	
	currentComponent="tLogRow_7";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row13"
						
						);
					}
					
///////////////////////		
						

				
				String[] row_tLogRow_7 = new String[15];
   				
	    		if(row13.joueur1_nom != null) { //              
                 row_tLogRow_7[0]=    						    
				                String.valueOf(row13.joueur1_nom)			
					          ;	
							
	    		} //			
    			   				
	    		if(row13.joueur1_prenom != null) { //              
                 row_tLogRow_7[1]=    						    
				                String.valueOf(row13.joueur1_prenom)			
					          ;	
							
	    		} //			
    			   				
	    		if(row13.joueur1_nationalite != null) { //              
                 row_tLogRow_7[2]=    						    
				                String.valueOf(row13.joueur1_nationalite)			
					          ;	
							
	    		} //			
    			   				
	    		if(row13.joueur2_nom != null) { //              
                 row_tLogRow_7[3]=    						    
				                String.valueOf(row13.joueur2_nom)			
					          ;	
							
	    		} //			
    			   				
	    		if(row13.joueur2_prenom != null) { //              
                 row_tLogRow_7[4]=    						    
				                String.valueOf(row13.joueur2_prenom)			
					          ;	
							
	    		} //			
    			   				
	    		if(row13.joueur2_nationalite != null) { //              
                 row_tLogRow_7[5]=    						    
				                String.valueOf(row13.joueur2_nationalite)			
					          ;	
							
	    		} //			
    			   				
	    		if(row13.seed != null) { //              
                 row_tLogRow_7[6]=    						    
				                String.valueOf(row13.seed)			
					          ;	
							
	    		} //			
    			   				
	    		if(row13.round != null) { //              
                 row_tLogRow_7[7]=    						    
				                String.valueOf(row13.round)			
					          ;	
							
	    		} //			
    			   				
	    		if(row13.score != null) { //              
                 row_tLogRow_7[8]=    						    
				                String.valueOf(row13.score)			
					          ;	
							
	    		} //			
    			   				
	    		if(row13.resultat != null) { //              
                 row_tLogRow_7[9]=    						    
				                String.valueOf(row13.resultat)			
					          ;	
							
	    		} //			
    			   				
	    		if(row13.date_tournoi != null) { //              
                 row_tLogRow_7[10]=    						
								FormatterUtils.format_Date(row13.date_tournoi, "yyyy-MM-dd")
					          ;	
							
	    		} //			
    			   				
	    		if(row13.nom_tournoi != null) { //              
                 row_tLogRow_7[11]=    						    
				                String.valueOf(row13.nom_tournoi)			
					          ;	
							
	    		} //			
    			   				
	    		if(row13.lieu_tournoi != null) { //              
                 row_tLogRow_7[12]=    						    
				                String.valueOf(row13.lieu_tournoi)			
					          ;	
							
	    		} //			
    			   				
	    		if(row13.prize_money != null) { //              
                 row_tLogRow_7[13]=    						
								row13.prize_money.toPlainString()
					          ;	
							
	    		} //			
    			   				
	    		if(row13.points != null) { //              
                 row_tLogRow_7[14]=    						    
				                String.valueOf(row13.points)			
					          ;	
							
	    		} //			
    			 

				util_tLogRow_7.addRow(row_tLogRow_7);	
				nb_line_tLogRow_7++;
//////

//////                    
                    
///////////////////////    			

 
     row14 = row13;


	tos_count_tLogRow_7++;

/**
 * [tLogRow_7 main ] stop
 */
	
	/**
	 * [tLogRow_7 process_data_begin ] start
	 */

	

	
	
	currentComponent="tLogRow_7";

	

 



/**
 * [tLogRow_7 process_data_begin ] stop
 */

	
	/**
	 * [tDBOutput_7 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_7";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row14"
						
						);
					}
					



        whetherReject_tDBOutput_7 = false;
                    if(row14.joueur1_nom == null) {
pstmt_tDBOutput_7.setNull(1, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_7.setString(1, row14.joueur1_nom);
}

                    if(row14.joueur1_prenom == null) {
pstmt_tDBOutput_7.setNull(2, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_7.setString(2, row14.joueur1_prenom);
}

                    if(row14.joueur1_nationalite == null) {
pstmt_tDBOutput_7.setNull(3, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_7.setString(3, row14.joueur1_nationalite);
}

                    if(row14.joueur2_nom == null) {
pstmt_tDBOutput_7.setNull(4, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_7.setString(4, row14.joueur2_nom);
}

                    if(row14.joueur2_prenom == null) {
pstmt_tDBOutput_7.setNull(5, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_7.setString(5, row14.joueur2_prenom);
}

                    if(row14.joueur2_nationalite == null) {
pstmt_tDBOutput_7.setNull(6, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_7.setString(6, row14.joueur2_nationalite);
}

                    if(row14.seed == null) {
pstmt_tDBOutput_7.setNull(7, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_7.setInt(7, row14.seed);
}

                    if(row14.round == null) {
pstmt_tDBOutput_7.setNull(8, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_7.setString(8, row14.round);
}

                    if(row14.score == null) {
pstmt_tDBOutput_7.setNull(9, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_7.setString(9, row14.score);
}

                    if(row14.resultat == null) {
pstmt_tDBOutput_7.setNull(10, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_7.setString(10, row14.resultat);
}

                    if(row14.date_tournoi != null) {
pstmt_tDBOutput_7.setTimestamp(11, new java.sql.Timestamp(row14.date_tournoi.getTime()));
} else {
pstmt_tDBOutput_7.setNull(11, java.sql.Types.TIMESTAMP);
}

                    if(row14.nom_tournoi == null) {
pstmt_tDBOutput_7.setNull(12, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_7.setString(12, row14.nom_tournoi);
}

                    if(row14.lieu_tournoi == null) {
pstmt_tDBOutput_7.setNull(13, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_7.setString(13, row14.lieu_tournoi);
}

                    pstmt_tDBOutput_7.setBigDecimal(14, row14.prize_money);

                    if(row14.points == null) {
pstmt_tDBOutput_7.setNull(15, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_7.setInt(15, row14.points);
}

			
    		pstmt_tDBOutput_7.addBatch();
    		nb_line_tDBOutput_7++;
    		  
    		  
    		  batchSizeCounter_tDBOutput_7++;
    		  
    			if ((batchSize_tDBOutput_7 > 0) && (batchSize_tDBOutput_7 <= batchSizeCounter_tDBOutput_7)) {
                try {
						int countSum_tDBOutput_7 = 0;
						    
						for(int countEach_tDBOutput_7: pstmt_tDBOutput_7.executeBatch()) {
							countSum_tDBOutput_7 += (countEach_tDBOutput_7 < 0 ? 0 : countEach_tDBOutput_7);
						}
				    	rowsToCommitCount_tDBOutput_7 += countSum_tDBOutput_7;
				    	
				    		insertedCount_tDBOutput_7 += countSum_tDBOutput_7;
				    	
            	    	batchSizeCounter_tDBOutput_7 = 0;
                }catch (java.sql.BatchUpdateException e_tDBOutput_7){
globalMap.put("tDBOutput_7_ERROR_MESSAGE",e_tDBOutput_7.getMessage());
				    	java.sql.SQLException ne_tDBOutput_7 = e_tDBOutput_7.getNextException(),sqle_tDBOutput_7=null;
				    	String errormessage_tDBOutput_7;
						if (ne_tDBOutput_7 != null) {
							// build new exception to provide the original cause
							sqle_tDBOutput_7 = new java.sql.SQLException(e_tDBOutput_7.getMessage() + "\ncaused by: " + ne_tDBOutput_7.getMessage(), ne_tDBOutput_7.getSQLState(), ne_tDBOutput_7.getErrorCode(), ne_tDBOutput_7);
							errormessage_tDBOutput_7 = sqle_tDBOutput_7.getMessage();
						}else{
							errormessage_tDBOutput_7 = e_tDBOutput_7.getMessage();
						}
				    	
				    	int countSum_tDBOutput_7 = 0;
						for(int countEach_tDBOutput_7: e_tDBOutput_7.getUpdateCounts()) {
							countSum_tDBOutput_7 += (countEach_tDBOutput_7 < 0 ? 0 : countEach_tDBOutput_7);
						}
						rowsToCommitCount_tDBOutput_7 += countSum_tDBOutput_7;
						
				    		insertedCount_tDBOutput_7 += countSum_tDBOutput_7;
				    	
				    	System.err.println(errormessage_tDBOutput_7);
				    	
					}
    			}
    		
    		    commitCounter_tDBOutput_7++;
                if(commitEvery_tDBOutput_7 <= commitCounter_tDBOutput_7) {
                if ((batchSize_tDBOutput_7 > 0) && (batchSizeCounter_tDBOutput_7 > 0)) {
                try {
                		int countSum_tDBOutput_7 = 0;
                		    
						for(int countEach_tDBOutput_7: pstmt_tDBOutput_7.executeBatch()) {
							countSum_tDBOutput_7 += (countEach_tDBOutput_7 < 0 ? 0 : countEach_tDBOutput_7);
						}
            	    	rowsToCommitCount_tDBOutput_7 += countSum_tDBOutput_7;
            	    	
            	    		insertedCount_tDBOutput_7 += countSum_tDBOutput_7;
            	    	
                batchSizeCounter_tDBOutput_7 = 0;
               }catch (java.sql.BatchUpdateException e_tDBOutput_7){
globalMap.put("tDBOutput_7_ERROR_MESSAGE",e_tDBOutput_7.getMessage());
			    	java.sql.SQLException ne_tDBOutput_7 = e_tDBOutput_7.getNextException(),sqle_tDBOutput_7=null;
			    	String errormessage_tDBOutput_7;
					if (ne_tDBOutput_7 != null) {
						// build new exception to provide the original cause
						sqle_tDBOutput_7 = new java.sql.SQLException(e_tDBOutput_7.getMessage() + "\ncaused by: " + ne_tDBOutput_7.getMessage(), ne_tDBOutput_7.getSQLState(), ne_tDBOutput_7.getErrorCode(), ne_tDBOutput_7);
						errormessage_tDBOutput_7 = sqle_tDBOutput_7.getMessage();
					}else{
						errormessage_tDBOutput_7 = e_tDBOutput_7.getMessage();
					}
			    	
			    	int countSum_tDBOutput_7 = 0;
					for(int countEach_tDBOutput_7: e_tDBOutput_7.getUpdateCounts()) {
						countSum_tDBOutput_7 += (countEach_tDBOutput_7 < 0 ? 0 : countEach_tDBOutput_7);
					}
					rowsToCommitCount_tDBOutput_7 += countSum_tDBOutput_7;
					
			    		insertedCount_tDBOutput_7 += countSum_tDBOutput_7;
			    	
			    	System.err.println(errormessage_tDBOutput_7);
			    	
				}
            }
                    if(rowsToCommitCount_tDBOutput_7 != 0){
                    	
                    }
                    conn_tDBOutput_7.commit();
                    if(rowsToCommitCount_tDBOutput_7 != 0){
                    	
                    	rowsToCommitCount_tDBOutput_7 = 0;
                    }
                    commitCounter_tDBOutput_7=0;
                }

 


	tos_count_tDBOutput_7++;

/**
 * [tDBOutput_7 main ] stop
 */
	
	/**
	 * [tDBOutput_7 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBOutput_7";

	

 



/**
 * [tDBOutput_7 process_data_begin ] stop
 */
	
	/**
	 * [tDBOutput_7 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBOutput_7";

	

 



/**
 * [tDBOutput_7 process_data_end ] stop
 */



	
	/**
	 * [tLogRow_7 process_data_end ] start
	 */

	

	
	
	currentComponent="tLogRow_7";

	

 



/**
 * [tLogRow_7 process_data_end ] stop
 */

} // End of branch "row13"




	
	/**
	 * [tFileInputDelimited_7 process_data_end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_7";

	

 



/**
 * [tFileInputDelimited_7 process_data_end ] stop
 */
	
	/**
	 * [tFileInputDelimited_7 end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_7";

	



            }
            }finally{
                if(!((Object)("C:/Users/ASUS/Downloads/Sports/Sports/script_tournois/mar.csv") instanceof java.io.InputStream)){
                	if(fid_tFileInputDelimited_7!=null){
                		fid_tFileInputDelimited_7.close();
                	}
                }
                if(fid_tFileInputDelimited_7!=null){
                	globalMap.put("tFileInputDelimited_7_NB_LINE", fid_tFileInputDelimited_7.getRowNumber());
					
                }
			}
			  

 

ok_Hash.put("tFileInputDelimited_7", true);
end_Hash.put("tFileInputDelimited_7", System.currentTimeMillis());




/**
 * [tFileInputDelimited_7 end ] stop
 */

	
	/**
	 * [tLogRow_7 end ] start
	 */

	

	
	
	currentComponent="tLogRow_7";

	


//////

                    
                    java.io.PrintStream consoleOut_tLogRow_7 = null;
                    if (globalMap.get("tLogRow_CONSOLE")!=null)
                    {
                    	consoleOut_tLogRow_7 = (java.io.PrintStream) globalMap.get("tLogRow_CONSOLE");
                    }
                    else
                    {
                    	consoleOut_tLogRow_7 = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));
                    	globalMap.put("tLogRow_CONSOLE",consoleOut_tLogRow_7);
                    }
                    
                    consoleOut_tLogRow_7.println(util_tLogRow_7.format().toString());
                    consoleOut_tLogRow_7.flush();
//////
globalMap.put("tLogRow_7_NB_LINE",nb_line_tLogRow_7);

///////////////////////    			

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row13");
			  	}
			  	
 

ok_Hash.put("tLogRow_7", true);
end_Hash.put("tLogRow_7", System.currentTimeMillis());




/**
 * [tLogRow_7 end ] stop
 */

	
	/**
	 * [tDBOutput_7 end ] start
	 */

	

	
	
	currentComponent="tDBOutput_7";

	



	    try {
				int countSum_tDBOutput_7 = 0;
				if (pstmt_tDBOutput_7 != null && batchSizeCounter_tDBOutput_7 > 0) {
						
					for(int countEach_tDBOutput_7: pstmt_tDBOutput_7.executeBatch()) {
						countSum_tDBOutput_7 += (countEach_tDBOutput_7 < 0 ? 0 : countEach_tDBOutput_7);
					}
					rowsToCommitCount_tDBOutput_7 += countSum_tDBOutput_7;
						
				}
		    	
		    		insertedCount_tDBOutput_7 += countSum_tDBOutput_7;
		    	
	    }catch (java.sql.BatchUpdateException e_tDBOutput_7){
globalMap.put("tDBOutput_7_ERROR_MESSAGE",e_tDBOutput_7.getMessage());
	    	java.sql.SQLException ne_tDBOutput_7 = e_tDBOutput_7.getNextException(),sqle_tDBOutput_7=null;
	    	String errormessage_tDBOutput_7;
			if (ne_tDBOutput_7 != null) {
				// build new exception to provide the original cause
				sqle_tDBOutput_7 = new java.sql.SQLException(e_tDBOutput_7.getMessage() + "\ncaused by: " + ne_tDBOutput_7.getMessage(), ne_tDBOutput_7.getSQLState(), ne_tDBOutput_7.getErrorCode(), ne_tDBOutput_7);
				errormessage_tDBOutput_7 = sqle_tDBOutput_7.getMessage();
			}else{
				errormessage_tDBOutput_7 = e_tDBOutput_7.getMessage();
			}
	    	
	    	int countSum_tDBOutput_7 = 0;
			for(int countEach_tDBOutput_7: e_tDBOutput_7.getUpdateCounts()) {
				countSum_tDBOutput_7 += (countEach_tDBOutput_7 < 0 ? 0 : countEach_tDBOutput_7);
			}
			rowsToCommitCount_tDBOutput_7 += countSum_tDBOutput_7;
			
	    		insertedCount_tDBOutput_7 += countSum_tDBOutput_7;
	    	
	    	System.err.println(errormessage_tDBOutput_7);
	    	
		}
	    
        if(pstmt_tDBOutput_7 != null) {
        		
            pstmt_tDBOutput_7.close();
            resourceMap.remove("pstmt_tDBOutput_7");
        }
    resourceMap.put("statementClosed_tDBOutput_7", true);
			if(rowsToCommitCount_tDBOutput_7 != 0){
				
			}
			conn_tDBOutput_7.commit();
			if(rowsToCommitCount_tDBOutput_7 != 0){
				
				rowsToCommitCount_tDBOutput_7 = 0;
			}
			commitCounter_tDBOutput_7 = 0;
		
    	conn_tDBOutput_7 .close();
    	
    	resourceMap.put("finish_tDBOutput_7", true);
    	

	nb_line_deleted_tDBOutput_7=nb_line_deleted_tDBOutput_7+ deletedCount_tDBOutput_7;
	nb_line_update_tDBOutput_7=nb_line_update_tDBOutput_7 + updatedCount_tDBOutput_7;
	nb_line_inserted_tDBOutput_7=nb_line_inserted_tDBOutput_7 + insertedCount_tDBOutput_7;
	nb_line_rejected_tDBOutput_7=nb_line_rejected_tDBOutput_7 + rejectedCount_tDBOutput_7;
	
        globalMap.put("tDBOutput_7_NB_LINE",nb_line_tDBOutput_7);
        globalMap.put("tDBOutput_7_NB_LINE_UPDATED",nb_line_update_tDBOutput_7);
        globalMap.put("tDBOutput_7_NB_LINE_INSERTED",nb_line_inserted_tDBOutput_7);
        globalMap.put("tDBOutput_7_NB_LINE_DELETED",nb_line_deleted_tDBOutput_7);
        globalMap.put("tDBOutput_7_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_7);
    

	


				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row14");
			  	}
			  	
 

ok_Hash.put("tDBOutput_7", true);
end_Hash.put("tDBOutput_7", System.currentTimeMillis());




/**
 * [tDBOutput_7 end ] stop
 */






				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tFileInputDelimited_7 finally ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_7";

	

 



/**
 * [tFileInputDelimited_7 finally ] stop
 */

	
	/**
	 * [tLogRow_7 finally ] start
	 */

	

	
	
	currentComponent="tLogRow_7";

	

 



/**
 * [tLogRow_7 finally ] stop
 */

	
	/**
	 * [tDBOutput_7 finally ] start
	 */

	

	
	
	currentComponent="tDBOutput_7";

	



    try {
    if (resourceMap.get("statementClosed_tDBOutput_7") == null) {
                java.sql.PreparedStatement pstmtToClose_tDBOutput_7 = null;
                if ((pstmtToClose_tDBOutput_7 = (java.sql.PreparedStatement) resourceMap.remove("pstmt_tDBOutput_7")) != null) {
                    pstmtToClose_tDBOutput_7.close();
                }
    }
    } finally {
        if(resourceMap.get("finish_tDBOutput_7") == null){
            java.sql.Connection ctn_tDBOutput_7 = null;
            if((ctn_tDBOutput_7 = (java.sql.Connection)resourceMap.get("conn_tDBOutput_7")) != null){
                try {
                    ctn_tDBOutput_7.close();
                } catch (java.sql.SQLException sqlEx_tDBOutput_7) {
                    String errorMessage_tDBOutput_7 = "failed to close the connection in tDBOutput_7 :" + sqlEx_tDBOutput_7.getMessage();
                    System.err.println(errorMessage_tDBOutput_7);
                }
            }
        }
    }
 



/**
 * [tDBOutput_7 finally ] stop
 */






				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tFileInputDelimited_7_SUBPROCESS_STATE", 1);
	}
	


public static class row16Struct implements routines.system.IPersistableRow<row16Struct> {
    final static byte[] commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[0];
    static byte[] commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[0];

	
			    public String joueur1_nom;

				public String getJoueur1_nom () {
					return this.joueur1_nom;
				}
				
			    public String joueur1_prenom;

				public String getJoueur1_prenom () {
					return this.joueur1_prenom;
				}
				
			    public String joueur1_nationalite;

				public String getJoueur1_nationalite () {
					return this.joueur1_nationalite;
				}
				
			    public String joueur2_nom;

				public String getJoueur2_nom () {
					return this.joueur2_nom;
				}
				
			    public String joueur2_prenom;

				public String getJoueur2_prenom () {
					return this.joueur2_prenom;
				}
				
			    public String joueur2_nationalite;

				public String getJoueur2_nationalite () {
					return this.joueur2_nationalite;
				}
				
			    public Integer seed;

				public Integer getSeed () {
					return this.seed;
				}
				
			    public String round;

				public String getRound () {
					return this.round;
				}
				
			    public String score;

				public String getScore () {
					return this.score;
				}
				
			    public String resultat;

				public String getResultat () {
					return this.resultat;
				}
				
			    public java.util.Date date_tournoi;

				public java.util.Date getDate_tournoi () {
					return this.date_tournoi;
				}
				
			    public String nom_tournoi;

				public String getNom_tournoi () {
					return this.nom_tournoi;
				}
				
			    public String lieu_tournoi;

				public String getLieu_tournoi () {
					return this.lieu_tournoi;
				}
				
			    public BigDecimal prize_money;

				public BigDecimal getPrize_money () {
					return this.prize_money;
				}
				
			    public Integer points;

				public Integer getPoints () {
					return this.points;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length) {
				if(length < 1024 && commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length == 0) {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[1024];
				} else {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length);
			strReturn = new String(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length) {
				if(length < 1024 && commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length == 0) {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[1024];
				} else {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length);
			strReturn = new String(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep) {

        	try {

        		int length = 0;
		
					this.joueur1_nom = readString(dis);
					
					this.joueur1_prenom = readString(dis);
					
					this.joueur1_nationalite = readString(dis);
					
					this.joueur2_nom = readString(dis);
					
					this.joueur2_prenom = readString(dis);
					
					this.joueur2_nationalite = readString(dis);
					
						this.seed = readInteger(dis);
					
					this.round = readString(dis);
					
					this.score = readString(dis);
					
					this.resultat = readString(dis);
					
					this.date_tournoi = readDate(dis);
					
					this.nom_tournoi = readString(dis);
					
					this.lieu_tournoi = readString(dis);
					
						this.prize_money = (BigDecimal) dis.readObject();
					
						this.points = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep) {

        	try {

        		int length = 0;
		
					this.joueur1_nom = readString(dis);
					
					this.joueur1_prenom = readString(dis);
					
					this.joueur1_nationalite = readString(dis);
					
					this.joueur2_nom = readString(dis);
					
					this.joueur2_prenom = readString(dis);
					
					this.joueur2_nationalite = readString(dis);
					
						this.seed = readInteger(dis);
					
					this.round = readString(dis);
					
					this.score = readString(dis);
					
					this.resultat = readString(dis);
					
					this.date_tournoi = readDate(dis);
					
					this.nom_tournoi = readString(dis);
					
					this.lieu_tournoi = readString(dis);
					
						this.prize_money = (BigDecimal) dis.readObject();
					
						this.points = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.joueur1_nom,dos);
					
					// String
				
						writeString(this.joueur1_prenom,dos);
					
					// String
				
						writeString(this.joueur1_nationalite,dos);
					
					// String
				
						writeString(this.joueur2_nom,dos);
					
					// String
				
						writeString(this.joueur2_prenom,dos);
					
					// String
				
						writeString(this.joueur2_nationalite,dos);
					
					// Integer
				
						writeInteger(this.seed,dos);
					
					// String
				
						writeString(this.round,dos);
					
					// String
				
						writeString(this.score,dos);
					
					// String
				
						writeString(this.resultat,dos);
					
					// java.util.Date
				
						writeDate(this.date_tournoi,dos);
					
					// String
				
						writeString(this.nom_tournoi,dos);
					
					// String
				
						writeString(this.lieu_tournoi,dos);
					
					// BigDecimal
				
       			    	dos.writeObject(this.prize_money);
					
					// Integer
				
						writeInteger(this.points,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.joueur1_nom,dos);
					
					// String
				
						writeString(this.joueur1_prenom,dos);
					
					// String
				
						writeString(this.joueur1_nationalite,dos);
					
					// String
				
						writeString(this.joueur2_nom,dos);
					
					// String
				
						writeString(this.joueur2_prenom,dos);
					
					// String
				
						writeString(this.joueur2_nationalite,dos);
					
					// Integer
				
						writeInteger(this.seed,dos);
					
					// String
				
						writeString(this.round,dos);
					
					// String
				
						writeString(this.score,dos);
					
					// String
				
						writeString(this.resultat,dos);
					
					// java.util.Date
				
						writeDate(this.date_tournoi,dos);
					
					// String
				
						writeString(this.nom_tournoi,dos);
					
					// String
				
						writeString(this.lieu_tournoi,dos);
					
					// BigDecimal
				
       			    	dos.writeObject(this.prize_money);
					
					// Integer
				
						writeInteger(this.points,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("joueur1_nom="+joueur1_nom);
		sb.append(",joueur1_prenom="+joueur1_prenom);
		sb.append(",joueur1_nationalite="+joueur1_nationalite);
		sb.append(",joueur2_nom="+joueur2_nom);
		sb.append(",joueur2_prenom="+joueur2_prenom);
		sb.append(",joueur2_nationalite="+joueur2_nationalite);
		sb.append(",seed="+String.valueOf(seed));
		sb.append(",round="+round);
		sb.append(",score="+score);
		sb.append(",resultat="+resultat);
		sb.append(",date_tournoi="+String.valueOf(date_tournoi));
		sb.append(",nom_tournoi="+nom_tournoi);
		sb.append(",lieu_tournoi="+lieu_tournoi);
		sb.append(",prize_money="+String.valueOf(prize_money));
		sb.append(",points="+String.valueOf(points));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row16Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class row15Struct implements routines.system.IPersistableRow<row15Struct> {
    final static byte[] commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[0];
    static byte[] commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[0];

	
			    public String joueur1_nom;

				public String getJoueur1_nom () {
					return this.joueur1_nom;
				}
				
			    public String joueur1_prenom;

				public String getJoueur1_prenom () {
					return this.joueur1_prenom;
				}
				
			    public String joueur1_nationalite;

				public String getJoueur1_nationalite () {
					return this.joueur1_nationalite;
				}
				
			    public String joueur2_nom;

				public String getJoueur2_nom () {
					return this.joueur2_nom;
				}
				
			    public String joueur2_prenom;

				public String getJoueur2_prenom () {
					return this.joueur2_prenom;
				}
				
			    public String joueur2_nationalite;

				public String getJoueur2_nationalite () {
					return this.joueur2_nationalite;
				}
				
			    public Integer seed;

				public Integer getSeed () {
					return this.seed;
				}
				
			    public String round;

				public String getRound () {
					return this.round;
				}
				
			    public String score;

				public String getScore () {
					return this.score;
				}
				
			    public String resultat;

				public String getResultat () {
					return this.resultat;
				}
				
			    public java.util.Date date_tournoi;

				public java.util.Date getDate_tournoi () {
					return this.date_tournoi;
				}
				
			    public String nom_tournoi;

				public String getNom_tournoi () {
					return this.nom_tournoi;
				}
				
			    public String lieu_tournoi;

				public String getLieu_tournoi () {
					return this.lieu_tournoi;
				}
				
			    public BigDecimal prize_money;

				public BigDecimal getPrize_money () {
					return this.prize_money;
				}
				
			    public Integer points;

				public Integer getPoints () {
					return this.points;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length) {
				if(length < 1024 && commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length == 0) {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[1024];
				} else {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length);
			strReturn = new String(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length) {
				if(length < 1024 && commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length == 0) {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[1024];
				} else {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length);
			strReturn = new String(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep) {

        	try {

        		int length = 0;
		
					this.joueur1_nom = readString(dis);
					
					this.joueur1_prenom = readString(dis);
					
					this.joueur1_nationalite = readString(dis);
					
					this.joueur2_nom = readString(dis);
					
					this.joueur2_prenom = readString(dis);
					
					this.joueur2_nationalite = readString(dis);
					
						this.seed = readInteger(dis);
					
					this.round = readString(dis);
					
					this.score = readString(dis);
					
					this.resultat = readString(dis);
					
					this.date_tournoi = readDate(dis);
					
					this.nom_tournoi = readString(dis);
					
					this.lieu_tournoi = readString(dis);
					
						this.prize_money = (BigDecimal) dis.readObject();
					
						this.points = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep) {

        	try {

        		int length = 0;
		
					this.joueur1_nom = readString(dis);
					
					this.joueur1_prenom = readString(dis);
					
					this.joueur1_nationalite = readString(dis);
					
					this.joueur2_nom = readString(dis);
					
					this.joueur2_prenom = readString(dis);
					
					this.joueur2_nationalite = readString(dis);
					
						this.seed = readInteger(dis);
					
					this.round = readString(dis);
					
					this.score = readString(dis);
					
					this.resultat = readString(dis);
					
					this.date_tournoi = readDate(dis);
					
					this.nom_tournoi = readString(dis);
					
					this.lieu_tournoi = readString(dis);
					
						this.prize_money = (BigDecimal) dis.readObject();
					
						this.points = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.joueur1_nom,dos);
					
					// String
				
						writeString(this.joueur1_prenom,dos);
					
					// String
				
						writeString(this.joueur1_nationalite,dos);
					
					// String
				
						writeString(this.joueur2_nom,dos);
					
					// String
				
						writeString(this.joueur2_prenom,dos);
					
					// String
				
						writeString(this.joueur2_nationalite,dos);
					
					// Integer
				
						writeInteger(this.seed,dos);
					
					// String
				
						writeString(this.round,dos);
					
					// String
				
						writeString(this.score,dos);
					
					// String
				
						writeString(this.resultat,dos);
					
					// java.util.Date
				
						writeDate(this.date_tournoi,dos);
					
					// String
				
						writeString(this.nom_tournoi,dos);
					
					// String
				
						writeString(this.lieu_tournoi,dos);
					
					// BigDecimal
				
       			    	dos.writeObject(this.prize_money);
					
					// Integer
				
						writeInteger(this.points,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.joueur1_nom,dos);
					
					// String
				
						writeString(this.joueur1_prenom,dos);
					
					// String
				
						writeString(this.joueur1_nationalite,dos);
					
					// String
				
						writeString(this.joueur2_nom,dos);
					
					// String
				
						writeString(this.joueur2_prenom,dos);
					
					// String
				
						writeString(this.joueur2_nationalite,dos);
					
					// Integer
				
						writeInteger(this.seed,dos);
					
					// String
				
						writeString(this.round,dos);
					
					// String
				
						writeString(this.score,dos);
					
					// String
				
						writeString(this.resultat,dos);
					
					// java.util.Date
				
						writeDate(this.date_tournoi,dos);
					
					// String
				
						writeString(this.nom_tournoi,dos);
					
					// String
				
						writeString(this.lieu_tournoi,dos);
					
					// BigDecimal
				
       			    	dos.writeObject(this.prize_money);
					
					// Integer
				
						writeInteger(this.points,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("joueur1_nom="+joueur1_nom);
		sb.append(",joueur1_prenom="+joueur1_prenom);
		sb.append(",joueur1_nationalite="+joueur1_nationalite);
		sb.append(",joueur2_nom="+joueur2_nom);
		sb.append(",joueur2_prenom="+joueur2_prenom);
		sb.append(",joueur2_nationalite="+joueur2_nationalite);
		sb.append(",seed="+String.valueOf(seed));
		sb.append(",round="+round);
		sb.append(",score="+score);
		sb.append(",resultat="+resultat);
		sb.append(",date_tournoi="+String.valueOf(date_tournoi));
		sb.append(",nom_tournoi="+nom_tournoi);
		sb.append(",lieu_tournoi="+lieu_tournoi);
		sb.append(",prize_money="+String.valueOf(prize_money));
		sb.append(",points="+String.valueOf(points));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row15Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tFileInputDelimited_8Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tFileInputDelimited_8_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row15Struct row15 = new row15Struct();
row15Struct row16 = row15;





	
	/**
	 * [tDBOutput_8 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBOutput_8", false);
		start_Hash.put("tDBOutput_8", System.currentTimeMillis());
		
	
	currentComponent="tDBOutput_8";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row16");
					}
				
		int tos_count_tDBOutput_8 = 0;
		





String dbschema_tDBOutput_8 = null;
	dbschema_tDBOutput_8 = "sa";
	

String tableName_tDBOutput_8 = null;
if(dbschema_tDBOutput_8 == null || dbschema_tDBOutput_8.trim().length() == 0) {
	tableName_tDBOutput_8 = ("sa_tournament_nov");
} else {
	tableName_tDBOutput_8 = dbschema_tDBOutput_8 + "\".\"" + ("sa_tournament_nov");
}


int nb_line_tDBOutput_8 = 0;
int nb_line_update_tDBOutput_8 = 0;
int nb_line_inserted_tDBOutput_8 = 0;
int nb_line_deleted_tDBOutput_8 = 0;
int nb_line_rejected_tDBOutput_8 = 0;

int deletedCount_tDBOutput_8=0;
int updatedCount_tDBOutput_8=0;
int insertedCount_tDBOutput_8=0;
int rowsToCommitCount_tDBOutput_8=0;
int rejectedCount_tDBOutput_8=0;

boolean whetherReject_tDBOutput_8 = false;

java.sql.Connection conn_tDBOutput_8 = null;
String dbUser_tDBOutput_8 = null;

	
    java.lang.Class.forName("org.postgresql.Driver");
    
        String url_tDBOutput_8 = "jdbc:postgresql://"+"localhost"+":"+"5432"+"/"+"padel_bi_SA";
    dbUser_tDBOutput_8 = "postgres";
 
	final String decryptedPassword_tDBOutput_8 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:YlleQMMT9eOmKCuHQDsCNOaC2b3UOeTATj9CE8t363nZFe6QCQ==");

    String dbPwd_tDBOutput_8 = decryptedPassword_tDBOutput_8;

    conn_tDBOutput_8 = java.sql.DriverManager.getConnection(url_tDBOutput_8,dbUser_tDBOutput_8,dbPwd_tDBOutput_8);
	
	resourceMap.put("conn_tDBOutput_8", conn_tDBOutput_8);
        conn_tDBOutput_8.setAutoCommit(false);
        int commitEvery_tDBOutput_8 = 10000;
        int commitCounter_tDBOutput_8 = 0;


   int batchSize_tDBOutput_8 = 10000;
   int batchSizeCounter_tDBOutput_8=0;

int count_tDBOutput_8=0;
	    String insert_tDBOutput_8 = "INSERT INTO \"" + tableName_tDBOutput_8 + "\" (\"joueur1_nom\",\"joueur1_prenom\",\"joueur1_nationalite\",\"joueur2_nom\",\"joueur2_prenom\",\"joueur2_nationalite\",\"seed\",\"round\",\"score\",\"resultat\",\"date_tournoi\",\"nom_tournoi\",\"lieu_tournoi\",\"prize_money\",\"points\") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	    
	    java.sql.PreparedStatement pstmt_tDBOutput_8 = conn_tDBOutput_8.prepareStatement(insert_tDBOutput_8);
	    resourceMap.put("pstmt_tDBOutput_8", pstmt_tDBOutput_8);
	    

 



/**
 * [tDBOutput_8 begin ] stop
 */



	
	/**
	 * [tLogRow_8 begin ] start
	 */

	

	
		
		ok_Hash.put("tLogRow_8", false);
		start_Hash.put("tLogRow_8", System.currentTimeMillis());
		
	
	currentComponent="tLogRow_8";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row15");
					}
				
		int tos_count_tLogRow_8 = 0;
		

	///////////////////////
	
         class Util_tLogRow_8 {

        String[] des_top = { ".", ".", "-", "+" };

        String[] des_head = { "|=", "=|", "-", "+" };

        String[] des_bottom = { "'", "'", "-", "+" };

        String name="";

        java.util.List<String[]> list = new java.util.ArrayList<String[]>();

        int[] colLengths = new int[15];

        public void addRow(String[] row) {

            for (int i = 0; i < 15; i++) {
                if (row[i]!=null) {
                  colLengths[i] = Math.max(colLengths[i], row[i].length());
                }
            }
            list.add(row);
        }

        public void setTableName(String name) {

            this.name = name;
        }

            public StringBuilder format() {
            
                StringBuilder sb = new StringBuilder();
  
            
                    sb.append(print(des_top));
    
                    int totals = 0;
                    for (int i = 0; i < colLengths.length; i++) {
                        totals = totals + colLengths[i];
                    }
    
                    // name
                    sb.append("|");
                    int k = 0;
                    for (k = 0; k < (totals + 14 - name.length()) / 2; k++) {
                        sb.append(' ');
                    }
                    sb.append(name);
                    for (int i = 0; i < totals + 14 - name.length() - k; i++) {
                        sb.append(' ');
                    }
                    sb.append("|\n");

                    // head and rows
                    sb.append(print(des_head));
                    for (int i = 0; i < list.size(); i++) {
    
                        String[] row = list.get(i);
    
                        java.util.Formatter formatter = new java.util.Formatter(new StringBuilder());
                        
                        StringBuilder sbformat = new StringBuilder();                                             
        			        sbformat.append("|%1$-");
        			        sbformat.append(colLengths[0]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%2$-");
        			        sbformat.append(colLengths[1]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%3$-");
        			        sbformat.append(colLengths[2]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%4$-");
        			        sbformat.append(colLengths[3]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%5$-");
        			        sbformat.append(colLengths[4]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%6$-");
        			        sbformat.append(colLengths[5]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%7$-");
        			        sbformat.append(colLengths[6]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%8$-");
        			        sbformat.append(colLengths[7]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%9$-");
        			        sbformat.append(colLengths[8]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%10$-");
        			        sbformat.append(colLengths[9]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%11$-");
        			        sbformat.append(colLengths[10]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%12$-");
        			        sbformat.append(colLengths[11]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%13$-");
        			        sbformat.append(colLengths[12]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%14$-");
        			        sbformat.append(colLengths[13]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%15$-");
        			        sbformat.append(colLengths[14]);
        			        sbformat.append("s");
        			                      
                        sbformat.append("|\n");                    
       
                        formatter.format(sbformat.toString(), (Object[])row);	
                                
                        sb.append(formatter.toString());
                        if (i == 0)
                            sb.append(print(des_head)); // print the head
                    }
    
                    // end
                    sb.append(print(des_bottom));
                    return sb;
                }
            

            private StringBuilder print(String[] fillChars) {
                StringBuilder sb = new StringBuilder();
                //first column
                sb.append(fillChars[0]);                
                    for (int i = 0; i < colLengths[0] - fillChars[0].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);	                

                    for (int i = 0; i < colLengths[1] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[2] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[3] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[4] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[5] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[6] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[7] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[8] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[9] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[10] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[11] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[12] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[13] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                
                    //last column
                    for (int i = 0; i < colLengths[14] - fillChars[1].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }         
                sb.append(fillChars[1]);
                sb.append("\n");               
                return sb;
            }
            
            public boolean isTableEmpty(){
            	if (list.size() > 1)
            		return false;
            	return true;
            }
        }
        Util_tLogRow_8 util_tLogRow_8 = new Util_tLogRow_8();
        util_tLogRow_8.setTableName("tLogRow_8");
        util_tLogRow_8.addRow(new String[]{"joueur1_nom","joueur1_prenom","joueur1_nationalite","joueur2_nom","joueur2_prenom","joueur2_nationalite","seed","round","score","resultat","date_tournoi","nom_tournoi","lieu_tournoi","prize_money","points",});        
 		StringBuilder strBuffer_tLogRow_8 = null;
		int nb_line_tLogRow_8 = 0;
///////////////////////    			



 



/**
 * [tLogRow_8 begin ] stop
 */



	
	/**
	 * [tFileInputDelimited_8 begin ] start
	 */

	

	
		
		ok_Hash.put("tFileInputDelimited_8", false);
		start_Hash.put("tFileInputDelimited_8", System.currentTimeMillis());
		
	
	currentComponent="tFileInputDelimited_8";

	
		int tos_count_tFileInputDelimited_8 = 0;
		
	
	
	
 
	
	
	final routines.system.RowState rowstate_tFileInputDelimited_8 = new routines.system.RowState();
	
	
				int nb_line_tFileInputDelimited_8 = 0;
				org.talend.fileprocess.FileInputDelimited fid_tFileInputDelimited_8 = null;
				int limit_tFileInputDelimited_8 = -1;
				try{
					
						Object filename_tFileInputDelimited_8 = "C:/Users/ASUS/Downloads/Sports/Sports/script_tournois/nov.csv";
						if(filename_tFileInputDelimited_8 instanceof java.io.InputStream){
							
			int footer_value_tFileInputDelimited_8 = 0, random_value_tFileInputDelimited_8 = -1;
			if(footer_value_tFileInputDelimited_8 >0 || random_value_tFileInputDelimited_8 > 0){
				throw new java.lang.Exception("When the input source is a stream,footer and random shouldn't be bigger than 0.");				
			}
		
						}
						try {
							fid_tFileInputDelimited_8 = new org.talend.fileprocess.FileInputDelimited("C:/Users/ASUS/Downloads/Sports/Sports/script_tournois/nov.csv", "ISO-8859-15",";","\n",true,1,0,
									limit_tFileInputDelimited_8
								,-1, false);
						} catch(java.lang.Exception e) {
globalMap.put("tFileInputDelimited_8_ERROR_MESSAGE",e.getMessage());
							
								
								System.err.println(e.getMessage());
							
						}
					
				    
					while (fid_tFileInputDelimited_8!=null && fid_tFileInputDelimited_8.nextRecord()) {
						rowstate_tFileInputDelimited_8.reset();
						
			    						row15 = null;			
												
									boolean whetherReject_tFileInputDelimited_8 = false;
									row15 = new row15Struct();
									try {
										
				int columnIndexWithD_tFileInputDelimited_8 = 0;
				
					String temp = ""; 
				
					columnIndexWithD_tFileInputDelimited_8 = 0;
					
							row15.joueur1_nom = fid_tFileInputDelimited_8.get(columnIndexWithD_tFileInputDelimited_8);
						
				
					columnIndexWithD_tFileInputDelimited_8 = 1;
					
							row15.joueur1_prenom = fid_tFileInputDelimited_8.get(columnIndexWithD_tFileInputDelimited_8);
						
				
					columnIndexWithD_tFileInputDelimited_8 = 2;
					
							row15.joueur1_nationalite = fid_tFileInputDelimited_8.get(columnIndexWithD_tFileInputDelimited_8);
						
				
					columnIndexWithD_tFileInputDelimited_8 = 3;
					
							row15.joueur2_nom = fid_tFileInputDelimited_8.get(columnIndexWithD_tFileInputDelimited_8);
						
				
					columnIndexWithD_tFileInputDelimited_8 = 4;
					
							row15.joueur2_prenom = fid_tFileInputDelimited_8.get(columnIndexWithD_tFileInputDelimited_8);
						
				
					columnIndexWithD_tFileInputDelimited_8 = 5;
					
							row15.joueur2_nationalite = fid_tFileInputDelimited_8.get(columnIndexWithD_tFileInputDelimited_8);
						
				
					columnIndexWithD_tFileInputDelimited_8 = 6;
					
						temp = fid_tFileInputDelimited_8.get(columnIndexWithD_tFileInputDelimited_8);
						if(temp.length() > 0) {
							
								try {
								
    								row15.seed = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_8) {
globalMap.put("tFileInputDelimited_8_ERROR_MESSAGE",ex_tFileInputDelimited_8.getMessage());
									rowstate_tFileInputDelimited_8.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"seed", "row15", temp, ex_tFileInputDelimited_8), ex_tFileInputDelimited_8));
								}
    							
						} else {						
							
								
									row15.seed = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_8 = 7;
					
							row15.round = fid_tFileInputDelimited_8.get(columnIndexWithD_tFileInputDelimited_8);
						
				
					columnIndexWithD_tFileInputDelimited_8 = 8;
					
							row15.score = fid_tFileInputDelimited_8.get(columnIndexWithD_tFileInputDelimited_8);
						
				
					columnIndexWithD_tFileInputDelimited_8 = 9;
					
							row15.resultat = fid_tFileInputDelimited_8.get(columnIndexWithD_tFileInputDelimited_8);
						
				
					columnIndexWithD_tFileInputDelimited_8 = 10;
					
						temp = fid_tFileInputDelimited_8.get(columnIndexWithD_tFileInputDelimited_8);
						if(temp.length() > 0) {
							
								try {
								
    									row15.date_tournoi = ParserUtils.parseTo_Date(temp, "yyyy-MM-dd");
    								
    							} catch(java.lang.Exception ex_tFileInputDelimited_8) {
globalMap.put("tFileInputDelimited_8_ERROR_MESSAGE",ex_tFileInputDelimited_8.getMessage());
									rowstate_tFileInputDelimited_8.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"date_tournoi", "row15", temp, ex_tFileInputDelimited_8), ex_tFileInputDelimited_8));
								}
    							
						} else {						
							
								
									row15.date_tournoi = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_8 = 11;
					
							row15.nom_tournoi = fid_tFileInputDelimited_8.get(columnIndexWithD_tFileInputDelimited_8);
						
				
					columnIndexWithD_tFileInputDelimited_8 = 12;
					
							row15.lieu_tournoi = fid_tFileInputDelimited_8.get(columnIndexWithD_tFileInputDelimited_8);
						
				
					columnIndexWithD_tFileInputDelimited_8 = 13;
					
						temp = fid_tFileInputDelimited_8.get(columnIndexWithD_tFileInputDelimited_8);
						if(temp.length() > 0) {
							
								try {
								
    								row15.prize_money = ParserUtils.parseTo_BigDecimal(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_8) {
globalMap.put("tFileInputDelimited_8_ERROR_MESSAGE",ex_tFileInputDelimited_8.getMessage());
									rowstate_tFileInputDelimited_8.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"prize_money", "row15", temp, ex_tFileInputDelimited_8), ex_tFileInputDelimited_8));
								}
    							
						} else {						
							
								
									row15.prize_money = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_8 = 14;
					
						temp = fid_tFileInputDelimited_8.get(columnIndexWithD_tFileInputDelimited_8);
						if(temp.length() > 0) {
							
								try {
								
    								row15.points = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_8) {
globalMap.put("tFileInputDelimited_8_ERROR_MESSAGE",ex_tFileInputDelimited_8.getMessage());
									rowstate_tFileInputDelimited_8.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"points", "row15", temp, ex_tFileInputDelimited_8), ex_tFileInputDelimited_8));
								}
    							
						} else {						
							
								
									row15.points = null;
								
							
						}
					
				
				
										
										if(rowstate_tFileInputDelimited_8.getException()!=null) {
											throw rowstate_tFileInputDelimited_8.getException();
										}
										
										
							
			    					} catch (java.lang.Exception e) {
globalMap.put("tFileInputDelimited_8_ERROR_MESSAGE",e.getMessage());
			        					whetherReject_tFileInputDelimited_8 = true;
			        					
			                					System.err.println(e.getMessage());
			                					row15 = null;
			                				
										
			    					}
								

 



/**
 * [tFileInputDelimited_8 begin ] stop
 */
	
	/**
	 * [tFileInputDelimited_8 main ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_8";

	

 


	tos_count_tFileInputDelimited_8++;

/**
 * [tFileInputDelimited_8 main ] stop
 */
	
	/**
	 * [tFileInputDelimited_8 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_8";

	

 



/**
 * [tFileInputDelimited_8 process_data_begin ] stop
 */
// Start of branch "row15"
if(row15 != null) { 



	
	/**
	 * [tLogRow_8 main ] start
	 */

	

	
	
	currentComponent="tLogRow_8";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row15"
						
						);
					}
					
///////////////////////		
						

				
				String[] row_tLogRow_8 = new String[15];
   				
	    		if(row15.joueur1_nom != null) { //              
                 row_tLogRow_8[0]=    						    
				                String.valueOf(row15.joueur1_nom)			
					          ;	
							
	    		} //			
    			   				
	    		if(row15.joueur1_prenom != null) { //              
                 row_tLogRow_8[1]=    						    
				                String.valueOf(row15.joueur1_prenom)			
					          ;	
							
	    		} //			
    			   				
	    		if(row15.joueur1_nationalite != null) { //              
                 row_tLogRow_8[2]=    						    
				                String.valueOf(row15.joueur1_nationalite)			
					          ;	
							
	    		} //			
    			   				
	    		if(row15.joueur2_nom != null) { //              
                 row_tLogRow_8[3]=    						    
				                String.valueOf(row15.joueur2_nom)			
					          ;	
							
	    		} //			
    			   				
	    		if(row15.joueur2_prenom != null) { //              
                 row_tLogRow_8[4]=    						    
				                String.valueOf(row15.joueur2_prenom)			
					          ;	
							
	    		} //			
    			   				
	    		if(row15.joueur2_nationalite != null) { //              
                 row_tLogRow_8[5]=    						    
				                String.valueOf(row15.joueur2_nationalite)			
					          ;	
							
	    		} //			
    			   				
	    		if(row15.seed != null) { //              
                 row_tLogRow_8[6]=    						    
				                String.valueOf(row15.seed)			
					          ;	
							
	    		} //			
    			   				
	    		if(row15.round != null) { //              
                 row_tLogRow_8[7]=    						    
				                String.valueOf(row15.round)			
					          ;	
							
	    		} //			
    			   				
	    		if(row15.score != null) { //              
                 row_tLogRow_8[8]=    						    
				                String.valueOf(row15.score)			
					          ;	
							
	    		} //			
    			   				
	    		if(row15.resultat != null) { //              
                 row_tLogRow_8[9]=    						    
				                String.valueOf(row15.resultat)			
					          ;	
							
	    		} //			
    			   				
	    		if(row15.date_tournoi != null) { //              
                 row_tLogRow_8[10]=    						
								FormatterUtils.format_Date(row15.date_tournoi, "yyyy-MM-dd")
					          ;	
							
	    		} //			
    			   				
	    		if(row15.nom_tournoi != null) { //              
                 row_tLogRow_8[11]=    						    
				                String.valueOf(row15.nom_tournoi)			
					          ;	
							
	    		} //			
    			   				
	    		if(row15.lieu_tournoi != null) { //              
                 row_tLogRow_8[12]=    						    
				                String.valueOf(row15.lieu_tournoi)			
					          ;	
							
	    		} //			
    			   				
	    		if(row15.prize_money != null) { //              
                 row_tLogRow_8[13]=    						
								row15.prize_money.toPlainString()
					          ;	
							
	    		} //			
    			   				
	    		if(row15.points != null) { //              
                 row_tLogRow_8[14]=    						    
				                String.valueOf(row15.points)			
					          ;	
							
	    		} //			
    			 

				util_tLogRow_8.addRow(row_tLogRow_8);	
				nb_line_tLogRow_8++;
//////

//////                    
                    
///////////////////////    			

 
     row16 = row15;


	tos_count_tLogRow_8++;

/**
 * [tLogRow_8 main ] stop
 */
	
	/**
	 * [tLogRow_8 process_data_begin ] start
	 */

	

	
	
	currentComponent="tLogRow_8";

	

 



/**
 * [tLogRow_8 process_data_begin ] stop
 */

	
	/**
	 * [tDBOutput_8 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_8";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row16"
						
						);
					}
					



        whetherReject_tDBOutput_8 = false;
                    if(row16.joueur1_nom == null) {
pstmt_tDBOutput_8.setNull(1, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_8.setString(1, row16.joueur1_nom);
}

                    if(row16.joueur1_prenom == null) {
pstmt_tDBOutput_8.setNull(2, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_8.setString(2, row16.joueur1_prenom);
}

                    if(row16.joueur1_nationalite == null) {
pstmt_tDBOutput_8.setNull(3, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_8.setString(3, row16.joueur1_nationalite);
}

                    if(row16.joueur2_nom == null) {
pstmt_tDBOutput_8.setNull(4, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_8.setString(4, row16.joueur2_nom);
}

                    if(row16.joueur2_prenom == null) {
pstmt_tDBOutput_8.setNull(5, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_8.setString(5, row16.joueur2_prenom);
}

                    if(row16.joueur2_nationalite == null) {
pstmt_tDBOutput_8.setNull(6, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_8.setString(6, row16.joueur2_nationalite);
}

                    if(row16.seed == null) {
pstmt_tDBOutput_8.setNull(7, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_8.setInt(7, row16.seed);
}

                    if(row16.round == null) {
pstmt_tDBOutput_8.setNull(8, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_8.setString(8, row16.round);
}

                    if(row16.score == null) {
pstmt_tDBOutput_8.setNull(9, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_8.setString(9, row16.score);
}

                    if(row16.resultat == null) {
pstmt_tDBOutput_8.setNull(10, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_8.setString(10, row16.resultat);
}

                    if(row16.date_tournoi != null) {
pstmt_tDBOutput_8.setTimestamp(11, new java.sql.Timestamp(row16.date_tournoi.getTime()));
} else {
pstmt_tDBOutput_8.setNull(11, java.sql.Types.TIMESTAMP);
}

                    if(row16.nom_tournoi == null) {
pstmt_tDBOutput_8.setNull(12, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_8.setString(12, row16.nom_tournoi);
}

                    if(row16.lieu_tournoi == null) {
pstmt_tDBOutput_8.setNull(13, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_8.setString(13, row16.lieu_tournoi);
}

                    pstmt_tDBOutput_8.setBigDecimal(14, row16.prize_money);

                    if(row16.points == null) {
pstmt_tDBOutput_8.setNull(15, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_8.setInt(15, row16.points);
}

			
    		pstmt_tDBOutput_8.addBatch();
    		nb_line_tDBOutput_8++;
    		  
    		  
    		  batchSizeCounter_tDBOutput_8++;
    		  
    			if ((batchSize_tDBOutput_8 > 0) && (batchSize_tDBOutput_8 <= batchSizeCounter_tDBOutput_8)) {
                try {
						int countSum_tDBOutput_8 = 0;
						    
						for(int countEach_tDBOutput_8: pstmt_tDBOutput_8.executeBatch()) {
							countSum_tDBOutput_8 += (countEach_tDBOutput_8 < 0 ? 0 : countEach_tDBOutput_8);
						}
				    	rowsToCommitCount_tDBOutput_8 += countSum_tDBOutput_8;
				    	
				    		insertedCount_tDBOutput_8 += countSum_tDBOutput_8;
				    	
            	    	batchSizeCounter_tDBOutput_8 = 0;
                }catch (java.sql.BatchUpdateException e_tDBOutput_8){
globalMap.put("tDBOutput_8_ERROR_MESSAGE",e_tDBOutput_8.getMessage());
				    	java.sql.SQLException ne_tDBOutput_8 = e_tDBOutput_8.getNextException(),sqle_tDBOutput_8=null;
				    	String errormessage_tDBOutput_8;
						if (ne_tDBOutput_8 != null) {
							// build new exception to provide the original cause
							sqle_tDBOutput_8 = new java.sql.SQLException(e_tDBOutput_8.getMessage() + "\ncaused by: " + ne_tDBOutput_8.getMessage(), ne_tDBOutput_8.getSQLState(), ne_tDBOutput_8.getErrorCode(), ne_tDBOutput_8);
							errormessage_tDBOutput_8 = sqle_tDBOutput_8.getMessage();
						}else{
							errormessage_tDBOutput_8 = e_tDBOutput_8.getMessage();
						}
				    	
				    	int countSum_tDBOutput_8 = 0;
						for(int countEach_tDBOutput_8: e_tDBOutput_8.getUpdateCounts()) {
							countSum_tDBOutput_8 += (countEach_tDBOutput_8 < 0 ? 0 : countEach_tDBOutput_8);
						}
						rowsToCommitCount_tDBOutput_8 += countSum_tDBOutput_8;
						
				    		insertedCount_tDBOutput_8 += countSum_tDBOutput_8;
				    	
				    	System.err.println(errormessage_tDBOutput_8);
				    	
					}
    			}
    		
    		    commitCounter_tDBOutput_8++;
                if(commitEvery_tDBOutput_8 <= commitCounter_tDBOutput_8) {
                if ((batchSize_tDBOutput_8 > 0) && (batchSizeCounter_tDBOutput_8 > 0)) {
                try {
                		int countSum_tDBOutput_8 = 0;
                		    
						for(int countEach_tDBOutput_8: pstmt_tDBOutput_8.executeBatch()) {
							countSum_tDBOutput_8 += (countEach_tDBOutput_8 < 0 ? 0 : countEach_tDBOutput_8);
						}
            	    	rowsToCommitCount_tDBOutput_8 += countSum_tDBOutput_8;
            	    	
            	    		insertedCount_tDBOutput_8 += countSum_tDBOutput_8;
            	    	
                batchSizeCounter_tDBOutput_8 = 0;
               }catch (java.sql.BatchUpdateException e_tDBOutput_8){
globalMap.put("tDBOutput_8_ERROR_MESSAGE",e_tDBOutput_8.getMessage());
			    	java.sql.SQLException ne_tDBOutput_8 = e_tDBOutput_8.getNextException(),sqle_tDBOutput_8=null;
			    	String errormessage_tDBOutput_8;
					if (ne_tDBOutput_8 != null) {
						// build new exception to provide the original cause
						sqle_tDBOutput_8 = new java.sql.SQLException(e_tDBOutput_8.getMessage() + "\ncaused by: " + ne_tDBOutput_8.getMessage(), ne_tDBOutput_8.getSQLState(), ne_tDBOutput_8.getErrorCode(), ne_tDBOutput_8);
						errormessage_tDBOutput_8 = sqle_tDBOutput_8.getMessage();
					}else{
						errormessage_tDBOutput_8 = e_tDBOutput_8.getMessage();
					}
			    	
			    	int countSum_tDBOutput_8 = 0;
					for(int countEach_tDBOutput_8: e_tDBOutput_8.getUpdateCounts()) {
						countSum_tDBOutput_8 += (countEach_tDBOutput_8 < 0 ? 0 : countEach_tDBOutput_8);
					}
					rowsToCommitCount_tDBOutput_8 += countSum_tDBOutput_8;
					
			    		insertedCount_tDBOutput_8 += countSum_tDBOutput_8;
			    	
			    	System.err.println(errormessage_tDBOutput_8);
			    	
				}
            }
                    if(rowsToCommitCount_tDBOutput_8 != 0){
                    	
                    }
                    conn_tDBOutput_8.commit();
                    if(rowsToCommitCount_tDBOutput_8 != 0){
                    	
                    	rowsToCommitCount_tDBOutput_8 = 0;
                    }
                    commitCounter_tDBOutput_8=0;
                }

 


	tos_count_tDBOutput_8++;

/**
 * [tDBOutput_8 main ] stop
 */
	
	/**
	 * [tDBOutput_8 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBOutput_8";

	

 



/**
 * [tDBOutput_8 process_data_begin ] stop
 */
	
	/**
	 * [tDBOutput_8 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBOutput_8";

	

 



/**
 * [tDBOutput_8 process_data_end ] stop
 */



	
	/**
	 * [tLogRow_8 process_data_end ] start
	 */

	

	
	
	currentComponent="tLogRow_8";

	

 



/**
 * [tLogRow_8 process_data_end ] stop
 */

} // End of branch "row15"




	
	/**
	 * [tFileInputDelimited_8 process_data_end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_8";

	

 



/**
 * [tFileInputDelimited_8 process_data_end ] stop
 */
	
	/**
	 * [tFileInputDelimited_8 end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_8";

	



            }
            }finally{
                if(!((Object)("C:/Users/ASUS/Downloads/Sports/Sports/script_tournois/nov.csv") instanceof java.io.InputStream)){
                	if(fid_tFileInputDelimited_8!=null){
                		fid_tFileInputDelimited_8.close();
                	}
                }
                if(fid_tFileInputDelimited_8!=null){
                	globalMap.put("tFileInputDelimited_8_NB_LINE", fid_tFileInputDelimited_8.getRowNumber());
					
                }
			}
			  

 

ok_Hash.put("tFileInputDelimited_8", true);
end_Hash.put("tFileInputDelimited_8", System.currentTimeMillis());




/**
 * [tFileInputDelimited_8 end ] stop
 */

	
	/**
	 * [tLogRow_8 end ] start
	 */

	

	
	
	currentComponent="tLogRow_8";

	


//////

                    
                    java.io.PrintStream consoleOut_tLogRow_8 = null;
                    if (globalMap.get("tLogRow_CONSOLE")!=null)
                    {
                    	consoleOut_tLogRow_8 = (java.io.PrintStream) globalMap.get("tLogRow_CONSOLE");
                    }
                    else
                    {
                    	consoleOut_tLogRow_8 = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));
                    	globalMap.put("tLogRow_CONSOLE",consoleOut_tLogRow_8);
                    }
                    
                    consoleOut_tLogRow_8.println(util_tLogRow_8.format().toString());
                    consoleOut_tLogRow_8.flush();
//////
globalMap.put("tLogRow_8_NB_LINE",nb_line_tLogRow_8);

///////////////////////    			

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row15");
			  	}
			  	
 

ok_Hash.put("tLogRow_8", true);
end_Hash.put("tLogRow_8", System.currentTimeMillis());




/**
 * [tLogRow_8 end ] stop
 */

	
	/**
	 * [tDBOutput_8 end ] start
	 */

	

	
	
	currentComponent="tDBOutput_8";

	



	    try {
				int countSum_tDBOutput_8 = 0;
				if (pstmt_tDBOutput_8 != null && batchSizeCounter_tDBOutput_8 > 0) {
						
					for(int countEach_tDBOutput_8: pstmt_tDBOutput_8.executeBatch()) {
						countSum_tDBOutput_8 += (countEach_tDBOutput_8 < 0 ? 0 : countEach_tDBOutput_8);
					}
					rowsToCommitCount_tDBOutput_8 += countSum_tDBOutput_8;
						
				}
		    	
		    		insertedCount_tDBOutput_8 += countSum_tDBOutput_8;
		    	
	    }catch (java.sql.BatchUpdateException e_tDBOutput_8){
globalMap.put("tDBOutput_8_ERROR_MESSAGE",e_tDBOutput_8.getMessage());
	    	java.sql.SQLException ne_tDBOutput_8 = e_tDBOutput_8.getNextException(),sqle_tDBOutput_8=null;
	    	String errormessage_tDBOutput_8;
			if (ne_tDBOutput_8 != null) {
				// build new exception to provide the original cause
				sqle_tDBOutput_8 = new java.sql.SQLException(e_tDBOutput_8.getMessage() + "\ncaused by: " + ne_tDBOutput_8.getMessage(), ne_tDBOutput_8.getSQLState(), ne_tDBOutput_8.getErrorCode(), ne_tDBOutput_8);
				errormessage_tDBOutput_8 = sqle_tDBOutput_8.getMessage();
			}else{
				errormessage_tDBOutput_8 = e_tDBOutput_8.getMessage();
			}
	    	
	    	int countSum_tDBOutput_8 = 0;
			for(int countEach_tDBOutput_8: e_tDBOutput_8.getUpdateCounts()) {
				countSum_tDBOutput_8 += (countEach_tDBOutput_8 < 0 ? 0 : countEach_tDBOutput_8);
			}
			rowsToCommitCount_tDBOutput_8 += countSum_tDBOutput_8;
			
	    		insertedCount_tDBOutput_8 += countSum_tDBOutput_8;
	    	
	    	System.err.println(errormessage_tDBOutput_8);
	    	
		}
	    
        if(pstmt_tDBOutput_8 != null) {
        		
            pstmt_tDBOutput_8.close();
            resourceMap.remove("pstmt_tDBOutput_8");
        }
    resourceMap.put("statementClosed_tDBOutput_8", true);
			if(rowsToCommitCount_tDBOutput_8 != 0){
				
			}
			conn_tDBOutput_8.commit();
			if(rowsToCommitCount_tDBOutput_8 != 0){
				
				rowsToCommitCount_tDBOutput_8 = 0;
			}
			commitCounter_tDBOutput_8 = 0;
		
    	conn_tDBOutput_8 .close();
    	
    	resourceMap.put("finish_tDBOutput_8", true);
    	

	nb_line_deleted_tDBOutput_8=nb_line_deleted_tDBOutput_8+ deletedCount_tDBOutput_8;
	nb_line_update_tDBOutput_8=nb_line_update_tDBOutput_8 + updatedCount_tDBOutput_8;
	nb_line_inserted_tDBOutput_8=nb_line_inserted_tDBOutput_8 + insertedCount_tDBOutput_8;
	nb_line_rejected_tDBOutput_8=nb_line_rejected_tDBOutput_8 + rejectedCount_tDBOutput_8;
	
        globalMap.put("tDBOutput_8_NB_LINE",nb_line_tDBOutput_8);
        globalMap.put("tDBOutput_8_NB_LINE_UPDATED",nb_line_update_tDBOutput_8);
        globalMap.put("tDBOutput_8_NB_LINE_INSERTED",nb_line_inserted_tDBOutput_8);
        globalMap.put("tDBOutput_8_NB_LINE_DELETED",nb_line_deleted_tDBOutput_8);
        globalMap.put("tDBOutput_8_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_8);
    

	


				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row16");
			  	}
			  	
 

ok_Hash.put("tDBOutput_8", true);
end_Hash.put("tDBOutput_8", System.currentTimeMillis());




/**
 * [tDBOutput_8 end ] stop
 */






				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tFileInputDelimited_8 finally ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_8";

	

 



/**
 * [tFileInputDelimited_8 finally ] stop
 */

	
	/**
	 * [tLogRow_8 finally ] start
	 */

	

	
	
	currentComponent="tLogRow_8";

	

 



/**
 * [tLogRow_8 finally ] stop
 */

	
	/**
	 * [tDBOutput_8 finally ] start
	 */

	

	
	
	currentComponent="tDBOutput_8";

	



    try {
    if (resourceMap.get("statementClosed_tDBOutput_8") == null) {
                java.sql.PreparedStatement pstmtToClose_tDBOutput_8 = null;
                if ((pstmtToClose_tDBOutput_8 = (java.sql.PreparedStatement) resourceMap.remove("pstmt_tDBOutput_8")) != null) {
                    pstmtToClose_tDBOutput_8.close();
                }
    }
    } finally {
        if(resourceMap.get("finish_tDBOutput_8") == null){
            java.sql.Connection ctn_tDBOutput_8 = null;
            if((ctn_tDBOutput_8 = (java.sql.Connection)resourceMap.get("conn_tDBOutput_8")) != null){
                try {
                    ctn_tDBOutput_8.close();
                } catch (java.sql.SQLException sqlEx_tDBOutput_8) {
                    String errorMessage_tDBOutput_8 = "failed to close the connection in tDBOutput_8 :" + sqlEx_tDBOutput_8.getMessage();
                    System.err.println(errorMessage_tDBOutput_8);
                }
            }
        }
    }
 



/**
 * [tDBOutput_8 finally ] stop
 */






				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tFileInputDelimited_8_SUBPROCESS_STATE", 1);
	}
	


public static class row18Struct implements routines.system.IPersistableRow<row18Struct> {
    final static byte[] commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[0];
    static byte[] commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[0];

	
			    public String joueur1_nom;

				public String getJoueur1_nom () {
					return this.joueur1_nom;
				}
				
			    public String joueur1_prenom;

				public String getJoueur1_prenom () {
					return this.joueur1_prenom;
				}
				
			    public String joueur1_nationalite;

				public String getJoueur1_nationalite () {
					return this.joueur1_nationalite;
				}
				
			    public String joueur2_nom;

				public String getJoueur2_nom () {
					return this.joueur2_nom;
				}
				
			    public String joueur2_prenom;

				public String getJoueur2_prenom () {
					return this.joueur2_prenom;
				}
				
			    public String joueur2_nationalite;

				public String getJoueur2_nationalite () {
					return this.joueur2_nationalite;
				}
				
			    public Integer seed;

				public Integer getSeed () {
					return this.seed;
				}
				
			    public String round;

				public String getRound () {
					return this.round;
				}
				
			    public String score;

				public String getScore () {
					return this.score;
				}
				
			    public String resultat;

				public String getResultat () {
					return this.resultat;
				}
				
			    public java.util.Date date_tournoi;

				public java.util.Date getDate_tournoi () {
					return this.date_tournoi;
				}
				
			    public String nom_tournoi;

				public String getNom_tournoi () {
					return this.nom_tournoi;
				}
				
			    public String lieu_tournoi;

				public String getLieu_tournoi () {
					return this.lieu_tournoi;
				}
				
			    public BigDecimal prize_money;

				public BigDecimal getPrize_money () {
					return this.prize_money;
				}
				
			    public Integer points;

				public Integer getPoints () {
					return this.points;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length) {
				if(length < 1024 && commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length == 0) {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[1024];
				} else {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length);
			strReturn = new String(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length) {
				if(length < 1024 && commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length == 0) {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[1024];
				} else {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length);
			strReturn = new String(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep) {

        	try {

        		int length = 0;
		
					this.joueur1_nom = readString(dis);
					
					this.joueur1_prenom = readString(dis);
					
					this.joueur1_nationalite = readString(dis);
					
					this.joueur2_nom = readString(dis);
					
					this.joueur2_prenom = readString(dis);
					
					this.joueur2_nationalite = readString(dis);
					
						this.seed = readInteger(dis);
					
					this.round = readString(dis);
					
					this.score = readString(dis);
					
					this.resultat = readString(dis);
					
					this.date_tournoi = readDate(dis);
					
					this.nom_tournoi = readString(dis);
					
					this.lieu_tournoi = readString(dis);
					
						this.prize_money = (BigDecimal) dis.readObject();
					
						this.points = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep) {

        	try {

        		int length = 0;
		
					this.joueur1_nom = readString(dis);
					
					this.joueur1_prenom = readString(dis);
					
					this.joueur1_nationalite = readString(dis);
					
					this.joueur2_nom = readString(dis);
					
					this.joueur2_prenom = readString(dis);
					
					this.joueur2_nationalite = readString(dis);
					
						this.seed = readInteger(dis);
					
					this.round = readString(dis);
					
					this.score = readString(dis);
					
					this.resultat = readString(dis);
					
					this.date_tournoi = readDate(dis);
					
					this.nom_tournoi = readString(dis);
					
					this.lieu_tournoi = readString(dis);
					
						this.prize_money = (BigDecimal) dis.readObject();
					
						this.points = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.joueur1_nom,dos);
					
					// String
				
						writeString(this.joueur1_prenom,dos);
					
					// String
				
						writeString(this.joueur1_nationalite,dos);
					
					// String
				
						writeString(this.joueur2_nom,dos);
					
					// String
				
						writeString(this.joueur2_prenom,dos);
					
					// String
				
						writeString(this.joueur2_nationalite,dos);
					
					// Integer
				
						writeInteger(this.seed,dos);
					
					// String
				
						writeString(this.round,dos);
					
					// String
				
						writeString(this.score,dos);
					
					// String
				
						writeString(this.resultat,dos);
					
					// java.util.Date
				
						writeDate(this.date_tournoi,dos);
					
					// String
				
						writeString(this.nom_tournoi,dos);
					
					// String
				
						writeString(this.lieu_tournoi,dos);
					
					// BigDecimal
				
       			    	dos.writeObject(this.prize_money);
					
					// Integer
				
						writeInteger(this.points,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.joueur1_nom,dos);
					
					// String
				
						writeString(this.joueur1_prenom,dos);
					
					// String
				
						writeString(this.joueur1_nationalite,dos);
					
					// String
				
						writeString(this.joueur2_nom,dos);
					
					// String
				
						writeString(this.joueur2_prenom,dos);
					
					// String
				
						writeString(this.joueur2_nationalite,dos);
					
					// Integer
				
						writeInteger(this.seed,dos);
					
					// String
				
						writeString(this.round,dos);
					
					// String
				
						writeString(this.score,dos);
					
					// String
				
						writeString(this.resultat,dos);
					
					// java.util.Date
				
						writeDate(this.date_tournoi,dos);
					
					// String
				
						writeString(this.nom_tournoi,dos);
					
					// String
				
						writeString(this.lieu_tournoi,dos);
					
					// BigDecimal
				
       			    	dos.writeObject(this.prize_money);
					
					// Integer
				
						writeInteger(this.points,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("joueur1_nom="+joueur1_nom);
		sb.append(",joueur1_prenom="+joueur1_prenom);
		sb.append(",joueur1_nationalite="+joueur1_nationalite);
		sb.append(",joueur2_nom="+joueur2_nom);
		sb.append(",joueur2_prenom="+joueur2_prenom);
		sb.append(",joueur2_nationalite="+joueur2_nationalite);
		sb.append(",seed="+String.valueOf(seed));
		sb.append(",round="+round);
		sb.append(",score="+score);
		sb.append(",resultat="+resultat);
		sb.append(",date_tournoi="+String.valueOf(date_tournoi));
		sb.append(",nom_tournoi="+nom_tournoi);
		sb.append(",lieu_tournoi="+lieu_tournoi);
		sb.append(",prize_money="+String.valueOf(prize_money));
		sb.append(",points="+String.valueOf(points));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row18Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class row17Struct implements routines.system.IPersistableRow<row17Struct> {
    final static byte[] commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[0];
    static byte[] commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[0];

	
			    public String joueur1_nom;

				public String getJoueur1_nom () {
					return this.joueur1_nom;
				}
				
			    public String joueur1_prenom;

				public String getJoueur1_prenom () {
					return this.joueur1_prenom;
				}
				
			    public String joueur1_nationalite;

				public String getJoueur1_nationalite () {
					return this.joueur1_nationalite;
				}
				
			    public String joueur2_nom;

				public String getJoueur2_nom () {
					return this.joueur2_nom;
				}
				
			    public String joueur2_prenom;

				public String getJoueur2_prenom () {
					return this.joueur2_prenom;
				}
				
			    public String joueur2_nationalite;

				public String getJoueur2_nationalite () {
					return this.joueur2_nationalite;
				}
				
			    public Integer seed;

				public Integer getSeed () {
					return this.seed;
				}
				
			    public String round;

				public String getRound () {
					return this.round;
				}
				
			    public String score;

				public String getScore () {
					return this.score;
				}
				
			    public String resultat;

				public String getResultat () {
					return this.resultat;
				}
				
			    public java.util.Date date_tournoi;

				public java.util.Date getDate_tournoi () {
					return this.date_tournoi;
				}
				
			    public String nom_tournoi;

				public String getNom_tournoi () {
					return this.nom_tournoi;
				}
				
			    public String lieu_tournoi;

				public String getLieu_tournoi () {
					return this.lieu_tournoi;
				}
				
			    public BigDecimal prize_money;

				public BigDecimal getPrize_money () {
					return this.prize_money;
				}
				
			    public Integer points;

				public Integer getPoints () {
					return this.points;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length) {
				if(length < 1024 && commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length == 0) {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[1024];
				} else {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length);
			strReturn = new String(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length) {
				if(length < 1024 && commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length == 0) {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[1024];
				} else {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length);
			strReturn = new String(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep) {

        	try {

        		int length = 0;
		
					this.joueur1_nom = readString(dis);
					
					this.joueur1_prenom = readString(dis);
					
					this.joueur1_nationalite = readString(dis);
					
					this.joueur2_nom = readString(dis);
					
					this.joueur2_prenom = readString(dis);
					
					this.joueur2_nationalite = readString(dis);
					
						this.seed = readInteger(dis);
					
					this.round = readString(dis);
					
					this.score = readString(dis);
					
					this.resultat = readString(dis);
					
					this.date_tournoi = readDate(dis);
					
					this.nom_tournoi = readString(dis);
					
					this.lieu_tournoi = readString(dis);
					
						this.prize_money = (BigDecimal) dis.readObject();
					
						this.points = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep) {

        	try {

        		int length = 0;
		
					this.joueur1_nom = readString(dis);
					
					this.joueur1_prenom = readString(dis);
					
					this.joueur1_nationalite = readString(dis);
					
					this.joueur2_nom = readString(dis);
					
					this.joueur2_prenom = readString(dis);
					
					this.joueur2_nationalite = readString(dis);
					
						this.seed = readInteger(dis);
					
					this.round = readString(dis);
					
					this.score = readString(dis);
					
					this.resultat = readString(dis);
					
					this.date_tournoi = readDate(dis);
					
					this.nom_tournoi = readString(dis);
					
					this.lieu_tournoi = readString(dis);
					
						this.prize_money = (BigDecimal) dis.readObject();
					
						this.points = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.joueur1_nom,dos);
					
					// String
				
						writeString(this.joueur1_prenom,dos);
					
					// String
				
						writeString(this.joueur1_nationalite,dos);
					
					// String
				
						writeString(this.joueur2_nom,dos);
					
					// String
				
						writeString(this.joueur2_prenom,dos);
					
					// String
				
						writeString(this.joueur2_nationalite,dos);
					
					// Integer
				
						writeInteger(this.seed,dos);
					
					// String
				
						writeString(this.round,dos);
					
					// String
				
						writeString(this.score,dos);
					
					// String
				
						writeString(this.resultat,dos);
					
					// java.util.Date
				
						writeDate(this.date_tournoi,dos);
					
					// String
				
						writeString(this.nom_tournoi,dos);
					
					// String
				
						writeString(this.lieu_tournoi,dos);
					
					// BigDecimal
				
       			    	dos.writeObject(this.prize_money);
					
					// Integer
				
						writeInteger(this.points,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.joueur1_nom,dos);
					
					// String
				
						writeString(this.joueur1_prenom,dos);
					
					// String
				
						writeString(this.joueur1_nationalite,dos);
					
					// String
				
						writeString(this.joueur2_nom,dos);
					
					// String
				
						writeString(this.joueur2_prenom,dos);
					
					// String
				
						writeString(this.joueur2_nationalite,dos);
					
					// Integer
				
						writeInteger(this.seed,dos);
					
					// String
				
						writeString(this.round,dos);
					
					// String
				
						writeString(this.score,dos);
					
					// String
				
						writeString(this.resultat,dos);
					
					// java.util.Date
				
						writeDate(this.date_tournoi,dos);
					
					// String
				
						writeString(this.nom_tournoi,dos);
					
					// String
				
						writeString(this.lieu_tournoi,dos);
					
					// BigDecimal
				
       			    	dos.writeObject(this.prize_money);
					
					// Integer
				
						writeInteger(this.points,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("joueur1_nom="+joueur1_nom);
		sb.append(",joueur1_prenom="+joueur1_prenom);
		sb.append(",joueur1_nationalite="+joueur1_nationalite);
		sb.append(",joueur2_nom="+joueur2_nom);
		sb.append(",joueur2_prenom="+joueur2_prenom);
		sb.append(",joueur2_nationalite="+joueur2_nationalite);
		sb.append(",seed="+String.valueOf(seed));
		sb.append(",round="+round);
		sb.append(",score="+score);
		sb.append(",resultat="+resultat);
		sb.append(",date_tournoi="+String.valueOf(date_tournoi));
		sb.append(",nom_tournoi="+nom_tournoi);
		sb.append(",lieu_tournoi="+lieu_tournoi);
		sb.append(",prize_money="+String.valueOf(prize_money));
		sb.append(",points="+String.valueOf(points));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row17Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tFileInputDelimited_9Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tFileInputDelimited_9_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row17Struct row17 = new row17Struct();
row17Struct row18 = row17;





	
	/**
	 * [tDBOutput_9 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBOutput_9", false);
		start_Hash.put("tDBOutput_9", System.currentTimeMillis());
		
	
	currentComponent="tDBOutput_9";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row18");
					}
				
		int tos_count_tDBOutput_9 = 0;
		





String dbschema_tDBOutput_9 = null;
	dbschema_tDBOutput_9 = "sa";
	

String tableName_tDBOutput_9 = null;
if(dbschema_tDBOutput_9 == null || dbschema_tDBOutput_9.trim().length() == 0) {
	tableName_tDBOutput_9 = ("sa_tournament_oct");
} else {
	tableName_tDBOutput_9 = dbschema_tDBOutput_9 + "\".\"" + ("sa_tournament_oct");
}


int nb_line_tDBOutput_9 = 0;
int nb_line_update_tDBOutput_9 = 0;
int nb_line_inserted_tDBOutput_9 = 0;
int nb_line_deleted_tDBOutput_9 = 0;
int nb_line_rejected_tDBOutput_9 = 0;

int deletedCount_tDBOutput_9=0;
int updatedCount_tDBOutput_9=0;
int insertedCount_tDBOutput_9=0;
int rowsToCommitCount_tDBOutput_9=0;
int rejectedCount_tDBOutput_9=0;

boolean whetherReject_tDBOutput_9 = false;

java.sql.Connection conn_tDBOutput_9 = null;
String dbUser_tDBOutput_9 = null;

	
    java.lang.Class.forName("org.postgresql.Driver");
    
        String url_tDBOutput_9 = "jdbc:postgresql://"+"localhost"+":"+"5432"+"/"+"padel_bi_SA";
    dbUser_tDBOutput_9 = "postgres";
 
	final String decryptedPassword_tDBOutput_9 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:/5johaTLOnC4X0XPJS+s/gM/p5AGdux0D2ZwwDSz83yGTA18pQ==");

    String dbPwd_tDBOutput_9 = decryptedPassword_tDBOutput_9;

    conn_tDBOutput_9 = java.sql.DriverManager.getConnection(url_tDBOutput_9,dbUser_tDBOutput_9,dbPwd_tDBOutput_9);
	
	resourceMap.put("conn_tDBOutput_9", conn_tDBOutput_9);
        conn_tDBOutput_9.setAutoCommit(false);
        int commitEvery_tDBOutput_9 = 10000;
        int commitCounter_tDBOutput_9 = 0;


   int batchSize_tDBOutput_9 = 10000;
   int batchSizeCounter_tDBOutput_9=0;

int count_tDBOutput_9=0;
	    String insert_tDBOutput_9 = "INSERT INTO \"" + tableName_tDBOutput_9 + "\" (\"joueur1_nom\",\"joueur1_prenom\",\"joueur1_nationalite\",\"joueur2_nom\",\"joueur2_prenom\",\"joueur2_nationalite\",\"seed\",\"round\",\"score\",\"resultat\",\"date_tournoi\",\"nom_tournoi\",\"lieu_tournoi\",\"prize_money\",\"points\") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	    
	    java.sql.PreparedStatement pstmt_tDBOutput_9 = conn_tDBOutput_9.prepareStatement(insert_tDBOutput_9);
	    resourceMap.put("pstmt_tDBOutput_9", pstmt_tDBOutput_9);
	    

 



/**
 * [tDBOutput_9 begin ] stop
 */



	
	/**
	 * [tLogRow_9 begin ] start
	 */

	

	
		
		ok_Hash.put("tLogRow_9", false);
		start_Hash.put("tLogRow_9", System.currentTimeMillis());
		
	
	currentComponent="tLogRow_9";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row17");
					}
				
		int tos_count_tLogRow_9 = 0;
		

	///////////////////////
	
         class Util_tLogRow_9 {

        String[] des_top = { ".", ".", "-", "+" };

        String[] des_head = { "|=", "=|", "-", "+" };

        String[] des_bottom = { "'", "'", "-", "+" };

        String name="";

        java.util.List<String[]> list = new java.util.ArrayList<String[]>();

        int[] colLengths = new int[15];

        public void addRow(String[] row) {

            for (int i = 0; i < 15; i++) {
                if (row[i]!=null) {
                  colLengths[i] = Math.max(colLengths[i], row[i].length());
                }
            }
            list.add(row);
        }

        public void setTableName(String name) {

            this.name = name;
        }

            public StringBuilder format() {
            
                StringBuilder sb = new StringBuilder();
  
            
                    sb.append(print(des_top));
    
                    int totals = 0;
                    for (int i = 0; i < colLengths.length; i++) {
                        totals = totals + colLengths[i];
                    }
    
                    // name
                    sb.append("|");
                    int k = 0;
                    for (k = 0; k < (totals + 14 - name.length()) / 2; k++) {
                        sb.append(' ');
                    }
                    sb.append(name);
                    for (int i = 0; i < totals + 14 - name.length() - k; i++) {
                        sb.append(' ');
                    }
                    sb.append("|\n");

                    // head and rows
                    sb.append(print(des_head));
                    for (int i = 0; i < list.size(); i++) {
    
                        String[] row = list.get(i);
    
                        java.util.Formatter formatter = new java.util.Formatter(new StringBuilder());
                        
                        StringBuilder sbformat = new StringBuilder();                                             
        			        sbformat.append("|%1$-");
        			        sbformat.append(colLengths[0]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%2$-");
        			        sbformat.append(colLengths[1]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%3$-");
        			        sbformat.append(colLengths[2]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%4$-");
        			        sbformat.append(colLengths[3]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%5$-");
        			        sbformat.append(colLengths[4]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%6$-");
        			        sbformat.append(colLengths[5]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%7$-");
        			        sbformat.append(colLengths[6]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%8$-");
        			        sbformat.append(colLengths[7]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%9$-");
        			        sbformat.append(colLengths[8]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%10$-");
        			        sbformat.append(colLengths[9]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%11$-");
        			        sbformat.append(colLengths[10]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%12$-");
        			        sbformat.append(colLengths[11]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%13$-");
        			        sbformat.append(colLengths[12]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%14$-");
        			        sbformat.append(colLengths[13]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%15$-");
        			        sbformat.append(colLengths[14]);
        			        sbformat.append("s");
        			                      
                        sbformat.append("|\n");                    
       
                        formatter.format(sbformat.toString(), (Object[])row);	
                                
                        sb.append(formatter.toString());
                        if (i == 0)
                            sb.append(print(des_head)); // print the head
                    }
    
                    // end
                    sb.append(print(des_bottom));
                    return sb;
                }
            

            private StringBuilder print(String[] fillChars) {
                StringBuilder sb = new StringBuilder();
                //first column
                sb.append(fillChars[0]);                
                    for (int i = 0; i < colLengths[0] - fillChars[0].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);	                

                    for (int i = 0; i < colLengths[1] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[2] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[3] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[4] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[5] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[6] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[7] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[8] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[9] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[10] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[11] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[12] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[13] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                
                    //last column
                    for (int i = 0; i < colLengths[14] - fillChars[1].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }         
                sb.append(fillChars[1]);
                sb.append("\n");               
                return sb;
            }
            
            public boolean isTableEmpty(){
            	if (list.size() > 1)
            		return false;
            	return true;
            }
        }
        Util_tLogRow_9 util_tLogRow_9 = new Util_tLogRow_9();
        util_tLogRow_9.setTableName("tLogRow_9");
        util_tLogRow_9.addRow(new String[]{"joueur1_nom","joueur1_prenom","joueur1_nationalite","joueur2_nom","joueur2_prenom","joueur2_nationalite","seed","round","score","resultat","date_tournoi","nom_tournoi","lieu_tournoi","prize_money","points",});        
 		StringBuilder strBuffer_tLogRow_9 = null;
		int nb_line_tLogRow_9 = 0;
///////////////////////    			



 



/**
 * [tLogRow_9 begin ] stop
 */



	
	/**
	 * [tFileInputDelimited_9 begin ] start
	 */

	

	
		
		ok_Hash.put("tFileInputDelimited_9", false);
		start_Hash.put("tFileInputDelimited_9", System.currentTimeMillis());
		
	
	currentComponent="tFileInputDelimited_9";

	
		int tos_count_tFileInputDelimited_9 = 0;
		
	
	
	
 
	
	
	final routines.system.RowState rowstate_tFileInputDelimited_9 = new routines.system.RowState();
	
	
				int nb_line_tFileInputDelimited_9 = 0;
				org.talend.fileprocess.FileInputDelimited fid_tFileInputDelimited_9 = null;
				int limit_tFileInputDelimited_9 = -1;
				try{
					
						Object filename_tFileInputDelimited_9 = "C:/Users/ASUS/Downloads/Sports/Sports/script_tournois/octo.csv";
						if(filename_tFileInputDelimited_9 instanceof java.io.InputStream){
							
			int footer_value_tFileInputDelimited_9 = 0, random_value_tFileInputDelimited_9 = -1;
			if(footer_value_tFileInputDelimited_9 >0 || random_value_tFileInputDelimited_9 > 0){
				throw new java.lang.Exception("When the input source is a stream,footer and random shouldn't be bigger than 0.");				
			}
		
						}
						try {
							fid_tFileInputDelimited_9 = new org.talend.fileprocess.FileInputDelimited("C:/Users/ASUS/Downloads/Sports/Sports/script_tournois/octo.csv", "ISO-8859-15",";","\n",true,1,0,
									limit_tFileInputDelimited_9
								,-1, false);
						} catch(java.lang.Exception e) {
globalMap.put("tFileInputDelimited_9_ERROR_MESSAGE",e.getMessage());
							
								
								System.err.println(e.getMessage());
							
						}
					
				    
					while (fid_tFileInputDelimited_9!=null && fid_tFileInputDelimited_9.nextRecord()) {
						rowstate_tFileInputDelimited_9.reset();
						
			    						row17 = null;			
												
									boolean whetherReject_tFileInputDelimited_9 = false;
									row17 = new row17Struct();
									try {
										
				int columnIndexWithD_tFileInputDelimited_9 = 0;
				
					String temp = ""; 
				
					columnIndexWithD_tFileInputDelimited_9 = 0;
					
							row17.joueur1_nom = fid_tFileInputDelimited_9.get(columnIndexWithD_tFileInputDelimited_9);
						
				
					columnIndexWithD_tFileInputDelimited_9 = 1;
					
							row17.joueur1_prenom = fid_tFileInputDelimited_9.get(columnIndexWithD_tFileInputDelimited_9);
						
				
					columnIndexWithD_tFileInputDelimited_9 = 2;
					
							row17.joueur1_nationalite = fid_tFileInputDelimited_9.get(columnIndexWithD_tFileInputDelimited_9);
						
				
					columnIndexWithD_tFileInputDelimited_9 = 3;
					
							row17.joueur2_nom = fid_tFileInputDelimited_9.get(columnIndexWithD_tFileInputDelimited_9);
						
				
					columnIndexWithD_tFileInputDelimited_9 = 4;
					
							row17.joueur2_prenom = fid_tFileInputDelimited_9.get(columnIndexWithD_tFileInputDelimited_9);
						
				
					columnIndexWithD_tFileInputDelimited_9 = 5;
					
							row17.joueur2_nationalite = fid_tFileInputDelimited_9.get(columnIndexWithD_tFileInputDelimited_9);
						
				
					columnIndexWithD_tFileInputDelimited_9 = 6;
					
						temp = fid_tFileInputDelimited_9.get(columnIndexWithD_tFileInputDelimited_9);
						if(temp.length() > 0) {
							
								try {
								
    								row17.seed = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_9) {
globalMap.put("tFileInputDelimited_9_ERROR_MESSAGE",ex_tFileInputDelimited_9.getMessage());
									rowstate_tFileInputDelimited_9.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"seed", "row17", temp, ex_tFileInputDelimited_9), ex_tFileInputDelimited_9));
								}
    							
						} else {						
							
								
									row17.seed = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_9 = 7;
					
							row17.round = fid_tFileInputDelimited_9.get(columnIndexWithD_tFileInputDelimited_9);
						
				
					columnIndexWithD_tFileInputDelimited_9 = 8;
					
							row17.score = fid_tFileInputDelimited_9.get(columnIndexWithD_tFileInputDelimited_9);
						
				
					columnIndexWithD_tFileInputDelimited_9 = 9;
					
							row17.resultat = fid_tFileInputDelimited_9.get(columnIndexWithD_tFileInputDelimited_9);
						
				
					columnIndexWithD_tFileInputDelimited_9 = 10;
					
						temp = fid_tFileInputDelimited_9.get(columnIndexWithD_tFileInputDelimited_9);
						if(temp.length() > 0) {
							
								try {
								
    									row17.date_tournoi = ParserUtils.parseTo_Date(temp, "yyyy-MM-dd");
    								
    							} catch(java.lang.Exception ex_tFileInputDelimited_9) {
globalMap.put("tFileInputDelimited_9_ERROR_MESSAGE",ex_tFileInputDelimited_9.getMessage());
									rowstate_tFileInputDelimited_9.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"date_tournoi", "row17", temp, ex_tFileInputDelimited_9), ex_tFileInputDelimited_9));
								}
    							
						} else {						
							
								
									row17.date_tournoi = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_9 = 11;
					
							row17.nom_tournoi = fid_tFileInputDelimited_9.get(columnIndexWithD_tFileInputDelimited_9);
						
				
					columnIndexWithD_tFileInputDelimited_9 = 12;
					
							row17.lieu_tournoi = fid_tFileInputDelimited_9.get(columnIndexWithD_tFileInputDelimited_9);
						
				
					columnIndexWithD_tFileInputDelimited_9 = 13;
					
						temp = fid_tFileInputDelimited_9.get(columnIndexWithD_tFileInputDelimited_9);
						if(temp.length() > 0) {
							
								try {
								
    								row17.prize_money = ParserUtils.parseTo_BigDecimal(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_9) {
globalMap.put("tFileInputDelimited_9_ERROR_MESSAGE",ex_tFileInputDelimited_9.getMessage());
									rowstate_tFileInputDelimited_9.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"prize_money", "row17", temp, ex_tFileInputDelimited_9), ex_tFileInputDelimited_9));
								}
    							
						} else {						
							
								
									row17.prize_money = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_9 = 14;
					
						temp = fid_tFileInputDelimited_9.get(columnIndexWithD_tFileInputDelimited_9);
						if(temp.length() > 0) {
							
								try {
								
    								row17.points = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_9) {
globalMap.put("tFileInputDelimited_9_ERROR_MESSAGE",ex_tFileInputDelimited_9.getMessage());
									rowstate_tFileInputDelimited_9.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"points", "row17", temp, ex_tFileInputDelimited_9), ex_tFileInputDelimited_9));
								}
    							
						} else {						
							
								
									row17.points = null;
								
							
						}
					
				
				
										
										if(rowstate_tFileInputDelimited_9.getException()!=null) {
											throw rowstate_tFileInputDelimited_9.getException();
										}
										
										
							
			    					} catch (java.lang.Exception e) {
globalMap.put("tFileInputDelimited_9_ERROR_MESSAGE",e.getMessage());
			        					whetherReject_tFileInputDelimited_9 = true;
			        					
			                					System.err.println(e.getMessage());
			                					row17 = null;
			                				
										
			    					}
								

 



/**
 * [tFileInputDelimited_9 begin ] stop
 */
	
	/**
	 * [tFileInputDelimited_9 main ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_9";

	

 


	tos_count_tFileInputDelimited_9++;

/**
 * [tFileInputDelimited_9 main ] stop
 */
	
	/**
	 * [tFileInputDelimited_9 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_9";

	

 



/**
 * [tFileInputDelimited_9 process_data_begin ] stop
 */
// Start of branch "row17"
if(row17 != null) { 



	
	/**
	 * [tLogRow_9 main ] start
	 */

	

	
	
	currentComponent="tLogRow_9";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row17"
						
						);
					}
					
///////////////////////		
						

				
				String[] row_tLogRow_9 = new String[15];
   				
	    		if(row17.joueur1_nom != null) { //              
                 row_tLogRow_9[0]=    						    
				                String.valueOf(row17.joueur1_nom)			
					          ;	
							
	    		} //			
    			   				
	    		if(row17.joueur1_prenom != null) { //              
                 row_tLogRow_9[1]=    						    
				                String.valueOf(row17.joueur1_prenom)			
					          ;	
							
	    		} //			
    			   				
	    		if(row17.joueur1_nationalite != null) { //              
                 row_tLogRow_9[2]=    						    
				                String.valueOf(row17.joueur1_nationalite)			
					          ;	
							
	    		} //			
    			   				
	    		if(row17.joueur2_nom != null) { //              
                 row_tLogRow_9[3]=    						    
				                String.valueOf(row17.joueur2_nom)			
					          ;	
							
	    		} //			
    			   				
	    		if(row17.joueur2_prenom != null) { //              
                 row_tLogRow_9[4]=    						    
				                String.valueOf(row17.joueur2_prenom)			
					          ;	
							
	    		} //			
    			   				
	    		if(row17.joueur2_nationalite != null) { //              
                 row_tLogRow_9[5]=    						    
				                String.valueOf(row17.joueur2_nationalite)			
					          ;	
							
	    		} //			
    			   				
	    		if(row17.seed != null) { //              
                 row_tLogRow_9[6]=    						    
				                String.valueOf(row17.seed)			
					          ;	
							
	    		} //			
    			   				
	    		if(row17.round != null) { //              
                 row_tLogRow_9[7]=    						    
				                String.valueOf(row17.round)			
					          ;	
							
	    		} //			
    			   				
	    		if(row17.score != null) { //              
                 row_tLogRow_9[8]=    						    
				                String.valueOf(row17.score)			
					          ;	
							
	    		} //			
    			   				
	    		if(row17.resultat != null) { //              
                 row_tLogRow_9[9]=    						    
				                String.valueOf(row17.resultat)			
					          ;	
							
	    		} //			
    			   				
	    		if(row17.date_tournoi != null) { //              
                 row_tLogRow_9[10]=    						
								FormatterUtils.format_Date(row17.date_tournoi, "yyyy-MM-dd")
					          ;	
							
	    		} //			
    			   				
	    		if(row17.nom_tournoi != null) { //              
                 row_tLogRow_9[11]=    						    
				                String.valueOf(row17.nom_tournoi)			
					          ;	
							
	    		} //			
    			   				
	    		if(row17.lieu_tournoi != null) { //              
                 row_tLogRow_9[12]=    						    
				                String.valueOf(row17.lieu_tournoi)			
					          ;	
							
	    		} //			
    			   				
	    		if(row17.prize_money != null) { //              
                 row_tLogRow_9[13]=    						
								row17.prize_money.toPlainString()
					          ;	
							
	    		} //			
    			   				
	    		if(row17.points != null) { //              
                 row_tLogRow_9[14]=    						    
				                String.valueOf(row17.points)			
					          ;	
							
	    		} //			
    			 

				util_tLogRow_9.addRow(row_tLogRow_9);	
				nb_line_tLogRow_9++;
//////

//////                    
                    
///////////////////////    			

 
     row18 = row17;


	tos_count_tLogRow_9++;

/**
 * [tLogRow_9 main ] stop
 */
	
	/**
	 * [tLogRow_9 process_data_begin ] start
	 */

	

	
	
	currentComponent="tLogRow_9";

	

 



/**
 * [tLogRow_9 process_data_begin ] stop
 */

	
	/**
	 * [tDBOutput_9 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_9";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row18"
						
						);
					}
					



        whetherReject_tDBOutput_9 = false;
                    if(row18.joueur1_nom == null) {
pstmt_tDBOutput_9.setNull(1, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_9.setString(1, row18.joueur1_nom);
}

                    if(row18.joueur1_prenom == null) {
pstmt_tDBOutput_9.setNull(2, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_9.setString(2, row18.joueur1_prenom);
}

                    if(row18.joueur1_nationalite == null) {
pstmt_tDBOutput_9.setNull(3, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_9.setString(3, row18.joueur1_nationalite);
}

                    if(row18.joueur2_nom == null) {
pstmt_tDBOutput_9.setNull(4, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_9.setString(4, row18.joueur2_nom);
}

                    if(row18.joueur2_prenom == null) {
pstmt_tDBOutput_9.setNull(5, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_9.setString(5, row18.joueur2_prenom);
}

                    if(row18.joueur2_nationalite == null) {
pstmt_tDBOutput_9.setNull(6, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_9.setString(6, row18.joueur2_nationalite);
}

                    if(row18.seed == null) {
pstmt_tDBOutput_9.setNull(7, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_9.setInt(7, row18.seed);
}

                    if(row18.round == null) {
pstmt_tDBOutput_9.setNull(8, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_9.setString(8, row18.round);
}

                    if(row18.score == null) {
pstmt_tDBOutput_9.setNull(9, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_9.setString(9, row18.score);
}

                    if(row18.resultat == null) {
pstmt_tDBOutput_9.setNull(10, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_9.setString(10, row18.resultat);
}

                    if(row18.date_tournoi != null) {
pstmt_tDBOutput_9.setTimestamp(11, new java.sql.Timestamp(row18.date_tournoi.getTime()));
} else {
pstmt_tDBOutput_9.setNull(11, java.sql.Types.TIMESTAMP);
}

                    if(row18.nom_tournoi == null) {
pstmt_tDBOutput_9.setNull(12, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_9.setString(12, row18.nom_tournoi);
}

                    if(row18.lieu_tournoi == null) {
pstmt_tDBOutput_9.setNull(13, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_9.setString(13, row18.lieu_tournoi);
}

                    pstmt_tDBOutput_9.setBigDecimal(14, row18.prize_money);

                    if(row18.points == null) {
pstmt_tDBOutput_9.setNull(15, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_9.setInt(15, row18.points);
}

			
    		pstmt_tDBOutput_9.addBatch();
    		nb_line_tDBOutput_9++;
    		  
    		  
    		  batchSizeCounter_tDBOutput_9++;
    		  
    			if ((batchSize_tDBOutput_9 > 0) && (batchSize_tDBOutput_9 <= batchSizeCounter_tDBOutput_9)) {
                try {
						int countSum_tDBOutput_9 = 0;
						    
						for(int countEach_tDBOutput_9: pstmt_tDBOutput_9.executeBatch()) {
							countSum_tDBOutput_9 += (countEach_tDBOutput_9 < 0 ? 0 : countEach_tDBOutput_9);
						}
				    	rowsToCommitCount_tDBOutput_9 += countSum_tDBOutput_9;
				    	
				    		insertedCount_tDBOutput_9 += countSum_tDBOutput_9;
				    	
            	    	batchSizeCounter_tDBOutput_9 = 0;
                }catch (java.sql.BatchUpdateException e_tDBOutput_9){
globalMap.put("tDBOutput_9_ERROR_MESSAGE",e_tDBOutput_9.getMessage());
				    	java.sql.SQLException ne_tDBOutput_9 = e_tDBOutput_9.getNextException(),sqle_tDBOutput_9=null;
				    	String errormessage_tDBOutput_9;
						if (ne_tDBOutput_9 != null) {
							// build new exception to provide the original cause
							sqle_tDBOutput_9 = new java.sql.SQLException(e_tDBOutput_9.getMessage() + "\ncaused by: " + ne_tDBOutput_9.getMessage(), ne_tDBOutput_9.getSQLState(), ne_tDBOutput_9.getErrorCode(), ne_tDBOutput_9);
							errormessage_tDBOutput_9 = sqle_tDBOutput_9.getMessage();
						}else{
							errormessage_tDBOutput_9 = e_tDBOutput_9.getMessage();
						}
				    	
				    	int countSum_tDBOutput_9 = 0;
						for(int countEach_tDBOutput_9: e_tDBOutput_9.getUpdateCounts()) {
							countSum_tDBOutput_9 += (countEach_tDBOutput_9 < 0 ? 0 : countEach_tDBOutput_9);
						}
						rowsToCommitCount_tDBOutput_9 += countSum_tDBOutput_9;
						
				    		insertedCount_tDBOutput_9 += countSum_tDBOutput_9;
				    	
				    	System.err.println(errormessage_tDBOutput_9);
				    	
					}
    			}
    		
    		    commitCounter_tDBOutput_9++;
                if(commitEvery_tDBOutput_9 <= commitCounter_tDBOutput_9) {
                if ((batchSize_tDBOutput_9 > 0) && (batchSizeCounter_tDBOutput_9 > 0)) {
                try {
                		int countSum_tDBOutput_9 = 0;
                		    
						for(int countEach_tDBOutput_9: pstmt_tDBOutput_9.executeBatch()) {
							countSum_tDBOutput_9 += (countEach_tDBOutput_9 < 0 ? 0 : countEach_tDBOutput_9);
						}
            	    	rowsToCommitCount_tDBOutput_9 += countSum_tDBOutput_9;
            	    	
            	    		insertedCount_tDBOutput_9 += countSum_tDBOutput_9;
            	    	
                batchSizeCounter_tDBOutput_9 = 0;
               }catch (java.sql.BatchUpdateException e_tDBOutput_9){
globalMap.put("tDBOutput_9_ERROR_MESSAGE",e_tDBOutput_9.getMessage());
			    	java.sql.SQLException ne_tDBOutput_9 = e_tDBOutput_9.getNextException(),sqle_tDBOutput_9=null;
			    	String errormessage_tDBOutput_9;
					if (ne_tDBOutput_9 != null) {
						// build new exception to provide the original cause
						sqle_tDBOutput_9 = new java.sql.SQLException(e_tDBOutput_9.getMessage() + "\ncaused by: " + ne_tDBOutput_9.getMessage(), ne_tDBOutput_9.getSQLState(), ne_tDBOutput_9.getErrorCode(), ne_tDBOutput_9);
						errormessage_tDBOutput_9 = sqle_tDBOutput_9.getMessage();
					}else{
						errormessage_tDBOutput_9 = e_tDBOutput_9.getMessage();
					}
			    	
			    	int countSum_tDBOutput_9 = 0;
					for(int countEach_tDBOutput_9: e_tDBOutput_9.getUpdateCounts()) {
						countSum_tDBOutput_9 += (countEach_tDBOutput_9 < 0 ? 0 : countEach_tDBOutput_9);
					}
					rowsToCommitCount_tDBOutput_9 += countSum_tDBOutput_9;
					
			    		insertedCount_tDBOutput_9 += countSum_tDBOutput_9;
			    	
			    	System.err.println(errormessage_tDBOutput_9);
			    	
				}
            }
                    if(rowsToCommitCount_tDBOutput_9 != 0){
                    	
                    }
                    conn_tDBOutput_9.commit();
                    if(rowsToCommitCount_tDBOutput_9 != 0){
                    	
                    	rowsToCommitCount_tDBOutput_9 = 0;
                    }
                    commitCounter_tDBOutput_9=0;
                }

 


	tos_count_tDBOutput_9++;

/**
 * [tDBOutput_9 main ] stop
 */
	
	/**
	 * [tDBOutput_9 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBOutput_9";

	

 



/**
 * [tDBOutput_9 process_data_begin ] stop
 */
	
	/**
	 * [tDBOutput_9 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBOutput_9";

	

 



/**
 * [tDBOutput_9 process_data_end ] stop
 */



	
	/**
	 * [tLogRow_9 process_data_end ] start
	 */

	

	
	
	currentComponent="tLogRow_9";

	

 



/**
 * [tLogRow_9 process_data_end ] stop
 */

} // End of branch "row17"




	
	/**
	 * [tFileInputDelimited_9 process_data_end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_9";

	

 



/**
 * [tFileInputDelimited_9 process_data_end ] stop
 */
	
	/**
	 * [tFileInputDelimited_9 end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_9";

	



            }
            }finally{
                if(!((Object)("C:/Users/ASUS/Downloads/Sports/Sports/script_tournois/octo.csv") instanceof java.io.InputStream)){
                	if(fid_tFileInputDelimited_9!=null){
                		fid_tFileInputDelimited_9.close();
                	}
                }
                if(fid_tFileInputDelimited_9!=null){
                	globalMap.put("tFileInputDelimited_9_NB_LINE", fid_tFileInputDelimited_9.getRowNumber());
					
                }
			}
			  

 

ok_Hash.put("tFileInputDelimited_9", true);
end_Hash.put("tFileInputDelimited_9", System.currentTimeMillis());




/**
 * [tFileInputDelimited_9 end ] stop
 */

	
	/**
	 * [tLogRow_9 end ] start
	 */

	

	
	
	currentComponent="tLogRow_9";

	


//////

                    
                    java.io.PrintStream consoleOut_tLogRow_9 = null;
                    if (globalMap.get("tLogRow_CONSOLE")!=null)
                    {
                    	consoleOut_tLogRow_9 = (java.io.PrintStream) globalMap.get("tLogRow_CONSOLE");
                    }
                    else
                    {
                    	consoleOut_tLogRow_9 = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));
                    	globalMap.put("tLogRow_CONSOLE",consoleOut_tLogRow_9);
                    }
                    
                    consoleOut_tLogRow_9.println(util_tLogRow_9.format().toString());
                    consoleOut_tLogRow_9.flush();
//////
globalMap.put("tLogRow_9_NB_LINE",nb_line_tLogRow_9);

///////////////////////    			

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row17");
			  	}
			  	
 

ok_Hash.put("tLogRow_9", true);
end_Hash.put("tLogRow_9", System.currentTimeMillis());




/**
 * [tLogRow_9 end ] stop
 */

	
	/**
	 * [tDBOutput_9 end ] start
	 */

	

	
	
	currentComponent="tDBOutput_9";

	



	    try {
				int countSum_tDBOutput_9 = 0;
				if (pstmt_tDBOutput_9 != null && batchSizeCounter_tDBOutput_9 > 0) {
						
					for(int countEach_tDBOutput_9: pstmt_tDBOutput_9.executeBatch()) {
						countSum_tDBOutput_9 += (countEach_tDBOutput_9 < 0 ? 0 : countEach_tDBOutput_9);
					}
					rowsToCommitCount_tDBOutput_9 += countSum_tDBOutput_9;
						
				}
		    	
		    		insertedCount_tDBOutput_9 += countSum_tDBOutput_9;
		    	
	    }catch (java.sql.BatchUpdateException e_tDBOutput_9){
globalMap.put("tDBOutput_9_ERROR_MESSAGE",e_tDBOutput_9.getMessage());
	    	java.sql.SQLException ne_tDBOutput_9 = e_tDBOutput_9.getNextException(),sqle_tDBOutput_9=null;
	    	String errormessage_tDBOutput_9;
			if (ne_tDBOutput_9 != null) {
				// build new exception to provide the original cause
				sqle_tDBOutput_9 = new java.sql.SQLException(e_tDBOutput_9.getMessage() + "\ncaused by: " + ne_tDBOutput_9.getMessage(), ne_tDBOutput_9.getSQLState(), ne_tDBOutput_9.getErrorCode(), ne_tDBOutput_9);
				errormessage_tDBOutput_9 = sqle_tDBOutput_9.getMessage();
			}else{
				errormessage_tDBOutput_9 = e_tDBOutput_9.getMessage();
			}
	    	
	    	int countSum_tDBOutput_9 = 0;
			for(int countEach_tDBOutput_9: e_tDBOutput_9.getUpdateCounts()) {
				countSum_tDBOutput_9 += (countEach_tDBOutput_9 < 0 ? 0 : countEach_tDBOutput_9);
			}
			rowsToCommitCount_tDBOutput_9 += countSum_tDBOutput_9;
			
	    		insertedCount_tDBOutput_9 += countSum_tDBOutput_9;
	    	
	    	System.err.println(errormessage_tDBOutput_9);
	    	
		}
	    
        if(pstmt_tDBOutput_9 != null) {
        		
            pstmt_tDBOutput_9.close();
            resourceMap.remove("pstmt_tDBOutput_9");
        }
    resourceMap.put("statementClosed_tDBOutput_9", true);
			if(rowsToCommitCount_tDBOutput_9 != 0){
				
			}
			conn_tDBOutput_9.commit();
			if(rowsToCommitCount_tDBOutput_9 != 0){
				
				rowsToCommitCount_tDBOutput_9 = 0;
			}
			commitCounter_tDBOutput_9 = 0;
		
    	conn_tDBOutput_9 .close();
    	
    	resourceMap.put("finish_tDBOutput_9", true);
    	

	nb_line_deleted_tDBOutput_9=nb_line_deleted_tDBOutput_9+ deletedCount_tDBOutput_9;
	nb_line_update_tDBOutput_9=nb_line_update_tDBOutput_9 + updatedCount_tDBOutput_9;
	nb_line_inserted_tDBOutput_9=nb_line_inserted_tDBOutput_9 + insertedCount_tDBOutput_9;
	nb_line_rejected_tDBOutput_9=nb_line_rejected_tDBOutput_9 + rejectedCount_tDBOutput_9;
	
        globalMap.put("tDBOutput_9_NB_LINE",nb_line_tDBOutput_9);
        globalMap.put("tDBOutput_9_NB_LINE_UPDATED",nb_line_update_tDBOutput_9);
        globalMap.put("tDBOutput_9_NB_LINE_INSERTED",nb_line_inserted_tDBOutput_9);
        globalMap.put("tDBOutput_9_NB_LINE_DELETED",nb_line_deleted_tDBOutput_9);
        globalMap.put("tDBOutput_9_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_9);
    

	


				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row18");
			  	}
			  	
 

ok_Hash.put("tDBOutput_9", true);
end_Hash.put("tDBOutput_9", System.currentTimeMillis());




/**
 * [tDBOutput_9 end ] stop
 */






				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tFileInputDelimited_9 finally ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_9";

	

 



/**
 * [tFileInputDelimited_9 finally ] stop
 */

	
	/**
	 * [tLogRow_9 finally ] start
	 */

	

	
	
	currentComponent="tLogRow_9";

	

 



/**
 * [tLogRow_9 finally ] stop
 */

	
	/**
	 * [tDBOutput_9 finally ] start
	 */

	

	
	
	currentComponent="tDBOutput_9";

	



    try {
    if (resourceMap.get("statementClosed_tDBOutput_9") == null) {
                java.sql.PreparedStatement pstmtToClose_tDBOutput_9 = null;
                if ((pstmtToClose_tDBOutput_9 = (java.sql.PreparedStatement) resourceMap.remove("pstmt_tDBOutput_9")) != null) {
                    pstmtToClose_tDBOutput_9.close();
                }
    }
    } finally {
        if(resourceMap.get("finish_tDBOutput_9") == null){
            java.sql.Connection ctn_tDBOutput_9 = null;
            if((ctn_tDBOutput_9 = (java.sql.Connection)resourceMap.get("conn_tDBOutput_9")) != null){
                try {
                    ctn_tDBOutput_9.close();
                } catch (java.sql.SQLException sqlEx_tDBOutput_9) {
                    String errorMessage_tDBOutput_9 = "failed to close the connection in tDBOutput_9 :" + sqlEx_tDBOutput_9.getMessage();
                    System.err.println(errorMessage_tDBOutput_9);
                }
            }
        }
    }
 



/**
 * [tDBOutput_9 finally ] stop
 */






				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tFileInputDelimited_9_SUBPROCESS_STATE", 1);
	}
	


public static class row20Struct implements routines.system.IPersistableRow<row20Struct> {
    final static byte[] commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[0];
    static byte[] commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[0];

	
			    public String joueur1_nom;

				public String getJoueur1_nom () {
					return this.joueur1_nom;
				}
				
			    public String joueur1_prenom;

				public String getJoueur1_prenom () {
					return this.joueur1_prenom;
				}
				
			    public String joueur1_nationalite;

				public String getJoueur1_nationalite () {
					return this.joueur1_nationalite;
				}
				
			    public String joueur2_nom;

				public String getJoueur2_nom () {
					return this.joueur2_nom;
				}
				
			    public String joueur2_prenom;

				public String getJoueur2_prenom () {
					return this.joueur2_prenom;
				}
				
			    public String joueur2_nationalite;

				public String getJoueur2_nationalite () {
					return this.joueur2_nationalite;
				}
				
			    public Integer seed;

				public Integer getSeed () {
					return this.seed;
				}
				
			    public String round;

				public String getRound () {
					return this.round;
				}
				
			    public String score;

				public String getScore () {
					return this.score;
				}
				
			    public String resultat;

				public String getResultat () {
					return this.resultat;
				}
				
			    public java.util.Date date_tournoi;

				public java.util.Date getDate_tournoi () {
					return this.date_tournoi;
				}
				
			    public String nom_tournoi;

				public String getNom_tournoi () {
					return this.nom_tournoi;
				}
				
			    public String lieu_tournoi;

				public String getLieu_tournoi () {
					return this.lieu_tournoi;
				}
				
			    public BigDecimal prize_money;

				public BigDecimal getPrize_money () {
					return this.prize_money;
				}
				
			    public Integer points;

				public Integer getPoints () {
					return this.points;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length) {
				if(length < 1024 && commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length == 0) {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[1024];
				} else {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length);
			strReturn = new String(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length) {
				if(length < 1024 && commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length == 0) {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[1024];
				} else {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length);
			strReturn = new String(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep) {

        	try {

        		int length = 0;
		
					this.joueur1_nom = readString(dis);
					
					this.joueur1_prenom = readString(dis);
					
					this.joueur1_nationalite = readString(dis);
					
					this.joueur2_nom = readString(dis);
					
					this.joueur2_prenom = readString(dis);
					
					this.joueur2_nationalite = readString(dis);
					
						this.seed = readInteger(dis);
					
					this.round = readString(dis);
					
					this.score = readString(dis);
					
					this.resultat = readString(dis);
					
					this.date_tournoi = readDate(dis);
					
					this.nom_tournoi = readString(dis);
					
					this.lieu_tournoi = readString(dis);
					
						this.prize_money = (BigDecimal) dis.readObject();
					
						this.points = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep) {

        	try {

        		int length = 0;
		
					this.joueur1_nom = readString(dis);
					
					this.joueur1_prenom = readString(dis);
					
					this.joueur1_nationalite = readString(dis);
					
					this.joueur2_nom = readString(dis);
					
					this.joueur2_prenom = readString(dis);
					
					this.joueur2_nationalite = readString(dis);
					
						this.seed = readInteger(dis);
					
					this.round = readString(dis);
					
					this.score = readString(dis);
					
					this.resultat = readString(dis);
					
					this.date_tournoi = readDate(dis);
					
					this.nom_tournoi = readString(dis);
					
					this.lieu_tournoi = readString(dis);
					
						this.prize_money = (BigDecimal) dis.readObject();
					
						this.points = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.joueur1_nom,dos);
					
					// String
				
						writeString(this.joueur1_prenom,dos);
					
					// String
				
						writeString(this.joueur1_nationalite,dos);
					
					// String
				
						writeString(this.joueur2_nom,dos);
					
					// String
				
						writeString(this.joueur2_prenom,dos);
					
					// String
				
						writeString(this.joueur2_nationalite,dos);
					
					// Integer
				
						writeInteger(this.seed,dos);
					
					// String
				
						writeString(this.round,dos);
					
					// String
				
						writeString(this.score,dos);
					
					// String
				
						writeString(this.resultat,dos);
					
					// java.util.Date
				
						writeDate(this.date_tournoi,dos);
					
					// String
				
						writeString(this.nom_tournoi,dos);
					
					// String
				
						writeString(this.lieu_tournoi,dos);
					
					// BigDecimal
				
       			    	dos.writeObject(this.prize_money);
					
					// Integer
				
						writeInteger(this.points,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.joueur1_nom,dos);
					
					// String
				
						writeString(this.joueur1_prenom,dos);
					
					// String
				
						writeString(this.joueur1_nationalite,dos);
					
					// String
				
						writeString(this.joueur2_nom,dos);
					
					// String
				
						writeString(this.joueur2_prenom,dos);
					
					// String
				
						writeString(this.joueur2_nationalite,dos);
					
					// Integer
				
						writeInteger(this.seed,dos);
					
					// String
				
						writeString(this.round,dos);
					
					// String
				
						writeString(this.score,dos);
					
					// String
				
						writeString(this.resultat,dos);
					
					// java.util.Date
				
						writeDate(this.date_tournoi,dos);
					
					// String
				
						writeString(this.nom_tournoi,dos);
					
					// String
				
						writeString(this.lieu_tournoi,dos);
					
					// BigDecimal
				
       			    	dos.writeObject(this.prize_money);
					
					// Integer
				
						writeInteger(this.points,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("joueur1_nom="+joueur1_nom);
		sb.append(",joueur1_prenom="+joueur1_prenom);
		sb.append(",joueur1_nationalite="+joueur1_nationalite);
		sb.append(",joueur2_nom="+joueur2_nom);
		sb.append(",joueur2_prenom="+joueur2_prenom);
		sb.append(",joueur2_nationalite="+joueur2_nationalite);
		sb.append(",seed="+String.valueOf(seed));
		sb.append(",round="+round);
		sb.append(",score="+score);
		sb.append(",resultat="+resultat);
		sb.append(",date_tournoi="+String.valueOf(date_tournoi));
		sb.append(",nom_tournoi="+nom_tournoi);
		sb.append(",lieu_tournoi="+lieu_tournoi);
		sb.append(",prize_money="+String.valueOf(prize_money));
		sb.append(",points="+String.valueOf(points));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row20Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class row19Struct implements routines.system.IPersistableRow<row19Struct> {
    final static byte[] commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[0];
    static byte[] commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[0];

	
			    public String joueur1_nom;

				public String getJoueur1_nom () {
					return this.joueur1_nom;
				}
				
			    public String joueur1_prenom;

				public String getJoueur1_prenom () {
					return this.joueur1_prenom;
				}
				
			    public String joueur1_nationalite;

				public String getJoueur1_nationalite () {
					return this.joueur1_nationalite;
				}
				
			    public String joueur2_nom;

				public String getJoueur2_nom () {
					return this.joueur2_nom;
				}
				
			    public String joueur2_prenom;

				public String getJoueur2_prenom () {
					return this.joueur2_prenom;
				}
				
			    public String joueur2_nationalite;

				public String getJoueur2_nationalite () {
					return this.joueur2_nationalite;
				}
				
			    public Integer seed;

				public Integer getSeed () {
					return this.seed;
				}
				
			    public String round;

				public String getRound () {
					return this.round;
				}
				
			    public String score;

				public String getScore () {
					return this.score;
				}
				
			    public String resultat;

				public String getResultat () {
					return this.resultat;
				}
				
			    public java.util.Date date_tournoi;

				public java.util.Date getDate_tournoi () {
					return this.date_tournoi;
				}
				
			    public String nom_tournoi;

				public String getNom_tournoi () {
					return this.nom_tournoi;
				}
				
			    public String lieu_tournoi;

				public String getLieu_tournoi () {
					return this.lieu_tournoi;
				}
				
			    public BigDecimal prize_money;

				public BigDecimal getPrize_money () {
					return this.prize_money;
				}
				
			    public Integer points;

				public Integer getPoints () {
					return this.points;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length) {
				if(length < 1024 && commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length == 0) {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[1024];
				} else {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length);
			strReturn = new String(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length) {
				if(length < 1024 && commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length == 0) {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[1024];
				} else {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length);
			strReturn = new String(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep) {

        	try {

        		int length = 0;
		
					this.joueur1_nom = readString(dis);
					
					this.joueur1_prenom = readString(dis);
					
					this.joueur1_nationalite = readString(dis);
					
					this.joueur2_nom = readString(dis);
					
					this.joueur2_prenom = readString(dis);
					
					this.joueur2_nationalite = readString(dis);
					
						this.seed = readInteger(dis);
					
					this.round = readString(dis);
					
					this.score = readString(dis);
					
					this.resultat = readString(dis);
					
					this.date_tournoi = readDate(dis);
					
					this.nom_tournoi = readString(dis);
					
					this.lieu_tournoi = readString(dis);
					
						this.prize_money = (BigDecimal) dis.readObject();
					
						this.points = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep) {

        	try {

        		int length = 0;
		
					this.joueur1_nom = readString(dis);
					
					this.joueur1_prenom = readString(dis);
					
					this.joueur1_nationalite = readString(dis);
					
					this.joueur2_nom = readString(dis);
					
					this.joueur2_prenom = readString(dis);
					
					this.joueur2_nationalite = readString(dis);
					
						this.seed = readInteger(dis);
					
					this.round = readString(dis);
					
					this.score = readString(dis);
					
					this.resultat = readString(dis);
					
					this.date_tournoi = readDate(dis);
					
					this.nom_tournoi = readString(dis);
					
					this.lieu_tournoi = readString(dis);
					
						this.prize_money = (BigDecimal) dis.readObject();
					
						this.points = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.joueur1_nom,dos);
					
					// String
				
						writeString(this.joueur1_prenom,dos);
					
					// String
				
						writeString(this.joueur1_nationalite,dos);
					
					// String
				
						writeString(this.joueur2_nom,dos);
					
					// String
				
						writeString(this.joueur2_prenom,dos);
					
					// String
				
						writeString(this.joueur2_nationalite,dos);
					
					// Integer
				
						writeInteger(this.seed,dos);
					
					// String
				
						writeString(this.round,dos);
					
					// String
				
						writeString(this.score,dos);
					
					// String
				
						writeString(this.resultat,dos);
					
					// java.util.Date
				
						writeDate(this.date_tournoi,dos);
					
					// String
				
						writeString(this.nom_tournoi,dos);
					
					// String
				
						writeString(this.lieu_tournoi,dos);
					
					// BigDecimal
				
       			    	dos.writeObject(this.prize_money);
					
					// Integer
				
						writeInteger(this.points,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.joueur1_nom,dos);
					
					// String
				
						writeString(this.joueur1_prenom,dos);
					
					// String
				
						writeString(this.joueur1_nationalite,dos);
					
					// String
				
						writeString(this.joueur2_nom,dos);
					
					// String
				
						writeString(this.joueur2_prenom,dos);
					
					// String
				
						writeString(this.joueur2_nationalite,dos);
					
					// Integer
				
						writeInteger(this.seed,dos);
					
					// String
				
						writeString(this.round,dos);
					
					// String
				
						writeString(this.score,dos);
					
					// String
				
						writeString(this.resultat,dos);
					
					// java.util.Date
				
						writeDate(this.date_tournoi,dos);
					
					// String
				
						writeString(this.nom_tournoi,dos);
					
					// String
				
						writeString(this.lieu_tournoi,dos);
					
					// BigDecimal
				
       			    	dos.writeObject(this.prize_money);
					
					// Integer
				
						writeInteger(this.points,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("joueur1_nom="+joueur1_nom);
		sb.append(",joueur1_prenom="+joueur1_prenom);
		sb.append(",joueur1_nationalite="+joueur1_nationalite);
		sb.append(",joueur2_nom="+joueur2_nom);
		sb.append(",joueur2_prenom="+joueur2_prenom);
		sb.append(",joueur2_nationalite="+joueur2_nationalite);
		sb.append(",seed="+String.valueOf(seed));
		sb.append(",round="+round);
		sb.append(",score="+score);
		sb.append(",resultat="+resultat);
		sb.append(",date_tournoi="+String.valueOf(date_tournoi));
		sb.append(",nom_tournoi="+nom_tournoi);
		sb.append(",lieu_tournoi="+lieu_tournoi);
		sb.append(",prize_money="+String.valueOf(prize_money));
		sb.append(",points="+String.valueOf(points));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row19Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tFileInputDelimited_10Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tFileInputDelimited_10_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row19Struct row19 = new row19Struct();
row19Struct row20 = row19;





	
	/**
	 * [tDBOutput_10 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBOutput_10", false);
		start_Hash.put("tDBOutput_10", System.currentTimeMillis());
		
	
	currentComponent="tDBOutput_10";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row20");
					}
				
		int tos_count_tDBOutput_10 = 0;
		





String dbschema_tDBOutput_10 = null;
	dbschema_tDBOutput_10 = "sa";
	

String tableName_tDBOutput_10 = null;
if(dbschema_tDBOutput_10 == null || dbschema_tDBOutput_10.trim().length() == 0) {
	tableName_tDBOutput_10 = ("sa_tournament_sep");
} else {
	tableName_tDBOutput_10 = dbschema_tDBOutput_10 + "\".\"" + ("sa_tournament_sep");
}


int nb_line_tDBOutput_10 = 0;
int nb_line_update_tDBOutput_10 = 0;
int nb_line_inserted_tDBOutput_10 = 0;
int nb_line_deleted_tDBOutput_10 = 0;
int nb_line_rejected_tDBOutput_10 = 0;

int deletedCount_tDBOutput_10=0;
int updatedCount_tDBOutput_10=0;
int insertedCount_tDBOutput_10=0;
int rowsToCommitCount_tDBOutput_10=0;
int rejectedCount_tDBOutput_10=0;

boolean whetherReject_tDBOutput_10 = false;

java.sql.Connection conn_tDBOutput_10 = null;
String dbUser_tDBOutput_10 = null;

	
    java.lang.Class.forName("org.postgresql.Driver");
    
        String url_tDBOutput_10 = "jdbc:postgresql://"+"localhost"+":"+"5432"+"/"+"padel_bi_SA";
    dbUser_tDBOutput_10 = "postgres";
 
	final String decryptedPassword_tDBOutput_10 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:GSh/7KAqCx65m6p18zcnzGFsqIqIDW3QiqWpBqSYEC5uQdr6cw==");

    String dbPwd_tDBOutput_10 = decryptedPassword_tDBOutput_10;

    conn_tDBOutput_10 = java.sql.DriverManager.getConnection(url_tDBOutput_10,dbUser_tDBOutput_10,dbPwd_tDBOutput_10);
	
	resourceMap.put("conn_tDBOutput_10", conn_tDBOutput_10);
        conn_tDBOutput_10.setAutoCommit(false);
        int commitEvery_tDBOutput_10 = 10000;
        int commitCounter_tDBOutput_10 = 0;


   int batchSize_tDBOutput_10 = 10000;
   int batchSizeCounter_tDBOutput_10=0;

int count_tDBOutput_10=0;
	    String insert_tDBOutput_10 = "INSERT INTO \"" + tableName_tDBOutput_10 + "\" (\"joueur1_nom\",\"joueur1_prenom\",\"joueur1_nationalite\",\"joueur2_nom\",\"joueur2_prenom\",\"joueur2_nationalite\",\"seed\",\"round\",\"score\",\"resultat\",\"date_tournoi\",\"nom_tournoi\",\"lieu_tournoi\",\"prize_money\",\"points\") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	    
	    java.sql.PreparedStatement pstmt_tDBOutput_10 = conn_tDBOutput_10.prepareStatement(insert_tDBOutput_10);
	    resourceMap.put("pstmt_tDBOutput_10", pstmt_tDBOutput_10);
	    

 



/**
 * [tDBOutput_10 begin ] stop
 */



	
	/**
	 * [tLogRow_10 begin ] start
	 */

	

	
		
		ok_Hash.put("tLogRow_10", false);
		start_Hash.put("tLogRow_10", System.currentTimeMillis());
		
	
	currentComponent="tLogRow_10";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row19");
					}
				
		int tos_count_tLogRow_10 = 0;
		

	///////////////////////
	
         class Util_tLogRow_10 {

        String[] des_top = { ".", ".", "-", "+" };

        String[] des_head = { "|=", "=|", "-", "+" };

        String[] des_bottom = { "'", "'", "-", "+" };

        String name="";

        java.util.List<String[]> list = new java.util.ArrayList<String[]>();

        int[] colLengths = new int[15];

        public void addRow(String[] row) {

            for (int i = 0; i < 15; i++) {
                if (row[i]!=null) {
                  colLengths[i] = Math.max(colLengths[i], row[i].length());
                }
            }
            list.add(row);
        }

        public void setTableName(String name) {

            this.name = name;
        }

            public StringBuilder format() {
            
                StringBuilder sb = new StringBuilder();
  
            
                    sb.append(print(des_top));
    
                    int totals = 0;
                    for (int i = 0; i < colLengths.length; i++) {
                        totals = totals + colLengths[i];
                    }
    
                    // name
                    sb.append("|");
                    int k = 0;
                    for (k = 0; k < (totals + 14 - name.length()) / 2; k++) {
                        sb.append(' ');
                    }
                    sb.append(name);
                    for (int i = 0; i < totals + 14 - name.length() - k; i++) {
                        sb.append(' ');
                    }
                    sb.append("|\n");

                    // head and rows
                    sb.append(print(des_head));
                    for (int i = 0; i < list.size(); i++) {
    
                        String[] row = list.get(i);
    
                        java.util.Formatter formatter = new java.util.Formatter(new StringBuilder());
                        
                        StringBuilder sbformat = new StringBuilder();                                             
        			        sbformat.append("|%1$-");
        			        sbformat.append(colLengths[0]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%2$-");
        			        sbformat.append(colLengths[1]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%3$-");
        			        sbformat.append(colLengths[2]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%4$-");
        			        sbformat.append(colLengths[3]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%5$-");
        			        sbformat.append(colLengths[4]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%6$-");
        			        sbformat.append(colLengths[5]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%7$-");
        			        sbformat.append(colLengths[6]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%8$-");
        			        sbformat.append(colLengths[7]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%9$-");
        			        sbformat.append(colLengths[8]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%10$-");
        			        sbformat.append(colLengths[9]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%11$-");
        			        sbformat.append(colLengths[10]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%12$-");
        			        sbformat.append(colLengths[11]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%13$-");
        			        sbformat.append(colLengths[12]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%14$-");
        			        sbformat.append(colLengths[13]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%15$-");
        			        sbformat.append(colLengths[14]);
        			        sbformat.append("s");
        			                      
                        sbformat.append("|\n");                    
       
                        formatter.format(sbformat.toString(), (Object[])row);	
                                
                        sb.append(formatter.toString());
                        if (i == 0)
                            sb.append(print(des_head)); // print the head
                    }
    
                    // end
                    sb.append(print(des_bottom));
                    return sb;
                }
            

            private StringBuilder print(String[] fillChars) {
                StringBuilder sb = new StringBuilder();
                //first column
                sb.append(fillChars[0]);                
                    for (int i = 0; i < colLengths[0] - fillChars[0].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);	                

                    for (int i = 0; i < colLengths[1] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[2] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[3] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[4] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[5] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[6] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[7] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[8] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[9] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[10] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[11] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[12] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[13] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                
                    //last column
                    for (int i = 0; i < colLengths[14] - fillChars[1].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }         
                sb.append(fillChars[1]);
                sb.append("\n");               
                return sb;
            }
            
            public boolean isTableEmpty(){
            	if (list.size() > 1)
            		return false;
            	return true;
            }
        }
        Util_tLogRow_10 util_tLogRow_10 = new Util_tLogRow_10();
        util_tLogRow_10.setTableName("tLogRow_10");
        util_tLogRow_10.addRow(new String[]{"joueur1_nom","joueur1_prenom","joueur1_nationalite","joueur2_nom","joueur2_prenom","joueur2_nationalite","seed","round","score","resultat","date_tournoi","nom_tournoi","lieu_tournoi","prize_money","points",});        
 		StringBuilder strBuffer_tLogRow_10 = null;
		int nb_line_tLogRow_10 = 0;
///////////////////////    			



 



/**
 * [tLogRow_10 begin ] stop
 */



	
	/**
	 * [tFileInputDelimited_10 begin ] start
	 */

	

	
		
		ok_Hash.put("tFileInputDelimited_10", false);
		start_Hash.put("tFileInputDelimited_10", System.currentTimeMillis());
		
	
	currentComponent="tFileInputDelimited_10";

	
		int tos_count_tFileInputDelimited_10 = 0;
		
	
	
	
 
	
	
	final routines.system.RowState rowstate_tFileInputDelimited_10 = new routines.system.RowState();
	
	
				int nb_line_tFileInputDelimited_10 = 0;
				org.talend.fileprocess.FileInputDelimited fid_tFileInputDelimited_10 = null;
				int limit_tFileInputDelimited_10 = -1;
				try{
					
						Object filename_tFileInputDelimited_10 = "C:/Users/ASUS/Downloads/Sports/Sports/script_tournois/sep.csv";
						if(filename_tFileInputDelimited_10 instanceof java.io.InputStream){
							
			int footer_value_tFileInputDelimited_10 = 0, random_value_tFileInputDelimited_10 = -1;
			if(footer_value_tFileInputDelimited_10 >0 || random_value_tFileInputDelimited_10 > 0){
				throw new java.lang.Exception("When the input source is a stream,footer and random shouldn't be bigger than 0.");				
			}
		
						}
						try {
							fid_tFileInputDelimited_10 = new org.talend.fileprocess.FileInputDelimited("C:/Users/ASUS/Downloads/Sports/Sports/script_tournois/sep.csv", "ISO-8859-15",";","\n",true,1,0,
									limit_tFileInputDelimited_10
								,-1, false);
						} catch(java.lang.Exception e) {
globalMap.put("tFileInputDelimited_10_ERROR_MESSAGE",e.getMessage());
							
								
								System.err.println(e.getMessage());
							
						}
					
				    
					while (fid_tFileInputDelimited_10!=null && fid_tFileInputDelimited_10.nextRecord()) {
						rowstate_tFileInputDelimited_10.reset();
						
			    						row19 = null;			
												
									boolean whetherReject_tFileInputDelimited_10 = false;
									row19 = new row19Struct();
									try {
										
				int columnIndexWithD_tFileInputDelimited_10 = 0;
				
					String temp = ""; 
				
					columnIndexWithD_tFileInputDelimited_10 = 0;
					
							row19.joueur1_nom = fid_tFileInputDelimited_10.get(columnIndexWithD_tFileInputDelimited_10);
						
				
					columnIndexWithD_tFileInputDelimited_10 = 1;
					
							row19.joueur1_prenom = fid_tFileInputDelimited_10.get(columnIndexWithD_tFileInputDelimited_10);
						
				
					columnIndexWithD_tFileInputDelimited_10 = 2;
					
							row19.joueur1_nationalite = fid_tFileInputDelimited_10.get(columnIndexWithD_tFileInputDelimited_10);
						
				
					columnIndexWithD_tFileInputDelimited_10 = 3;
					
							row19.joueur2_nom = fid_tFileInputDelimited_10.get(columnIndexWithD_tFileInputDelimited_10);
						
				
					columnIndexWithD_tFileInputDelimited_10 = 4;
					
							row19.joueur2_prenom = fid_tFileInputDelimited_10.get(columnIndexWithD_tFileInputDelimited_10);
						
				
					columnIndexWithD_tFileInputDelimited_10 = 5;
					
							row19.joueur2_nationalite = fid_tFileInputDelimited_10.get(columnIndexWithD_tFileInputDelimited_10);
						
				
					columnIndexWithD_tFileInputDelimited_10 = 6;
					
						temp = fid_tFileInputDelimited_10.get(columnIndexWithD_tFileInputDelimited_10);
						if(temp.length() > 0) {
							
								try {
								
    								row19.seed = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_10) {
globalMap.put("tFileInputDelimited_10_ERROR_MESSAGE",ex_tFileInputDelimited_10.getMessage());
									rowstate_tFileInputDelimited_10.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"seed", "row19", temp, ex_tFileInputDelimited_10), ex_tFileInputDelimited_10));
								}
    							
						} else {						
							
								
									row19.seed = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_10 = 7;
					
							row19.round = fid_tFileInputDelimited_10.get(columnIndexWithD_tFileInputDelimited_10);
						
				
					columnIndexWithD_tFileInputDelimited_10 = 8;
					
							row19.score = fid_tFileInputDelimited_10.get(columnIndexWithD_tFileInputDelimited_10);
						
				
					columnIndexWithD_tFileInputDelimited_10 = 9;
					
							row19.resultat = fid_tFileInputDelimited_10.get(columnIndexWithD_tFileInputDelimited_10);
						
				
					columnIndexWithD_tFileInputDelimited_10 = 10;
					
						temp = fid_tFileInputDelimited_10.get(columnIndexWithD_tFileInputDelimited_10);
						if(temp.length() > 0) {
							
								try {
								
    									row19.date_tournoi = ParserUtils.parseTo_Date(temp, "yyyy-MM-dd");
    								
    							} catch(java.lang.Exception ex_tFileInputDelimited_10) {
globalMap.put("tFileInputDelimited_10_ERROR_MESSAGE",ex_tFileInputDelimited_10.getMessage());
									rowstate_tFileInputDelimited_10.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"date_tournoi", "row19", temp, ex_tFileInputDelimited_10), ex_tFileInputDelimited_10));
								}
    							
						} else {						
							
								
									row19.date_tournoi = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_10 = 11;
					
							row19.nom_tournoi = fid_tFileInputDelimited_10.get(columnIndexWithD_tFileInputDelimited_10);
						
				
					columnIndexWithD_tFileInputDelimited_10 = 12;
					
							row19.lieu_tournoi = fid_tFileInputDelimited_10.get(columnIndexWithD_tFileInputDelimited_10);
						
				
					columnIndexWithD_tFileInputDelimited_10 = 13;
					
						temp = fid_tFileInputDelimited_10.get(columnIndexWithD_tFileInputDelimited_10);
						if(temp.length() > 0) {
							
								try {
								
    								row19.prize_money = ParserUtils.parseTo_BigDecimal(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_10) {
globalMap.put("tFileInputDelimited_10_ERROR_MESSAGE",ex_tFileInputDelimited_10.getMessage());
									rowstate_tFileInputDelimited_10.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"prize_money", "row19", temp, ex_tFileInputDelimited_10), ex_tFileInputDelimited_10));
								}
    							
						} else {						
							
								
									row19.prize_money = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_10 = 14;
					
						temp = fid_tFileInputDelimited_10.get(columnIndexWithD_tFileInputDelimited_10);
						if(temp.length() > 0) {
							
								try {
								
    								row19.points = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_10) {
globalMap.put("tFileInputDelimited_10_ERROR_MESSAGE",ex_tFileInputDelimited_10.getMessage());
									rowstate_tFileInputDelimited_10.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"points", "row19", temp, ex_tFileInputDelimited_10), ex_tFileInputDelimited_10));
								}
    							
						} else {						
							
								
									row19.points = null;
								
							
						}
					
				
				
										
										if(rowstate_tFileInputDelimited_10.getException()!=null) {
											throw rowstate_tFileInputDelimited_10.getException();
										}
										
										
							
			    					} catch (java.lang.Exception e) {
globalMap.put("tFileInputDelimited_10_ERROR_MESSAGE",e.getMessage());
			        					whetherReject_tFileInputDelimited_10 = true;
			        					
			                					System.err.println(e.getMessage());
			                					row19 = null;
			                				
										
			    					}
								

 



/**
 * [tFileInputDelimited_10 begin ] stop
 */
	
	/**
	 * [tFileInputDelimited_10 main ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_10";

	

 


	tos_count_tFileInputDelimited_10++;

/**
 * [tFileInputDelimited_10 main ] stop
 */
	
	/**
	 * [tFileInputDelimited_10 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_10";

	

 



/**
 * [tFileInputDelimited_10 process_data_begin ] stop
 */
// Start of branch "row19"
if(row19 != null) { 



	
	/**
	 * [tLogRow_10 main ] start
	 */

	

	
	
	currentComponent="tLogRow_10";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row19"
						
						);
					}
					
///////////////////////		
						

				
				String[] row_tLogRow_10 = new String[15];
   				
	    		if(row19.joueur1_nom != null) { //              
                 row_tLogRow_10[0]=    						    
				                String.valueOf(row19.joueur1_nom)			
					          ;	
							
	    		} //			
    			   				
	    		if(row19.joueur1_prenom != null) { //              
                 row_tLogRow_10[1]=    						    
				                String.valueOf(row19.joueur1_prenom)			
					          ;	
							
	    		} //			
    			   				
	    		if(row19.joueur1_nationalite != null) { //              
                 row_tLogRow_10[2]=    						    
				                String.valueOf(row19.joueur1_nationalite)			
					          ;	
							
	    		} //			
    			   				
	    		if(row19.joueur2_nom != null) { //              
                 row_tLogRow_10[3]=    						    
				                String.valueOf(row19.joueur2_nom)			
					          ;	
							
	    		} //			
    			   				
	    		if(row19.joueur2_prenom != null) { //              
                 row_tLogRow_10[4]=    						    
				                String.valueOf(row19.joueur2_prenom)			
					          ;	
							
	    		} //			
    			   				
	    		if(row19.joueur2_nationalite != null) { //              
                 row_tLogRow_10[5]=    						    
				                String.valueOf(row19.joueur2_nationalite)			
					          ;	
							
	    		} //			
    			   				
	    		if(row19.seed != null) { //              
                 row_tLogRow_10[6]=    						    
				                String.valueOf(row19.seed)			
					          ;	
							
	    		} //			
    			   				
	    		if(row19.round != null) { //              
                 row_tLogRow_10[7]=    						    
				                String.valueOf(row19.round)			
					          ;	
							
	    		} //			
    			   				
	    		if(row19.score != null) { //              
                 row_tLogRow_10[8]=    						    
				                String.valueOf(row19.score)			
					          ;	
							
	    		} //			
    			   				
	    		if(row19.resultat != null) { //              
                 row_tLogRow_10[9]=    						    
				                String.valueOf(row19.resultat)			
					          ;	
							
	    		} //			
    			   				
	    		if(row19.date_tournoi != null) { //              
                 row_tLogRow_10[10]=    						
								FormatterUtils.format_Date(row19.date_tournoi, "yyyy-MM-dd")
					          ;	
							
	    		} //			
    			   				
	    		if(row19.nom_tournoi != null) { //              
                 row_tLogRow_10[11]=    						    
				                String.valueOf(row19.nom_tournoi)			
					          ;	
							
	    		} //			
    			   				
	    		if(row19.lieu_tournoi != null) { //              
                 row_tLogRow_10[12]=    						    
				                String.valueOf(row19.lieu_tournoi)			
					          ;	
							
	    		} //			
    			   				
	    		if(row19.prize_money != null) { //              
                 row_tLogRow_10[13]=    						
								row19.prize_money.toPlainString()
					          ;	
							
	    		} //			
    			   				
	    		if(row19.points != null) { //              
                 row_tLogRow_10[14]=    						    
				                String.valueOf(row19.points)			
					          ;	
							
	    		} //			
    			 

				util_tLogRow_10.addRow(row_tLogRow_10);	
				nb_line_tLogRow_10++;
//////

//////                    
                    
///////////////////////    			

 
     row20 = row19;


	tos_count_tLogRow_10++;

/**
 * [tLogRow_10 main ] stop
 */
	
	/**
	 * [tLogRow_10 process_data_begin ] start
	 */

	

	
	
	currentComponent="tLogRow_10";

	

 



/**
 * [tLogRow_10 process_data_begin ] stop
 */

	
	/**
	 * [tDBOutput_10 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_10";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row20"
						
						);
					}
					



        whetherReject_tDBOutput_10 = false;
                    if(row20.joueur1_nom == null) {
pstmt_tDBOutput_10.setNull(1, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_10.setString(1, row20.joueur1_nom);
}

                    if(row20.joueur1_prenom == null) {
pstmt_tDBOutput_10.setNull(2, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_10.setString(2, row20.joueur1_prenom);
}

                    if(row20.joueur1_nationalite == null) {
pstmt_tDBOutput_10.setNull(3, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_10.setString(3, row20.joueur1_nationalite);
}

                    if(row20.joueur2_nom == null) {
pstmt_tDBOutput_10.setNull(4, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_10.setString(4, row20.joueur2_nom);
}

                    if(row20.joueur2_prenom == null) {
pstmt_tDBOutput_10.setNull(5, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_10.setString(5, row20.joueur2_prenom);
}

                    if(row20.joueur2_nationalite == null) {
pstmt_tDBOutput_10.setNull(6, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_10.setString(6, row20.joueur2_nationalite);
}

                    if(row20.seed == null) {
pstmt_tDBOutput_10.setNull(7, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_10.setInt(7, row20.seed);
}

                    if(row20.round == null) {
pstmt_tDBOutput_10.setNull(8, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_10.setString(8, row20.round);
}

                    if(row20.score == null) {
pstmt_tDBOutput_10.setNull(9, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_10.setString(9, row20.score);
}

                    if(row20.resultat == null) {
pstmt_tDBOutput_10.setNull(10, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_10.setString(10, row20.resultat);
}

                    if(row20.date_tournoi != null) {
pstmt_tDBOutput_10.setTimestamp(11, new java.sql.Timestamp(row20.date_tournoi.getTime()));
} else {
pstmt_tDBOutput_10.setNull(11, java.sql.Types.TIMESTAMP);
}

                    if(row20.nom_tournoi == null) {
pstmt_tDBOutput_10.setNull(12, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_10.setString(12, row20.nom_tournoi);
}

                    if(row20.lieu_tournoi == null) {
pstmt_tDBOutput_10.setNull(13, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_10.setString(13, row20.lieu_tournoi);
}

                    pstmt_tDBOutput_10.setBigDecimal(14, row20.prize_money);

                    if(row20.points == null) {
pstmt_tDBOutput_10.setNull(15, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_10.setInt(15, row20.points);
}

			
    		pstmt_tDBOutput_10.addBatch();
    		nb_line_tDBOutput_10++;
    		  
    		  
    		  batchSizeCounter_tDBOutput_10++;
    		  
    			if ((batchSize_tDBOutput_10 > 0) && (batchSize_tDBOutput_10 <= batchSizeCounter_tDBOutput_10)) {
                try {
						int countSum_tDBOutput_10 = 0;
						    
						for(int countEach_tDBOutput_10: pstmt_tDBOutput_10.executeBatch()) {
							countSum_tDBOutput_10 += (countEach_tDBOutput_10 < 0 ? 0 : countEach_tDBOutput_10);
						}
				    	rowsToCommitCount_tDBOutput_10 += countSum_tDBOutput_10;
				    	
				    		insertedCount_tDBOutput_10 += countSum_tDBOutput_10;
				    	
            	    	batchSizeCounter_tDBOutput_10 = 0;
                }catch (java.sql.BatchUpdateException e_tDBOutput_10){
globalMap.put("tDBOutput_10_ERROR_MESSAGE",e_tDBOutput_10.getMessage());
				    	java.sql.SQLException ne_tDBOutput_10 = e_tDBOutput_10.getNextException(),sqle_tDBOutput_10=null;
				    	String errormessage_tDBOutput_10;
						if (ne_tDBOutput_10 != null) {
							// build new exception to provide the original cause
							sqle_tDBOutput_10 = new java.sql.SQLException(e_tDBOutput_10.getMessage() + "\ncaused by: " + ne_tDBOutput_10.getMessage(), ne_tDBOutput_10.getSQLState(), ne_tDBOutput_10.getErrorCode(), ne_tDBOutput_10);
							errormessage_tDBOutput_10 = sqle_tDBOutput_10.getMessage();
						}else{
							errormessage_tDBOutput_10 = e_tDBOutput_10.getMessage();
						}
				    	
				    	int countSum_tDBOutput_10 = 0;
						for(int countEach_tDBOutput_10: e_tDBOutput_10.getUpdateCounts()) {
							countSum_tDBOutput_10 += (countEach_tDBOutput_10 < 0 ? 0 : countEach_tDBOutput_10);
						}
						rowsToCommitCount_tDBOutput_10 += countSum_tDBOutput_10;
						
				    		insertedCount_tDBOutput_10 += countSum_tDBOutput_10;
				    	
				    	System.err.println(errormessage_tDBOutput_10);
				    	
					}
    			}
    		
    		    commitCounter_tDBOutput_10++;
                if(commitEvery_tDBOutput_10 <= commitCounter_tDBOutput_10) {
                if ((batchSize_tDBOutput_10 > 0) && (batchSizeCounter_tDBOutput_10 > 0)) {
                try {
                		int countSum_tDBOutput_10 = 0;
                		    
						for(int countEach_tDBOutput_10: pstmt_tDBOutput_10.executeBatch()) {
							countSum_tDBOutput_10 += (countEach_tDBOutput_10 < 0 ? 0 : countEach_tDBOutput_10);
						}
            	    	rowsToCommitCount_tDBOutput_10 += countSum_tDBOutput_10;
            	    	
            	    		insertedCount_tDBOutput_10 += countSum_tDBOutput_10;
            	    	
                batchSizeCounter_tDBOutput_10 = 0;
               }catch (java.sql.BatchUpdateException e_tDBOutput_10){
globalMap.put("tDBOutput_10_ERROR_MESSAGE",e_tDBOutput_10.getMessage());
			    	java.sql.SQLException ne_tDBOutput_10 = e_tDBOutput_10.getNextException(),sqle_tDBOutput_10=null;
			    	String errormessage_tDBOutput_10;
					if (ne_tDBOutput_10 != null) {
						// build new exception to provide the original cause
						sqle_tDBOutput_10 = new java.sql.SQLException(e_tDBOutput_10.getMessage() + "\ncaused by: " + ne_tDBOutput_10.getMessage(), ne_tDBOutput_10.getSQLState(), ne_tDBOutput_10.getErrorCode(), ne_tDBOutput_10);
						errormessage_tDBOutput_10 = sqle_tDBOutput_10.getMessage();
					}else{
						errormessage_tDBOutput_10 = e_tDBOutput_10.getMessage();
					}
			    	
			    	int countSum_tDBOutput_10 = 0;
					for(int countEach_tDBOutput_10: e_tDBOutput_10.getUpdateCounts()) {
						countSum_tDBOutput_10 += (countEach_tDBOutput_10 < 0 ? 0 : countEach_tDBOutput_10);
					}
					rowsToCommitCount_tDBOutput_10 += countSum_tDBOutput_10;
					
			    		insertedCount_tDBOutput_10 += countSum_tDBOutput_10;
			    	
			    	System.err.println(errormessage_tDBOutput_10);
			    	
				}
            }
                    if(rowsToCommitCount_tDBOutput_10 != 0){
                    	
                    }
                    conn_tDBOutput_10.commit();
                    if(rowsToCommitCount_tDBOutput_10 != 0){
                    	
                    	rowsToCommitCount_tDBOutput_10 = 0;
                    }
                    commitCounter_tDBOutput_10=0;
                }

 


	tos_count_tDBOutput_10++;

/**
 * [tDBOutput_10 main ] stop
 */
	
	/**
	 * [tDBOutput_10 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBOutput_10";

	

 



/**
 * [tDBOutput_10 process_data_begin ] stop
 */
	
	/**
	 * [tDBOutput_10 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBOutput_10";

	

 



/**
 * [tDBOutput_10 process_data_end ] stop
 */



	
	/**
	 * [tLogRow_10 process_data_end ] start
	 */

	

	
	
	currentComponent="tLogRow_10";

	

 



/**
 * [tLogRow_10 process_data_end ] stop
 */

} // End of branch "row19"




	
	/**
	 * [tFileInputDelimited_10 process_data_end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_10";

	

 



/**
 * [tFileInputDelimited_10 process_data_end ] stop
 */
	
	/**
	 * [tFileInputDelimited_10 end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_10";

	



            }
            }finally{
                if(!((Object)("C:/Users/ASUS/Downloads/Sports/Sports/script_tournois/sep.csv") instanceof java.io.InputStream)){
                	if(fid_tFileInputDelimited_10!=null){
                		fid_tFileInputDelimited_10.close();
                	}
                }
                if(fid_tFileInputDelimited_10!=null){
                	globalMap.put("tFileInputDelimited_10_NB_LINE", fid_tFileInputDelimited_10.getRowNumber());
					
                }
			}
			  

 

ok_Hash.put("tFileInputDelimited_10", true);
end_Hash.put("tFileInputDelimited_10", System.currentTimeMillis());




/**
 * [tFileInputDelimited_10 end ] stop
 */

	
	/**
	 * [tLogRow_10 end ] start
	 */

	

	
	
	currentComponent="tLogRow_10";

	


//////

                    
                    java.io.PrintStream consoleOut_tLogRow_10 = null;
                    if (globalMap.get("tLogRow_CONSOLE")!=null)
                    {
                    	consoleOut_tLogRow_10 = (java.io.PrintStream) globalMap.get("tLogRow_CONSOLE");
                    }
                    else
                    {
                    	consoleOut_tLogRow_10 = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));
                    	globalMap.put("tLogRow_CONSOLE",consoleOut_tLogRow_10);
                    }
                    
                    consoleOut_tLogRow_10.println(util_tLogRow_10.format().toString());
                    consoleOut_tLogRow_10.flush();
//////
globalMap.put("tLogRow_10_NB_LINE",nb_line_tLogRow_10);

///////////////////////    			

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row19");
			  	}
			  	
 

ok_Hash.put("tLogRow_10", true);
end_Hash.put("tLogRow_10", System.currentTimeMillis());




/**
 * [tLogRow_10 end ] stop
 */

	
	/**
	 * [tDBOutput_10 end ] start
	 */

	

	
	
	currentComponent="tDBOutput_10";

	



	    try {
				int countSum_tDBOutput_10 = 0;
				if (pstmt_tDBOutput_10 != null && batchSizeCounter_tDBOutput_10 > 0) {
						
					for(int countEach_tDBOutput_10: pstmt_tDBOutput_10.executeBatch()) {
						countSum_tDBOutput_10 += (countEach_tDBOutput_10 < 0 ? 0 : countEach_tDBOutput_10);
					}
					rowsToCommitCount_tDBOutput_10 += countSum_tDBOutput_10;
						
				}
		    	
		    		insertedCount_tDBOutput_10 += countSum_tDBOutput_10;
		    	
	    }catch (java.sql.BatchUpdateException e_tDBOutput_10){
globalMap.put("tDBOutput_10_ERROR_MESSAGE",e_tDBOutput_10.getMessage());
	    	java.sql.SQLException ne_tDBOutput_10 = e_tDBOutput_10.getNextException(),sqle_tDBOutput_10=null;
	    	String errormessage_tDBOutput_10;
			if (ne_tDBOutput_10 != null) {
				// build new exception to provide the original cause
				sqle_tDBOutput_10 = new java.sql.SQLException(e_tDBOutput_10.getMessage() + "\ncaused by: " + ne_tDBOutput_10.getMessage(), ne_tDBOutput_10.getSQLState(), ne_tDBOutput_10.getErrorCode(), ne_tDBOutput_10);
				errormessage_tDBOutput_10 = sqle_tDBOutput_10.getMessage();
			}else{
				errormessage_tDBOutput_10 = e_tDBOutput_10.getMessage();
			}
	    	
	    	int countSum_tDBOutput_10 = 0;
			for(int countEach_tDBOutput_10: e_tDBOutput_10.getUpdateCounts()) {
				countSum_tDBOutput_10 += (countEach_tDBOutput_10 < 0 ? 0 : countEach_tDBOutput_10);
			}
			rowsToCommitCount_tDBOutput_10 += countSum_tDBOutput_10;
			
	    		insertedCount_tDBOutput_10 += countSum_tDBOutput_10;
	    	
	    	System.err.println(errormessage_tDBOutput_10);
	    	
		}
	    
        if(pstmt_tDBOutput_10 != null) {
        		
            pstmt_tDBOutput_10.close();
            resourceMap.remove("pstmt_tDBOutput_10");
        }
    resourceMap.put("statementClosed_tDBOutput_10", true);
			if(rowsToCommitCount_tDBOutput_10 != 0){
				
			}
			conn_tDBOutput_10.commit();
			if(rowsToCommitCount_tDBOutput_10 != 0){
				
				rowsToCommitCount_tDBOutput_10 = 0;
			}
			commitCounter_tDBOutput_10 = 0;
		
    	conn_tDBOutput_10 .close();
    	
    	resourceMap.put("finish_tDBOutput_10", true);
    	

	nb_line_deleted_tDBOutput_10=nb_line_deleted_tDBOutput_10+ deletedCount_tDBOutput_10;
	nb_line_update_tDBOutput_10=nb_line_update_tDBOutput_10 + updatedCount_tDBOutput_10;
	nb_line_inserted_tDBOutput_10=nb_line_inserted_tDBOutput_10 + insertedCount_tDBOutput_10;
	nb_line_rejected_tDBOutput_10=nb_line_rejected_tDBOutput_10 + rejectedCount_tDBOutput_10;
	
        globalMap.put("tDBOutput_10_NB_LINE",nb_line_tDBOutput_10);
        globalMap.put("tDBOutput_10_NB_LINE_UPDATED",nb_line_update_tDBOutput_10);
        globalMap.put("tDBOutput_10_NB_LINE_INSERTED",nb_line_inserted_tDBOutput_10);
        globalMap.put("tDBOutput_10_NB_LINE_DELETED",nb_line_deleted_tDBOutput_10);
        globalMap.put("tDBOutput_10_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_10);
    

	


				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row20");
			  	}
			  	
 

ok_Hash.put("tDBOutput_10", true);
end_Hash.put("tDBOutput_10", System.currentTimeMillis());




/**
 * [tDBOutput_10 end ] stop
 */






				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tFileInputDelimited_10 finally ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_10";

	

 



/**
 * [tFileInputDelimited_10 finally ] stop
 */

	
	/**
	 * [tLogRow_10 finally ] start
	 */

	

	
	
	currentComponent="tLogRow_10";

	

 



/**
 * [tLogRow_10 finally ] stop
 */

	
	/**
	 * [tDBOutput_10 finally ] start
	 */

	

	
	
	currentComponent="tDBOutput_10";

	



    try {
    if (resourceMap.get("statementClosed_tDBOutput_10") == null) {
                java.sql.PreparedStatement pstmtToClose_tDBOutput_10 = null;
                if ((pstmtToClose_tDBOutput_10 = (java.sql.PreparedStatement) resourceMap.remove("pstmt_tDBOutput_10")) != null) {
                    pstmtToClose_tDBOutput_10.close();
                }
    }
    } finally {
        if(resourceMap.get("finish_tDBOutput_10") == null){
            java.sql.Connection ctn_tDBOutput_10 = null;
            if((ctn_tDBOutput_10 = (java.sql.Connection)resourceMap.get("conn_tDBOutput_10")) != null){
                try {
                    ctn_tDBOutput_10.close();
                } catch (java.sql.SQLException sqlEx_tDBOutput_10) {
                    String errorMessage_tDBOutput_10 = "failed to close the connection in tDBOutput_10 :" + sqlEx_tDBOutput_10.getMessage();
                    System.err.println(errorMessage_tDBOutput_10);
                }
            }
        }
    }
 



/**
 * [tDBOutput_10 finally ] stop
 */






				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tFileInputDelimited_10_SUBPROCESS_STATE", 1);
	}
	


public static class row22Struct implements routines.system.IPersistableRow<row22Struct> {
    final static byte[] commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[0];
    static byte[] commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[0];

	
			    public String joueur1_nom;

				public String getJoueur1_nom () {
					return this.joueur1_nom;
				}
				
			    public String joueur1_prenom;

				public String getJoueur1_prenom () {
					return this.joueur1_prenom;
				}
				
			    public String joueur1_nationalite;

				public String getJoueur1_nationalite () {
					return this.joueur1_nationalite;
				}
				
			    public String joueur2_nom;

				public String getJoueur2_nom () {
					return this.joueur2_nom;
				}
				
			    public String joueur2_prenom;

				public String getJoueur2_prenom () {
					return this.joueur2_prenom;
				}
				
			    public String joueur2_nationalite;

				public String getJoueur2_nationalite () {
					return this.joueur2_nationalite;
				}
				
			    public Integer seed;

				public Integer getSeed () {
					return this.seed;
				}
				
			    public String round;

				public String getRound () {
					return this.round;
				}
				
			    public String score;

				public String getScore () {
					return this.score;
				}
				
			    public String resultat;

				public String getResultat () {
					return this.resultat;
				}
				
			    public java.util.Date date_tournoi;

				public java.util.Date getDate_tournoi () {
					return this.date_tournoi;
				}
				
			    public String nom_tournoi;

				public String getNom_tournoi () {
					return this.nom_tournoi;
				}
				
			    public String lieu_tournoi;

				public String getLieu_tournoi () {
					return this.lieu_tournoi;
				}
				
			    public BigDecimal prize_money;

				public BigDecimal getPrize_money () {
					return this.prize_money;
				}
				
			    public Integer points;

				public Integer getPoints () {
					return this.points;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length) {
				if(length < 1024 && commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length == 0) {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[1024];
				} else {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length);
			strReturn = new String(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length) {
				if(length < 1024 && commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length == 0) {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[1024];
				} else {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length);
			strReturn = new String(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep) {

        	try {

        		int length = 0;
		
					this.joueur1_nom = readString(dis);
					
					this.joueur1_prenom = readString(dis);
					
					this.joueur1_nationalite = readString(dis);
					
					this.joueur2_nom = readString(dis);
					
					this.joueur2_prenom = readString(dis);
					
					this.joueur2_nationalite = readString(dis);
					
						this.seed = readInteger(dis);
					
					this.round = readString(dis);
					
					this.score = readString(dis);
					
					this.resultat = readString(dis);
					
					this.date_tournoi = readDate(dis);
					
					this.nom_tournoi = readString(dis);
					
					this.lieu_tournoi = readString(dis);
					
						this.prize_money = (BigDecimal) dis.readObject();
					
						this.points = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep) {

        	try {

        		int length = 0;
		
					this.joueur1_nom = readString(dis);
					
					this.joueur1_prenom = readString(dis);
					
					this.joueur1_nationalite = readString(dis);
					
					this.joueur2_nom = readString(dis);
					
					this.joueur2_prenom = readString(dis);
					
					this.joueur2_nationalite = readString(dis);
					
						this.seed = readInteger(dis);
					
					this.round = readString(dis);
					
					this.score = readString(dis);
					
					this.resultat = readString(dis);
					
					this.date_tournoi = readDate(dis);
					
					this.nom_tournoi = readString(dis);
					
					this.lieu_tournoi = readString(dis);
					
						this.prize_money = (BigDecimal) dis.readObject();
					
						this.points = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.joueur1_nom,dos);
					
					// String
				
						writeString(this.joueur1_prenom,dos);
					
					// String
				
						writeString(this.joueur1_nationalite,dos);
					
					// String
				
						writeString(this.joueur2_nom,dos);
					
					// String
				
						writeString(this.joueur2_prenom,dos);
					
					// String
				
						writeString(this.joueur2_nationalite,dos);
					
					// Integer
				
						writeInteger(this.seed,dos);
					
					// String
				
						writeString(this.round,dos);
					
					// String
				
						writeString(this.score,dos);
					
					// String
				
						writeString(this.resultat,dos);
					
					// java.util.Date
				
						writeDate(this.date_tournoi,dos);
					
					// String
				
						writeString(this.nom_tournoi,dos);
					
					// String
				
						writeString(this.lieu_tournoi,dos);
					
					// BigDecimal
				
       			    	dos.writeObject(this.prize_money);
					
					// Integer
				
						writeInteger(this.points,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.joueur1_nom,dos);
					
					// String
				
						writeString(this.joueur1_prenom,dos);
					
					// String
				
						writeString(this.joueur1_nationalite,dos);
					
					// String
				
						writeString(this.joueur2_nom,dos);
					
					// String
				
						writeString(this.joueur2_prenom,dos);
					
					// String
				
						writeString(this.joueur2_nationalite,dos);
					
					// Integer
				
						writeInteger(this.seed,dos);
					
					// String
				
						writeString(this.round,dos);
					
					// String
				
						writeString(this.score,dos);
					
					// String
				
						writeString(this.resultat,dos);
					
					// java.util.Date
				
						writeDate(this.date_tournoi,dos);
					
					// String
				
						writeString(this.nom_tournoi,dos);
					
					// String
				
						writeString(this.lieu_tournoi,dos);
					
					// BigDecimal
				
       			    	dos.writeObject(this.prize_money);
					
					// Integer
				
						writeInteger(this.points,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("joueur1_nom="+joueur1_nom);
		sb.append(",joueur1_prenom="+joueur1_prenom);
		sb.append(",joueur1_nationalite="+joueur1_nationalite);
		sb.append(",joueur2_nom="+joueur2_nom);
		sb.append(",joueur2_prenom="+joueur2_prenom);
		sb.append(",joueur2_nationalite="+joueur2_nationalite);
		sb.append(",seed="+String.valueOf(seed));
		sb.append(",round="+round);
		sb.append(",score="+score);
		sb.append(",resultat="+resultat);
		sb.append(",date_tournoi="+String.valueOf(date_tournoi));
		sb.append(",nom_tournoi="+nom_tournoi);
		sb.append(",lieu_tournoi="+lieu_tournoi);
		sb.append(",prize_money="+String.valueOf(prize_money));
		sb.append(",points="+String.valueOf(points));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row22Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class row21Struct implements routines.system.IPersistableRow<row21Struct> {
    final static byte[] commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[0];
    static byte[] commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[0];

	
			    public String joueur1_nom;

				public String getJoueur1_nom () {
					return this.joueur1_nom;
				}
				
			    public String joueur1_prenom;

				public String getJoueur1_prenom () {
					return this.joueur1_prenom;
				}
				
			    public String joueur1_nationalite;

				public String getJoueur1_nationalite () {
					return this.joueur1_nationalite;
				}
				
			    public String joueur2_nom;

				public String getJoueur2_nom () {
					return this.joueur2_nom;
				}
				
			    public String joueur2_prenom;

				public String getJoueur2_prenom () {
					return this.joueur2_prenom;
				}
				
			    public String joueur2_nationalite;

				public String getJoueur2_nationalite () {
					return this.joueur2_nationalite;
				}
				
			    public Integer seed;

				public Integer getSeed () {
					return this.seed;
				}
				
			    public String round;

				public String getRound () {
					return this.round;
				}
				
			    public String score;

				public String getScore () {
					return this.score;
				}
				
			    public String resultat;

				public String getResultat () {
					return this.resultat;
				}
				
			    public java.util.Date date_tournoi;

				public java.util.Date getDate_tournoi () {
					return this.date_tournoi;
				}
				
			    public String nom_tournoi;

				public String getNom_tournoi () {
					return this.nom_tournoi;
				}
				
			    public String lieu_tournoi;

				public String getLieu_tournoi () {
					return this.lieu_tournoi;
				}
				
			    public BigDecimal prize_money;

				public BigDecimal getPrize_money () {
					return this.prize_money;
				}
				
			    public Integer points;

				public Integer getPoints () {
					return this.points;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length) {
				if(length < 1024 && commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length == 0) {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[1024];
				} else {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length);
			strReturn = new String(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length) {
				if(length < 1024 && commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep.length == 0) {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[1024];
				} else {
   					commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length);
			strReturn = new String(commonByteArray_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep) {

        	try {

        		int length = 0;
		
					this.joueur1_nom = readString(dis);
					
					this.joueur1_prenom = readString(dis);
					
					this.joueur1_nationalite = readString(dis);
					
					this.joueur2_nom = readString(dis);
					
					this.joueur2_prenom = readString(dis);
					
					this.joueur2_nationalite = readString(dis);
					
						this.seed = readInteger(dis);
					
					this.round = readString(dis);
					
					this.score = readString(dis);
					
					this.resultat = readString(dis);
					
					this.date_tournoi = readDate(dis);
					
					this.nom_tournoi = readString(dis);
					
					this.lieu_tournoi = readString(dis);
					
						this.prize_money = (BigDecimal) dis.readObject();
					
						this.points = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PI_PADEL_SA_SA_Load_Tournois_apr_a_sep) {

        	try {

        		int length = 0;
		
					this.joueur1_nom = readString(dis);
					
					this.joueur1_prenom = readString(dis);
					
					this.joueur1_nationalite = readString(dis);
					
					this.joueur2_nom = readString(dis);
					
					this.joueur2_prenom = readString(dis);
					
					this.joueur2_nationalite = readString(dis);
					
						this.seed = readInteger(dis);
					
					this.round = readString(dis);
					
					this.score = readString(dis);
					
					this.resultat = readString(dis);
					
					this.date_tournoi = readDate(dis);
					
					this.nom_tournoi = readString(dis);
					
					this.lieu_tournoi = readString(dis);
					
						this.prize_money = (BigDecimal) dis.readObject();
					
						this.points = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.joueur1_nom,dos);
					
					// String
				
						writeString(this.joueur1_prenom,dos);
					
					// String
				
						writeString(this.joueur1_nationalite,dos);
					
					// String
				
						writeString(this.joueur2_nom,dos);
					
					// String
				
						writeString(this.joueur2_prenom,dos);
					
					// String
				
						writeString(this.joueur2_nationalite,dos);
					
					// Integer
				
						writeInteger(this.seed,dos);
					
					// String
				
						writeString(this.round,dos);
					
					// String
				
						writeString(this.score,dos);
					
					// String
				
						writeString(this.resultat,dos);
					
					// java.util.Date
				
						writeDate(this.date_tournoi,dos);
					
					// String
				
						writeString(this.nom_tournoi,dos);
					
					// String
				
						writeString(this.lieu_tournoi,dos);
					
					// BigDecimal
				
       			    	dos.writeObject(this.prize_money);
					
					// Integer
				
						writeInteger(this.points,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.joueur1_nom,dos);
					
					// String
				
						writeString(this.joueur1_prenom,dos);
					
					// String
				
						writeString(this.joueur1_nationalite,dos);
					
					// String
				
						writeString(this.joueur2_nom,dos);
					
					// String
				
						writeString(this.joueur2_prenom,dos);
					
					// String
				
						writeString(this.joueur2_nationalite,dos);
					
					// Integer
				
						writeInteger(this.seed,dos);
					
					// String
				
						writeString(this.round,dos);
					
					// String
				
						writeString(this.score,dos);
					
					// String
				
						writeString(this.resultat,dos);
					
					// java.util.Date
				
						writeDate(this.date_tournoi,dos);
					
					// String
				
						writeString(this.nom_tournoi,dos);
					
					// String
				
						writeString(this.lieu_tournoi,dos);
					
					// BigDecimal
				
       			    	dos.writeObject(this.prize_money);
					
					// Integer
				
						writeInteger(this.points,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("joueur1_nom="+joueur1_nom);
		sb.append(",joueur1_prenom="+joueur1_prenom);
		sb.append(",joueur1_nationalite="+joueur1_nationalite);
		sb.append(",joueur2_nom="+joueur2_nom);
		sb.append(",joueur2_prenom="+joueur2_prenom);
		sb.append(",joueur2_nationalite="+joueur2_nationalite);
		sb.append(",seed="+String.valueOf(seed));
		sb.append(",round="+round);
		sb.append(",score="+score);
		sb.append(",resultat="+resultat);
		sb.append(",date_tournoi="+String.valueOf(date_tournoi));
		sb.append(",nom_tournoi="+nom_tournoi);
		sb.append(",lieu_tournoi="+lieu_tournoi);
		sb.append(",prize_money="+String.valueOf(prize_money));
		sb.append(",points="+String.valueOf(points));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row21Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tFileInputDelimited_11Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tFileInputDelimited_11_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row21Struct row21 = new row21Struct();
row21Struct row22 = row21;





	
	/**
	 * [tDBOutput_11 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBOutput_11", false);
		start_Hash.put("tDBOutput_11", System.currentTimeMillis());
		
	
	currentComponent="tDBOutput_11";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row22");
					}
				
		int tos_count_tDBOutput_11 = 0;
		





String dbschema_tDBOutput_11 = null;
	dbschema_tDBOutput_11 = "sa";
	

String tableName_tDBOutput_11 = null;
if(dbschema_tDBOutput_11 == null || dbschema_tDBOutput_11.trim().length() == 0) {
	tableName_tDBOutput_11 = ("sa_tournament_jun");
} else {
	tableName_tDBOutput_11 = dbschema_tDBOutput_11 + "\".\"" + ("sa_tournament_jun");
}


int nb_line_tDBOutput_11 = 0;
int nb_line_update_tDBOutput_11 = 0;
int nb_line_inserted_tDBOutput_11 = 0;
int nb_line_deleted_tDBOutput_11 = 0;
int nb_line_rejected_tDBOutput_11 = 0;

int deletedCount_tDBOutput_11=0;
int updatedCount_tDBOutput_11=0;
int insertedCount_tDBOutput_11=0;
int rowsToCommitCount_tDBOutput_11=0;
int rejectedCount_tDBOutput_11=0;

boolean whetherReject_tDBOutput_11 = false;

java.sql.Connection conn_tDBOutput_11 = null;
String dbUser_tDBOutput_11 = null;

	
    java.lang.Class.forName("org.postgresql.Driver");
    
        String url_tDBOutput_11 = "jdbc:postgresql://"+"localhost"+":"+"5432"+"/"+"padel_bi_SA";
    dbUser_tDBOutput_11 = "postgres";
 
	final String decryptedPassword_tDBOutput_11 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:riW/aCoEnk9W2m4lkcKA2I2E1lL7lX1dIyH9qrgAvKGV1dhUhw==");

    String dbPwd_tDBOutput_11 = decryptedPassword_tDBOutput_11;

    conn_tDBOutput_11 = java.sql.DriverManager.getConnection(url_tDBOutput_11,dbUser_tDBOutput_11,dbPwd_tDBOutput_11);
	
	resourceMap.put("conn_tDBOutput_11", conn_tDBOutput_11);
        conn_tDBOutput_11.setAutoCommit(false);
        int commitEvery_tDBOutput_11 = 10000;
        int commitCounter_tDBOutput_11 = 0;


   int batchSize_tDBOutput_11 = 10000;
   int batchSizeCounter_tDBOutput_11=0;

int count_tDBOutput_11=0;
	    String insert_tDBOutput_11 = "INSERT INTO \"" + tableName_tDBOutput_11 + "\" (\"joueur1_nom\",\"joueur1_prenom\",\"joueur1_nationalite\",\"joueur2_nom\",\"joueur2_prenom\",\"joueur2_nationalite\",\"seed\",\"round\",\"score\",\"resultat\",\"date_tournoi\",\"nom_tournoi\",\"lieu_tournoi\",\"prize_money\",\"points\") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	    
	    java.sql.PreparedStatement pstmt_tDBOutput_11 = conn_tDBOutput_11.prepareStatement(insert_tDBOutput_11);
	    resourceMap.put("pstmt_tDBOutput_11", pstmt_tDBOutput_11);
	    

 



/**
 * [tDBOutput_11 begin ] stop
 */



	
	/**
	 * [tLogRow_11 begin ] start
	 */

	

	
		
		ok_Hash.put("tLogRow_11", false);
		start_Hash.put("tLogRow_11", System.currentTimeMillis());
		
	
	currentComponent="tLogRow_11";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row21");
					}
				
		int tos_count_tLogRow_11 = 0;
		

	///////////////////////
	
         class Util_tLogRow_11 {

        String[] des_top = { ".", ".", "-", "+" };

        String[] des_head = { "|=", "=|", "-", "+" };

        String[] des_bottom = { "'", "'", "-", "+" };

        String name="";

        java.util.List<String[]> list = new java.util.ArrayList<String[]>();

        int[] colLengths = new int[15];

        public void addRow(String[] row) {

            for (int i = 0; i < 15; i++) {
                if (row[i]!=null) {
                  colLengths[i] = Math.max(colLengths[i], row[i].length());
                }
            }
            list.add(row);
        }

        public void setTableName(String name) {

            this.name = name;
        }

            public StringBuilder format() {
            
                StringBuilder sb = new StringBuilder();
  
            
                    sb.append(print(des_top));
    
                    int totals = 0;
                    for (int i = 0; i < colLengths.length; i++) {
                        totals = totals + colLengths[i];
                    }
    
                    // name
                    sb.append("|");
                    int k = 0;
                    for (k = 0; k < (totals + 14 - name.length()) / 2; k++) {
                        sb.append(' ');
                    }
                    sb.append(name);
                    for (int i = 0; i < totals + 14 - name.length() - k; i++) {
                        sb.append(' ');
                    }
                    sb.append("|\n");

                    // head and rows
                    sb.append(print(des_head));
                    for (int i = 0; i < list.size(); i++) {
    
                        String[] row = list.get(i);
    
                        java.util.Formatter formatter = new java.util.Formatter(new StringBuilder());
                        
                        StringBuilder sbformat = new StringBuilder();                                             
        			        sbformat.append("|%1$-");
        			        sbformat.append(colLengths[0]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%2$-");
        			        sbformat.append(colLengths[1]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%3$-");
        			        sbformat.append(colLengths[2]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%4$-");
        			        sbformat.append(colLengths[3]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%5$-");
        			        sbformat.append(colLengths[4]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%6$-");
        			        sbformat.append(colLengths[5]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%7$-");
        			        sbformat.append(colLengths[6]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%8$-");
        			        sbformat.append(colLengths[7]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%9$-");
        			        sbformat.append(colLengths[8]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%10$-");
        			        sbformat.append(colLengths[9]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%11$-");
        			        sbformat.append(colLengths[10]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%12$-");
        			        sbformat.append(colLengths[11]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%13$-");
        			        sbformat.append(colLengths[12]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%14$-");
        			        sbformat.append(colLengths[13]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%15$-");
        			        sbformat.append(colLengths[14]);
        			        sbformat.append("s");
        			                      
                        sbformat.append("|\n");                    
       
                        formatter.format(sbformat.toString(), (Object[])row);	
                                
                        sb.append(formatter.toString());
                        if (i == 0)
                            sb.append(print(des_head)); // print the head
                    }
    
                    // end
                    sb.append(print(des_bottom));
                    return sb;
                }
            

            private StringBuilder print(String[] fillChars) {
                StringBuilder sb = new StringBuilder();
                //first column
                sb.append(fillChars[0]);                
                    for (int i = 0; i < colLengths[0] - fillChars[0].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);	                

                    for (int i = 0; i < colLengths[1] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[2] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[3] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[4] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[5] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[6] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[7] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[8] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[9] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[10] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[11] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[12] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[13] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                
                    //last column
                    for (int i = 0; i < colLengths[14] - fillChars[1].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }         
                sb.append(fillChars[1]);
                sb.append("\n");               
                return sb;
            }
            
            public boolean isTableEmpty(){
            	if (list.size() > 1)
            		return false;
            	return true;
            }
        }
        Util_tLogRow_11 util_tLogRow_11 = new Util_tLogRow_11();
        util_tLogRow_11.setTableName("tLogRow_11");
        util_tLogRow_11.addRow(new String[]{"joueur1_nom","joueur1_prenom","joueur1_nationalite","joueur2_nom","joueur2_prenom","joueur2_nationalite","seed","round","score","resultat","date_tournoi","nom_tournoi","lieu_tournoi","prize_money","points",});        
 		StringBuilder strBuffer_tLogRow_11 = null;
		int nb_line_tLogRow_11 = 0;
///////////////////////    			



 



/**
 * [tLogRow_11 begin ] stop
 */



	
	/**
	 * [tFileInputDelimited_11 begin ] start
	 */

	

	
		
		ok_Hash.put("tFileInputDelimited_11", false);
		start_Hash.put("tFileInputDelimited_11", System.currentTimeMillis());
		
	
	currentComponent="tFileInputDelimited_11";

	
		int tos_count_tFileInputDelimited_11 = 0;
		
	
	
	
 
	
	
	final routines.system.RowState rowstate_tFileInputDelimited_11 = new routines.system.RowState();
	
	
				int nb_line_tFileInputDelimited_11 = 0;
				org.talend.fileprocess.FileInputDelimited fid_tFileInputDelimited_11 = null;
				int limit_tFileInputDelimited_11 = -1;
				try{
					
						Object filename_tFileInputDelimited_11 = "C:/Users/ASUS/Downloads/Sports/Sports/script_tournois/juin.csv";
						if(filename_tFileInputDelimited_11 instanceof java.io.InputStream){
							
			int footer_value_tFileInputDelimited_11 = 0, random_value_tFileInputDelimited_11 = -1;
			if(footer_value_tFileInputDelimited_11 >0 || random_value_tFileInputDelimited_11 > 0){
				throw new java.lang.Exception("When the input source is a stream,footer and random shouldn't be bigger than 0.");				
			}
		
						}
						try {
							fid_tFileInputDelimited_11 = new org.talend.fileprocess.FileInputDelimited("C:/Users/ASUS/Downloads/Sports/Sports/script_tournois/juin.csv", "ISO-8859-15",";","\n",true,1,0,
									limit_tFileInputDelimited_11
								,-1, false);
						} catch(java.lang.Exception e) {
globalMap.put("tFileInputDelimited_11_ERROR_MESSAGE",e.getMessage());
							
								
								System.err.println(e.getMessage());
							
						}
					
				    
					while (fid_tFileInputDelimited_11!=null && fid_tFileInputDelimited_11.nextRecord()) {
						rowstate_tFileInputDelimited_11.reset();
						
			    						row21 = null;			
												
									boolean whetherReject_tFileInputDelimited_11 = false;
									row21 = new row21Struct();
									try {
										
				int columnIndexWithD_tFileInputDelimited_11 = 0;
				
					String temp = ""; 
				
					columnIndexWithD_tFileInputDelimited_11 = 0;
					
							row21.joueur1_nom = fid_tFileInputDelimited_11.get(columnIndexWithD_tFileInputDelimited_11);
						
				
					columnIndexWithD_tFileInputDelimited_11 = 1;
					
							row21.joueur1_prenom = fid_tFileInputDelimited_11.get(columnIndexWithD_tFileInputDelimited_11);
						
				
					columnIndexWithD_tFileInputDelimited_11 = 2;
					
							row21.joueur1_nationalite = fid_tFileInputDelimited_11.get(columnIndexWithD_tFileInputDelimited_11);
						
				
					columnIndexWithD_tFileInputDelimited_11 = 3;
					
							row21.joueur2_nom = fid_tFileInputDelimited_11.get(columnIndexWithD_tFileInputDelimited_11);
						
				
					columnIndexWithD_tFileInputDelimited_11 = 4;
					
							row21.joueur2_prenom = fid_tFileInputDelimited_11.get(columnIndexWithD_tFileInputDelimited_11);
						
				
					columnIndexWithD_tFileInputDelimited_11 = 5;
					
							row21.joueur2_nationalite = fid_tFileInputDelimited_11.get(columnIndexWithD_tFileInputDelimited_11);
						
				
					columnIndexWithD_tFileInputDelimited_11 = 6;
					
						temp = fid_tFileInputDelimited_11.get(columnIndexWithD_tFileInputDelimited_11);
						if(temp.length() > 0) {
							
								try {
								
    								row21.seed = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_11) {
globalMap.put("tFileInputDelimited_11_ERROR_MESSAGE",ex_tFileInputDelimited_11.getMessage());
									rowstate_tFileInputDelimited_11.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"seed", "row21", temp, ex_tFileInputDelimited_11), ex_tFileInputDelimited_11));
								}
    							
						} else {						
							
								
									row21.seed = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_11 = 7;
					
							row21.round = fid_tFileInputDelimited_11.get(columnIndexWithD_tFileInputDelimited_11);
						
				
					columnIndexWithD_tFileInputDelimited_11 = 8;
					
							row21.score = fid_tFileInputDelimited_11.get(columnIndexWithD_tFileInputDelimited_11);
						
				
					columnIndexWithD_tFileInputDelimited_11 = 9;
					
							row21.resultat = fid_tFileInputDelimited_11.get(columnIndexWithD_tFileInputDelimited_11);
						
				
					columnIndexWithD_tFileInputDelimited_11 = 10;
					
						temp = fid_tFileInputDelimited_11.get(columnIndexWithD_tFileInputDelimited_11);
						if(temp.length() > 0) {
							
								try {
								
    									row21.date_tournoi = ParserUtils.parseTo_Date(temp, "yyyy-MM-dd");
    								
    							} catch(java.lang.Exception ex_tFileInputDelimited_11) {
globalMap.put("tFileInputDelimited_11_ERROR_MESSAGE",ex_tFileInputDelimited_11.getMessage());
									rowstate_tFileInputDelimited_11.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"date_tournoi", "row21", temp, ex_tFileInputDelimited_11), ex_tFileInputDelimited_11));
								}
    							
						} else {						
							
								
									row21.date_tournoi = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_11 = 11;
					
							row21.nom_tournoi = fid_tFileInputDelimited_11.get(columnIndexWithD_tFileInputDelimited_11);
						
				
					columnIndexWithD_tFileInputDelimited_11 = 12;
					
							row21.lieu_tournoi = fid_tFileInputDelimited_11.get(columnIndexWithD_tFileInputDelimited_11);
						
				
					columnIndexWithD_tFileInputDelimited_11 = 13;
					
						temp = fid_tFileInputDelimited_11.get(columnIndexWithD_tFileInputDelimited_11);
						if(temp.length() > 0) {
							
								try {
								
    								row21.prize_money = ParserUtils.parseTo_BigDecimal(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_11) {
globalMap.put("tFileInputDelimited_11_ERROR_MESSAGE",ex_tFileInputDelimited_11.getMessage());
									rowstate_tFileInputDelimited_11.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"prize_money", "row21", temp, ex_tFileInputDelimited_11), ex_tFileInputDelimited_11));
								}
    							
						} else {						
							
								
									row21.prize_money = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_11 = 14;
					
						temp = fid_tFileInputDelimited_11.get(columnIndexWithD_tFileInputDelimited_11);
						if(temp.length() > 0) {
							
								try {
								
    								row21.points = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_11) {
globalMap.put("tFileInputDelimited_11_ERROR_MESSAGE",ex_tFileInputDelimited_11.getMessage());
									rowstate_tFileInputDelimited_11.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"points", "row21", temp, ex_tFileInputDelimited_11), ex_tFileInputDelimited_11));
								}
    							
						} else {						
							
								
									row21.points = null;
								
							
						}
					
				
				
										
										if(rowstate_tFileInputDelimited_11.getException()!=null) {
											throw rowstate_tFileInputDelimited_11.getException();
										}
										
										
							
			    					} catch (java.lang.Exception e) {
globalMap.put("tFileInputDelimited_11_ERROR_MESSAGE",e.getMessage());
			        					whetherReject_tFileInputDelimited_11 = true;
			        					
			                					System.err.println(e.getMessage());
			                					row21 = null;
			                				
										
			    					}
								

 



/**
 * [tFileInputDelimited_11 begin ] stop
 */
	
	/**
	 * [tFileInputDelimited_11 main ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_11";

	

 


	tos_count_tFileInputDelimited_11++;

/**
 * [tFileInputDelimited_11 main ] stop
 */
	
	/**
	 * [tFileInputDelimited_11 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_11";

	

 



/**
 * [tFileInputDelimited_11 process_data_begin ] stop
 */
// Start of branch "row21"
if(row21 != null) { 



	
	/**
	 * [tLogRow_11 main ] start
	 */

	

	
	
	currentComponent="tLogRow_11";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row21"
						
						);
					}
					
///////////////////////		
						

				
				String[] row_tLogRow_11 = new String[15];
   				
	    		if(row21.joueur1_nom != null) { //              
                 row_tLogRow_11[0]=    						    
				                String.valueOf(row21.joueur1_nom)			
					          ;	
							
	    		} //			
    			   				
	    		if(row21.joueur1_prenom != null) { //              
                 row_tLogRow_11[1]=    						    
				                String.valueOf(row21.joueur1_prenom)			
					          ;	
							
	    		} //			
    			   				
	    		if(row21.joueur1_nationalite != null) { //              
                 row_tLogRow_11[2]=    						    
				                String.valueOf(row21.joueur1_nationalite)			
					          ;	
							
	    		} //			
    			   				
	    		if(row21.joueur2_nom != null) { //              
                 row_tLogRow_11[3]=    						    
				                String.valueOf(row21.joueur2_nom)			
					          ;	
							
	    		} //			
    			   				
	    		if(row21.joueur2_prenom != null) { //              
                 row_tLogRow_11[4]=    						    
				                String.valueOf(row21.joueur2_prenom)			
					          ;	
							
	    		} //			
    			   				
	    		if(row21.joueur2_nationalite != null) { //              
                 row_tLogRow_11[5]=    						    
				                String.valueOf(row21.joueur2_nationalite)			
					          ;	
							
	    		} //			
    			   				
	    		if(row21.seed != null) { //              
                 row_tLogRow_11[6]=    						    
				                String.valueOf(row21.seed)			
					          ;	
							
	    		} //			
    			   				
	    		if(row21.round != null) { //              
                 row_tLogRow_11[7]=    						    
				                String.valueOf(row21.round)			
					          ;	
							
	    		} //			
    			   				
	    		if(row21.score != null) { //              
                 row_tLogRow_11[8]=    						    
				                String.valueOf(row21.score)			
					          ;	
							
	    		} //			
    			   				
	    		if(row21.resultat != null) { //              
                 row_tLogRow_11[9]=    						    
				                String.valueOf(row21.resultat)			
					          ;	
							
	    		} //			
    			   				
	    		if(row21.date_tournoi != null) { //              
                 row_tLogRow_11[10]=    						
								FormatterUtils.format_Date(row21.date_tournoi, "yyyy-MM-dd")
					          ;	
							
	    		} //			
    			   				
	    		if(row21.nom_tournoi != null) { //              
                 row_tLogRow_11[11]=    						    
				                String.valueOf(row21.nom_tournoi)			
					          ;	
							
	    		} //			
    			   				
	    		if(row21.lieu_tournoi != null) { //              
                 row_tLogRow_11[12]=    						    
				                String.valueOf(row21.lieu_tournoi)			
					          ;	
							
	    		} //			
    			   				
	    		if(row21.prize_money != null) { //              
                 row_tLogRow_11[13]=    						
								row21.prize_money.toPlainString()
					          ;	
							
	    		} //			
    			   				
	    		if(row21.points != null) { //              
                 row_tLogRow_11[14]=    						    
				                String.valueOf(row21.points)			
					          ;	
							
	    		} //			
    			 

				util_tLogRow_11.addRow(row_tLogRow_11);	
				nb_line_tLogRow_11++;
//////

//////                    
                    
///////////////////////    			

 
     row22 = row21;


	tos_count_tLogRow_11++;

/**
 * [tLogRow_11 main ] stop
 */
	
	/**
	 * [tLogRow_11 process_data_begin ] start
	 */

	

	
	
	currentComponent="tLogRow_11";

	

 



/**
 * [tLogRow_11 process_data_begin ] stop
 */

	
	/**
	 * [tDBOutput_11 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_11";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row22"
						
						);
					}
					



        whetherReject_tDBOutput_11 = false;
                    if(row22.joueur1_nom == null) {
pstmt_tDBOutput_11.setNull(1, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_11.setString(1, row22.joueur1_nom);
}

                    if(row22.joueur1_prenom == null) {
pstmt_tDBOutput_11.setNull(2, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_11.setString(2, row22.joueur1_prenom);
}

                    if(row22.joueur1_nationalite == null) {
pstmt_tDBOutput_11.setNull(3, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_11.setString(3, row22.joueur1_nationalite);
}

                    if(row22.joueur2_nom == null) {
pstmt_tDBOutput_11.setNull(4, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_11.setString(4, row22.joueur2_nom);
}

                    if(row22.joueur2_prenom == null) {
pstmt_tDBOutput_11.setNull(5, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_11.setString(5, row22.joueur2_prenom);
}

                    if(row22.joueur2_nationalite == null) {
pstmt_tDBOutput_11.setNull(6, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_11.setString(6, row22.joueur2_nationalite);
}

                    if(row22.seed == null) {
pstmt_tDBOutput_11.setNull(7, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_11.setInt(7, row22.seed);
}

                    if(row22.round == null) {
pstmt_tDBOutput_11.setNull(8, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_11.setString(8, row22.round);
}

                    if(row22.score == null) {
pstmt_tDBOutput_11.setNull(9, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_11.setString(9, row22.score);
}

                    if(row22.resultat == null) {
pstmt_tDBOutput_11.setNull(10, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_11.setString(10, row22.resultat);
}

                    if(row22.date_tournoi != null) {
pstmt_tDBOutput_11.setTimestamp(11, new java.sql.Timestamp(row22.date_tournoi.getTime()));
} else {
pstmt_tDBOutput_11.setNull(11, java.sql.Types.TIMESTAMP);
}

                    if(row22.nom_tournoi == null) {
pstmt_tDBOutput_11.setNull(12, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_11.setString(12, row22.nom_tournoi);
}

                    if(row22.lieu_tournoi == null) {
pstmt_tDBOutput_11.setNull(13, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_11.setString(13, row22.lieu_tournoi);
}

                    pstmt_tDBOutput_11.setBigDecimal(14, row22.prize_money);

                    if(row22.points == null) {
pstmt_tDBOutput_11.setNull(15, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_11.setInt(15, row22.points);
}

			
    		pstmt_tDBOutput_11.addBatch();
    		nb_line_tDBOutput_11++;
    		  
    		  
    		  batchSizeCounter_tDBOutput_11++;
    		  
    			if ((batchSize_tDBOutput_11 > 0) && (batchSize_tDBOutput_11 <= batchSizeCounter_tDBOutput_11)) {
                try {
						int countSum_tDBOutput_11 = 0;
						    
						for(int countEach_tDBOutput_11: pstmt_tDBOutput_11.executeBatch()) {
							countSum_tDBOutput_11 += (countEach_tDBOutput_11 < 0 ? 0 : countEach_tDBOutput_11);
						}
				    	rowsToCommitCount_tDBOutput_11 += countSum_tDBOutput_11;
				    	
				    		insertedCount_tDBOutput_11 += countSum_tDBOutput_11;
				    	
            	    	batchSizeCounter_tDBOutput_11 = 0;
                }catch (java.sql.BatchUpdateException e_tDBOutput_11){
globalMap.put("tDBOutput_11_ERROR_MESSAGE",e_tDBOutput_11.getMessage());
				    	java.sql.SQLException ne_tDBOutput_11 = e_tDBOutput_11.getNextException(),sqle_tDBOutput_11=null;
				    	String errormessage_tDBOutput_11;
						if (ne_tDBOutput_11 != null) {
							// build new exception to provide the original cause
							sqle_tDBOutput_11 = new java.sql.SQLException(e_tDBOutput_11.getMessage() + "\ncaused by: " + ne_tDBOutput_11.getMessage(), ne_tDBOutput_11.getSQLState(), ne_tDBOutput_11.getErrorCode(), ne_tDBOutput_11);
							errormessage_tDBOutput_11 = sqle_tDBOutput_11.getMessage();
						}else{
							errormessage_tDBOutput_11 = e_tDBOutput_11.getMessage();
						}
				    	
				    	int countSum_tDBOutput_11 = 0;
						for(int countEach_tDBOutput_11: e_tDBOutput_11.getUpdateCounts()) {
							countSum_tDBOutput_11 += (countEach_tDBOutput_11 < 0 ? 0 : countEach_tDBOutput_11);
						}
						rowsToCommitCount_tDBOutput_11 += countSum_tDBOutput_11;
						
				    		insertedCount_tDBOutput_11 += countSum_tDBOutput_11;
				    	
				    	System.err.println(errormessage_tDBOutput_11);
				    	
					}
    			}
    		
    		    commitCounter_tDBOutput_11++;
                if(commitEvery_tDBOutput_11 <= commitCounter_tDBOutput_11) {
                if ((batchSize_tDBOutput_11 > 0) && (batchSizeCounter_tDBOutput_11 > 0)) {
                try {
                		int countSum_tDBOutput_11 = 0;
                		    
						for(int countEach_tDBOutput_11: pstmt_tDBOutput_11.executeBatch()) {
							countSum_tDBOutput_11 += (countEach_tDBOutput_11 < 0 ? 0 : countEach_tDBOutput_11);
						}
            	    	rowsToCommitCount_tDBOutput_11 += countSum_tDBOutput_11;
            	    	
            	    		insertedCount_tDBOutput_11 += countSum_tDBOutput_11;
            	    	
                batchSizeCounter_tDBOutput_11 = 0;
               }catch (java.sql.BatchUpdateException e_tDBOutput_11){
globalMap.put("tDBOutput_11_ERROR_MESSAGE",e_tDBOutput_11.getMessage());
			    	java.sql.SQLException ne_tDBOutput_11 = e_tDBOutput_11.getNextException(),sqle_tDBOutput_11=null;
			    	String errormessage_tDBOutput_11;
					if (ne_tDBOutput_11 != null) {
						// build new exception to provide the original cause
						sqle_tDBOutput_11 = new java.sql.SQLException(e_tDBOutput_11.getMessage() + "\ncaused by: " + ne_tDBOutput_11.getMessage(), ne_tDBOutput_11.getSQLState(), ne_tDBOutput_11.getErrorCode(), ne_tDBOutput_11);
						errormessage_tDBOutput_11 = sqle_tDBOutput_11.getMessage();
					}else{
						errormessage_tDBOutput_11 = e_tDBOutput_11.getMessage();
					}
			    	
			    	int countSum_tDBOutput_11 = 0;
					for(int countEach_tDBOutput_11: e_tDBOutput_11.getUpdateCounts()) {
						countSum_tDBOutput_11 += (countEach_tDBOutput_11 < 0 ? 0 : countEach_tDBOutput_11);
					}
					rowsToCommitCount_tDBOutput_11 += countSum_tDBOutput_11;
					
			    		insertedCount_tDBOutput_11 += countSum_tDBOutput_11;
			    	
			    	System.err.println(errormessage_tDBOutput_11);
			    	
				}
            }
                    if(rowsToCommitCount_tDBOutput_11 != 0){
                    	
                    }
                    conn_tDBOutput_11.commit();
                    if(rowsToCommitCount_tDBOutput_11 != 0){
                    	
                    	rowsToCommitCount_tDBOutput_11 = 0;
                    }
                    commitCounter_tDBOutput_11=0;
                }

 


	tos_count_tDBOutput_11++;

/**
 * [tDBOutput_11 main ] stop
 */
	
	/**
	 * [tDBOutput_11 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBOutput_11";

	

 



/**
 * [tDBOutput_11 process_data_begin ] stop
 */
	
	/**
	 * [tDBOutput_11 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBOutput_11";

	

 



/**
 * [tDBOutput_11 process_data_end ] stop
 */



	
	/**
	 * [tLogRow_11 process_data_end ] start
	 */

	

	
	
	currentComponent="tLogRow_11";

	

 



/**
 * [tLogRow_11 process_data_end ] stop
 */

} // End of branch "row21"




	
	/**
	 * [tFileInputDelimited_11 process_data_end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_11";

	

 



/**
 * [tFileInputDelimited_11 process_data_end ] stop
 */
	
	/**
	 * [tFileInputDelimited_11 end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_11";

	



            }
            }finally{
                if(!((Object)("C:/Users/ASUS/Downloads/Sports/Sports/script_tournois/juin.csv") instanceof java.io.InputStream)){
                	if(fid_tFileInputDelimited_11!=null){
                		fid_tFileInputDelimited_11.close();
                	}
                }
                if(fid_tFileInputDelimited_11!=null){
                	globalMap.put("tFileInputDelimited_11_NB_LINE", fid_tFileInputDelimited_11.getRowNumber());
					
                }
			}
			  

 

ok_Hash.put("tFileInputDelimited_11", true);
end_Hash.put("tFileInputDelimited_11", System.currentTimeMillis());




/**
 * [tFileInputDelimited_11 end ] stop
 */

	
	/**
	 * [tLogRow_11 end ] start
	 */

	

	
	
	currentComponent="tLogRow_11";

	


//////

                    
                    java.io.PrintStream consoleOut_tLogRow_11 = null;
                    if (globalMap.get("tLogRow_CONSOLE")!=null)
                    {
                    	consoleOut_tLogRow_11 = (java.io.PrintStream) globalMap.get("tLogRow_CONSOLE");
                    }
                    else
                    {
                    	consoleOut_tLogRow_11 = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));
                    	globalMap.put("tLogRow_CONSOLE",consoleOut_tLogRow_11);
                    }
                    
                    consoleOut_tLogRow_11.println(util_tLogRow_11.format().toString());
                    consoleOut_tLogRow_11.flush();
//////
globalMap.put("tLogRow_11_NB_LINE",nb_line_tLogRow_11);

///////////////////////    			

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row21");
			  	}
			  	
 

ok_Hash.put("tLogRow_11", true);
end_Hash.put("tLogRow_11", System.currentTimeMillis());




/**
 * [tLogRow_11 end ] stop
 */

	
	/**
	 * [tDBOutput_11 end ] start
	 */

	

	
	
	currentComponent="tDBOutput_11";

	



	    try {
				int countSum_tDBOutput_11 = 0;
				if (pstmt_tDBOutput_11 != null && batchSizeCounter_tDBOutput_11 > 0) {
						
					for(int countEach_tDBOutput_11: pstmt_tDBOutput_11.executeBatch()) {
						countSum_tDBOutput_11 += (countEach_tDBOutput_11 < 0 ? 0 : countEach_tDBOutput_11);
					}
					rowsToCommitCount_tDBOutput_11 += countSum_tDBOutput_11;
						
				}
		    	
		    		insertedCount_tDBOutput_11 += countSum_tDBOutput_11;
		    	
	    }catch (java.sql.BatchUpdateException e_tDBOutput_11){
globalMap.put("tDBOutput_11_ERROR_MESSAGE",e_tDBOutput_11.getMessage());
	    	java.sql.SQLException ne_tDBOutput_11 = e_tDBOutput_11.getNextException(),sqle_tDBOutput_11=null;
	    	String errormessage_tDBOutput_11;
			if (ne_tDBOutput_11 != null) {
				// build new exception to provide the original cause
				sqle_tDBOutput_11 = new java.sql.SQLException(e_tDBOutput_11.getMessage() + "\ncaused by: " + ne_tDBOutput_11.getMessage(), ne_tDBOutput_11.getSQLState(), ne_tDBOutput_11.getErrorCode(), ne_tDBOutput_11);
				errormessage_tDBOutput_11 = sqle_tDBOutput_11.getMessage();
			}else{
				errormessage_tDBOutput_11 = e_tDBOutput_11.getMessage();
			}
	    	
	    	int countSum_tDBOutput_11 = 0;
			for(int countEach_tDBOutput_11: e_tDBOutput_11.getUpdateCounts()) {
				countSum_tDBOutput_11 += (countEach_tDBOutput_11 < 0 ? 0 : countEach_tDBOutput_11);
			}
			rowsToCommitCount_tDBOutput_11 += countSum_tDBOutput_11;
			
	    		insertedCount_tDBOutput_11 += countSum_tDBOutput_11;
	    	
	    	System.err.println(errormessage_tDBOutput_11);
	    	
		}
	    
        if(pstmt_tDBOutput_11 != null) {
        		
            pstmt_tDBOutput_11.close();
            resourceMap.remove("pstmt_tDBOutput_11");
        }
    resourceMap.put("statementClosed_tDBOutput_11", true);
			if(rowsToCommitCount_tDBOutput_11 != 0){
				
			}
			conn_tDBOutput_11.commit();
			if(rowsToCommitCount_tDBOutput_11 != 0){
				
				rowsToCommitCount_tDBOutput_11 = 0;
			}
			commitCounter_tDBOutput_11 = 0;
		
    	conn_tDBOutput_11 .close();
    	
    	resourceMap.put("finish_tDBOutput_11", true);
    	

	nb_line_deleted_tDBOutput_11=nb_line_deleted_tDBOutput_11+ deletedCount_tDBOutput_11;
	nb_line_update_tDBOutput_11=nb_line_update_tDBOutput_11 + updatedCount_tDBOutput_11;
	nb_line_inserted_tDBOutput_11=nb_line_inserted_tDBOutput_11 + insertedCount_tDBOutput_11;
	nb_line_rejected_tDBOutput_11=nb_line_rejected_tDBOutput_11 + rejectedCount_tDBOutput_11;
	
        globalMap.put("tDBOutput_11_NB_LINE",nb_line_tDBOutput_11);
        globalMap.put("tDBOutput_11_NB_LINE_UPDATED",nb_line_update_tDBOutput_11);
        globalMap.put("tDBOutput_11_NB_LINE_INSERTED",nb_line_inserted_tDBOutput_11);
        globalMap.put("tDBOutput_11_NB_LINE_DELETED",nb_line_deleted_tDBOutput_11);
        globalMap.put("tDBOutput_11_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_11);
    

	


				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row22");
			  	}
			  	
 

ok_Hash.put("tDBOutput_11", true);
end_Hash.put("tDBOutput_11", System.currentTimeMillis());




/**
 * [tDBOutput_11 end ] stop
 */






				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tFileInputDelimited_11 finally ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_11";

	

 



/**
 * [tFileInputDelimited_11 finally ] stop
 */

	
	/**
	 * [tLogRow_11 finally ] start
	 */

	

	
	
	currentComponent="tLogRow_11";

	

 



/**
 * [tLogRow_11 finally ] stop
 */

	
	/**
	 * [tDBOutput_11 finally ] start
	 */

	

	
	
	currentComponent="tDBOutput_11";

	



    try {
    if (resourceMap.get("statementClosed_tDBOutput_11") == null) {
                java.sql.PreparedStatement pstmtToClose_tDBOutput_11 = null;
                if ((pstmtToClose_tDBOutput_11 = (java.sql.PreparedStatement) resourceMap.remove("pstmt_tDBOutput_11")) != null) {
                    pstmtToClose_tDBOutput_11.close();
                }
    }
    } finally {
        if(resourceMap.get("finish_tDBOutput_11") == null){
            java.sql.Connection ctn_tDBOutput_11 = null;
            if((ctn_tDBOutput_11 = (java.sql.Connection)resourceMap.get("conn_tDBOutput_11")) != null){
                try {
                    ctn_tDBOutput_11.close();
                } catch (java.sql.SQLException sqlEx_tDBOutput_11) {
                    String errorMessage_tDBOutput_11 = "failed to close the connection in tDBOutput_11 :" + sqlEx_tDBOutput_11.getMessage();
                    System.err.println(errorMessage_tDBOutput_11);
                }
            }
        }
    }
 



/**
 * [tDBOutput_11 finally ] stop
 */






				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tFileInputDelimited_11_SUBPROCESS_STATE", 1);
	}
	
    public String resuming_logs_dir_path = null;
    public String resuming_checkpoint_path = null;
    public String parent_part_launcher = null;
    private String resumeEntryMethodName = null;
    private boolean globalResumeTicket = false;

    public boolean watch = false;
    // portStats is null, it means don't execute the statistics
    public Integer portStats = null;
    public int portTraces = 4334;
    public String clientHost;
    public String defaultClientHost = "localhost";
    public String contextStr = "Default";
    public boolean isDefaultContext = true;
    public String pid = "0";
    public String rootPid = null;
    public String fatherPid = null;
    public String fatherNode = null;
    public long startTime = 0;
    public boolean isChildJob = false;
    public String log4jLevel = "";
    
    private boolean enableLogStash;

    private boolean execStat = true;

    private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
        protected java.util.Map<String, String> initialValue() {
            java.util.Map<String,String> threadRunResultMap = new java.util.HashMap<String, String>();
            threadRunResultMap.put("errorCode", null);
            threadRunResultMap.put("status", "");
            return threadRunResultMap;
        };
    };


    protected PropertiesWithType context_param = new PropertiesWithType();
    public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

    public String status= "";
    

    public static void main(String[] args){
        final SA_Load_Tournois_apr_a_sep SA_Load_Tournois_apr_a_sepClass = new SA_Load_Tournois_apr_a_sep();

        int exitCode = SA_Load_Tournois_apr_a_sepClass.runJobInTOS(args);

        System.exit(exitCode);
    }


    public String[][] runJob(String[] args) {

        int exitCode = runJobInTOS(args);
        String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

        return bufferValue;
    }

    public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;
    	
        return hastBufferOutput;
    }

    public int runJobInTOS(String[] args) {
	   	// reset status
	   	status = "";
	   	
        String lastStr = "";
        for (String arg : args) {
            if (arg.equalsIgnoreCase("--context_param")) {
                lastStr = arg;
            } else if (lastStr.equals("")) {
                evalParam(arg);
            } else {
                evalParam(lastStr + " " + arg);
                lastStr = "";
            }
        }
        enableLogStash = "true".equalsIgnoreCase(System.getProperty("audit.enabled"));

    	
    	

        if(clientHost == null) {
            clientHost = defaultClientHost;
        }

        if(pid == null || "0".equals(pid)) {
            pid = TalendString.getAsciiRandomString(6);
        }

        if (rootPid==null) {
            rootPid = pid;
        }
        if (fatherPid==null) {
            fatherPid = pid;
        }else{
            isChildJob = true;
        }

        if (portStats != null) {
            // portStats = -1; //for testing
            if (portStats < 0 || portStats > 65535) {
                // issue:10869, the portStats is invalid, so this client socket can't open
                System.err.println("The statistics socket port " + portStats + " is invalid.");
                execStat = false;
            }
        } else {
            execStat = false;
        }
        boolean inOSGi = routines.system.BundleUtils.inOSGi();

        if (inOSGi) {
            java.util.Dictionary<String, Object> jobProperties = routines.system.BundleUtils.getJobProperties(jobName);

            if (jobProperties != null && jobProperties.get("context") != null) {
                contextStr = (String)jobProperties.get("context");
            }
        }

        try {
            //call job/subjob with an existing context, like: --context=production. if without this parameter, there will use the default context instead.
            java.io.InputStream inContext = SA_Load_Tournois_apr_a_sep.class.getClassLoader().getResourceAsStream("pi_padel_sa/sa_load_tournois_apr_a_sep_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = SA_Load_Tournois_apr_a_sep.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
            }
            if (inContext != null) {
                try {
                    //defaultProps is in order to keep the original context value
                    if(context != null && context.isEmpty()) {
	                defaultProps.load(inContext);
	                context = new ContextProperties(defaultProps);
                    }
                } finally {
                    inContext.close();
                }
            } else if (!isDefaultContext) {
                //print info and job continue to run, for case: context_param is not empty.
                System.err.println("Could not find the context " + contextStr);
            }

            if(!context_param.isEmpty()) {
                context.putAll(context_param);
				//set types for params from parentJobs
				for (Object key: context_param.keySet()){
					String context_key = key.toString();
					String context_type = context_param.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
            }
            class ContextProcessing {
                private void processContext_0() {
                } 
                public void processAllContext() {
                        processContext_0();
                }
            }

            new ContextProcessing().processAllContext();
        } catch (java.io.IOException ie) {
            System.err.println("Could not load context "+contextStr);
            ie.printStackTrace();
        }

        // get context value from parent directly
        if (parentContextMap != null && !parentContextMap.isEmpty()) {
        }

        //Resume: init the resumeUtil
        resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
        resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
        resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
        //Resume: jobStart
        resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","","","",resumeUtil.convertToJsonText(context,parametersToEncrypt));

if(execStat) {
    try {
        runStat.openSocket(!isChildJob);
        runStat.setAllPID(rootPid, fatherPid, pid, jobName);
        runStat.startThreadStat(clientHost, portStats);
        runStat.updateStatOnJob(RunStat.JOBSTART, fatherNode);
    } catch (java.io.IOException ioException) {
        ioException.printStackTrace();
    }
}



	
	    java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
	    globalMap.put("concurrentHashMap", concurrentHashMap);
	

    long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    long endUsedMemory = 0;
    long end = 0;

    startTime = System.currentTimeMillis();


this.globalResumeTicket = true;//to run tPreJob





this.globalResumeTicket = false;//to run others jobs

try {
errorCode = null;tFileInputDelimited_1Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tFileInputDelimited_1) {
globalMap.put("tFileInputDelimited_1_SUBPROCESS_STATE", -1);

e_tFileInputDelimited_1.printStackTrace();

}
try {
errorCode = null;tFileInputDelimited_2Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tFileInputDelimited_2) {
globalMap.put("tFileInputDelimited_2_SUBPROCESS_STATE", -1);

e_tFileInputDelimited_2.printStackTrace();

}
try {
errorCode = null;tFileInputDelimited_3Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tFileInputDelimited_3) {
globalMap.put("tFileInputDelimited_3_SUBPROCESS_STATE", -1);

e_tFileInputDelimited_3.printStackTrace();

}
try {
errorCode = null;tFileInputDelimited_4Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tFileInputDelimited_4) {
globalMap.put("tFileInputDelimited_4_SUBPROCESS_STATE", -1);

e_tFileInputDelimited_4.printStackTrace();

}
try {
errorCode = null;tFileInputDelimited_5Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tFileInputDelimited_5) {
globalMap.put("tFileInputDelimited_5_SUBPROCESS_STATE", -1);

e_tFileInputDelimited_5.printStackTrace();

}
try {
errorCode = null;tFileInputDelimited_6Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tFileInputDelimited_6) {
globalMap.put("tFileInputDelimited_6_SUBPROCESS_STATE", -1);

e_tFileInputDelimited_6.printStackTrace();

}
try {
errorCode = null;tFileInputDelimited_7Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tFileInputDelimited_7) {
globalMap.put("tFileInputDelimited_7_SUBPROCESS_STATE", -1);

e_tFileInputDelimited_7.printStackTrace();

}
try {
errorCode = null;tFileInputDelimited_8Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tFileInputDelimited_8) {
globalMap.put("tFileInputDelimited_8_SUBPROCESS_STATE", -1);

e_tFileInputDelimited_8.printStackTrace();

}
try {
errorCode = null;tFileInputDelimited_9Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tFileInputDelimited_9) {
globalMap.put("tFileInputDelimited_9_SUBPROCESS_STATE", -1);

e_tFileInputDelimited_9.printStackTrace();

}
try {
errorCode = null;tFileInputDelimited_10Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tFileInputDelimited_10) {
globalMap.put("tFileInputDelimited_10_SUBPROCESS_STATE", -1);

e_tFileInputDelimited_10.printStackTrace();

}
try {
errorCode = null;tFileInputDelimited_11Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tFileInputDelimited_11) {
globalMap.put("tFileInputDelimited_11_SUBPROCESS_STATE", -1);

e_tFileInputDelimited_11.printStackTrace();

}

this.globalResumeTicket = true;//to run tPostJob




        end = System.currentTimeMillis();

        if (watch) {
            System.out.println((end-startTime)+" milliseconds");
        }

        endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        if (false) {
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : SA_Load_Tournois_apr_a_sep");
        }



if (execStat) {
    runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
    runStat.stopThreadStat();
}
    int returnCode = 0;


    if(errorCode == null) {
         returnCode = status != null && status.equals("failure") ? 1 : 0;
    } else {
         returnCode = errorCode.intValue();
    }
    resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","" + returnCode,"","","");

    return returnCode;

  }

    // only for OSGi env
    public void destroy() {


    }














    private java.util.Map<String, Object> getSharedConnections4REST() {
        java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();






        return connections;
    }

    private void evalParam(String arg) {
        if (arg.startsWith("--resuming_logs_dir_path")) {
            resuming_logs_dir_path = arg.substring(25);
        } else if (arg.startsWith("--resuming_checkpoint_path")) {
            resuming_checkpoint_path = arg.substring(27);
        } else if (arg.startsWith("--parent_part_launcher")) {
            parent_part_launcher = arg.substring(23);
        } else if (arg.startsWith("--watch")) {
            watch = true;
        } else if (arg.startsWith("--stat_port=")) {
            String portStatsStr = arg.substring(12);
            if (portStatsStr != null && !portStatsStr.equals("null")) {
                portStats = Integer.parseInt(portStatsStr);
            }
        } else if (arg.startsWith("--trace_port=")) {
            portTraces = Integer.parseInt(arg.substring(13));
        } else if (arg.startsWith("--client_host=")) {
            clientHost = arg.substring(14);
        } else if (arg.startsWith("--context=")) {
            contextStr = arg.substring(10);
            isDefaultContext = false;
        } else if (arg.startsWith("--father_pid=")) {
            fatherPid = arg.substring(13);
        } else if (arg.startsWith("--root_pid=")) {
            rootPid = arg.substring(11);
        } else if (arg.startsWith("--father_node=")) {
            fatherNode = arg.substring(14);
        } else if (arg.startsWith("--pid=")) {
            pid = arg.substring(6);
        } else if (arg.startsWith("--context_type")) {
            String keyValue = arg.substring(15);
			int index = -1;
            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
                if (fatherPid==null) {
                    context_param.setContextType(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1) );
                }

            }

		} else if (arg.startsWith("--context_param")) {
            String keyValue = arg.substring(16);
            int index = -1;
            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
                if (fatherPid==null) {
                    context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1) );
                }
            }
        } else if (arg.startsWith("--log4jLevel=")) {
            log4jLevel = arg.substring(13);
		} else if (arg.startsWith("--audit.enabled") && arg.contains("=")) {//for trunjob call
		    final int equal = arg.indexOf('=');
			final String key = arg.substring("--".length(), equal);
			System.setProperty(key, arg.substring(equal + 1));
		}
    }
    
    private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

    private final String[][] escapeChars = {
        {"\\\\","\\"},{"\\n","\n"},{"\\'","\'"},{"\\r","\r"},
        {"\\f","\f"},{"\\b","\b"},{"\\t","\t"}
        };
    private String replaceEscapeChars (String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0],currIndex);
				if (index>=0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0], strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
    }

    public Integer getErrorCode() {
        return errorCode;
    }


    public String getStatus() {
        return status;
    }

    ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 *     784601 characters generated by Talend Open Studio for Data Integration 
 *     on the 2 mars 2026, 22:33:40 WAT
 ************************************************************************************************/