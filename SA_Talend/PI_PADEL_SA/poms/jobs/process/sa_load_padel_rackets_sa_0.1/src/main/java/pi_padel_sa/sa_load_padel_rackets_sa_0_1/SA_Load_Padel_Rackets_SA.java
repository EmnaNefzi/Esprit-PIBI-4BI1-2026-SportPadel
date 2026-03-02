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


package pi_padel_sa.sa_load_padel_rackets_sa_0_1;

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
 * Job: SA_Load_Padel_Rackets_SA Purpose: <br>
 * Description:  <br>
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status 
 */
public class SA_Load_Padel_Rackets_SA implements TalendJob {

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
	private final String jobName = "SA_Load_Padel_Rackets_SA";
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
				SA_Load_Padel_Rackets_SA.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(SA_Load_Padel_Rackets_SA.this, new Object[] { e , currentComponent, globalMap});
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
			
			public void tDBOutput_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFileInputDelimited_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
	






public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
    final static byte[] commonByteArrayLock_PI_PADEL_SA_SA_Load_Padel_Rackets_SA = new byte[0];
    static byte[] commonByteArray_PI_PADEL_SA_SA_Load_Padel_Rackets_SA = new byte[0];

	
			    public String title;

				public String getTitle () {
					return this.title;
				}
				
			    public String handle;

				public String getHandle () {
					return this.handle;
				}
				
			    public String vendor;

				public String getVendor () {
					return this.vendor;
				}
				
			    public String product_type;

				public String getProduct_type () {
					return this.product_type;
				}
				
			    public String tags;

				public String getTags () {
					return this.tags;
				}
				
			    public String created_at;

				public String getCreated_at () {
					return this.created_at;
				}
				
			    public String price;

				public String getPrice () {
					return this.price;
				}
				
			    public String sku;

				public String getSku () {
					return this.sku;
				}
				
			    public String image;

				public String getImage () {
					return this.image;
				}
				
			    public String weight;

				public String getWeight () {
					return this.weight;
				}
				
			    public String shape;

				public String getShape () {
					return this.shape;
				}
				
			    public String foam;

				public String getFoam () {
					return this.foam;
				}
				
			    public String collection;

				public String getCollection () {
					return this.collection;
				}
				
			    public String game_level;

				public String getGame_level () {
					return this.game_level;
				}
				
			    public String frame;

				public String getFrame () {
					return this.frame;
				}
				
			    public String surface;

				public String getSurface () {
					return this.surface;
				}
				
			    public String professional_player;

				public String getProfessional_player () {
					return this.professional_player;
				}
				
			    public String color;

				public String getColor () {
					return this.color;
				}
				
			    public String racket_type;

				public String getRacket_type () {
					return this.racket_type;
				}
				
			    public String balance;

				public String getBalance () {
					return this.balance;
				}
				
			    public String gender;

				public String getGender () {
					return this.gender;
				}
				
			    public String racket_cover;

				public String getRacket_cover () {
					return this.racket_cover;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PI_PADEL_SA_SA_Load_Padel_Rackets_SA.length) {
				if(length < 1024 && commonByteArray_PI_PADEL_SA_SA_Load_Padel_Rackets_SA.length == 0) {
   					commonByteArray_PI_PADEL_SA_SA_Load_Padel_Rackets_SA = new byte[1024];
				} else {
   					commonByteArray_PI_PADEL_SA_SA_Load_Padel_Rackets_SA = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PI_PADEL_SA_SA_Load_Padel_Rackets_SA, 0, length);
			strReturn = new String(commonByteArray_PI_PADEL_SA_SA_Load_Padel_Rackets_SA, 0, length, utf8Charset);
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
			if(length > commonByteArray_PI_PADEL_SA_SA_Load_Padel_Rackets_SA.length) {
				if(length < 1024 && commonByteArray_PI_PADEL_SA_SA_Load_Padel_Rackets_SA.length == 0) {
   					commonByteArray_PI_PADEL_SA_SA_Load_Padel_Rackets_SA = new byte[1024];
				} else {
   					commonByteArray_PI_PADEL_SA_SA_Load_Padel_Rackets_SA = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PI_PADEL_SA_SA_Load_Padel_Rackets_SA, 0, length);
			strReturn = new String(commonByteArray_PI_PADEL_SA_SA_Load_Padel_Rackets_SA, 0, length, utf8Charset);
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

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PI_PADEL_SA_SA_Load_Padel_Rackets_SA) {

        	try {

        		int length = 0;
		
					this.title = readString(dis);
					
					this.handle = readString(dis);
					
					this.vendor = readString(dis);
					
					this.product_type = readString(dis);
					
					this.tags = readString(dis);
					
					this.created_at = readString(dis);
					
					this.price = readString(dis);
					
					this.sku = readString(dis);
					
					this.image = readString(dis);
					
					this.weight = readString(dis);
					
					this.shape = readString(dis);
					
					this.foam = readString(dis);
					
					this.collection = readString(dis);
					
					this.game_level = readString(dis);
					
					this.frame = readString(dis);
					
					this.surface = readString(dis);
					
					this.professional_player = readString(dis);
					
					this.color = readString(dis);
					
					this.racket_type = readString(dis);
					
					this.balance = readString(dis);
					
					this.gender = readString(dis);
					
					this.racket_cover = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PI_PADEL_SA_SA_Load_Padel_Rackets_SA) {

        	try {

        		int length = 0;
		
					this.title = readString(dis);
					
					this.handle = readString(dis);
					
					this.vendor = readString(dis);
					
					this.product_type = readString(dis);
					
					this.tags = readString(dis);
					
					this.created_at = readString(dis);
					
					this.price = readString(dis);
					
					this.sku = readString(dis);
					
					this.image = readString(dis);
					
					this.weight = readString(dis);
					
					this.shape = readString(dis);
					
					this.foam = readString(dis);
					
					this.collection = readString(dis);
					
					this.game_level = readString(dis);
					
					this.frame = readString(dis);
					
					this.surface = readString(dis);
					
					this.professional_player = readString(dis);
					
					this.color = readString(dis);
					
					this.racket_type = readString(dis);
					
					this.balance = readString(dis);
					
					this.gender = readString(dis);
					
					this.racket_cover = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.title,dos);
					
					// String
				
						writeString(this.handle,dos);
					
					// String
				
						writeString(this.vendor,dos);
					
					// String
				
						writeString(this.product_type,dos);
					
					// String
				
						writeString(this.tags,dos);
					
					// String
				
						writeString(this.created_at,dos);
					
					// String
				
						writeString(this.price,dos);
					
					// String
				
						writeString(this.sku,dos);
					
					// String
				
						writeString(this.image,dos);
					
					// String
				
						writeString(this.weight,dos);
					
					// String
				
						writeString(this.shape,dos);
					
					// String
				
						writeString(this.foam,dos);
					
					// String
				
						writeString(this.collection,dos);
					
					// String
				
						writeString(this.game_level,dos);
					
					// String
				
						writeString(this.frame,dos);
					
					// String
				
						writeString(this.surface,dos);
					
					// String
				
						writeString(this.professional_player,dos);
					
					// String
				
						writeString(this.color,dos);
					
					// String
				
						writeString(this.racket_type,dos);
					
					// String
				
						writeString(this.balance,dos);
					
					// String
				
						writeString(this.gender,dos);
					
					// String
				
						writeString(this.racket_cover,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.title,dos);
					
					// String
				
						writeString(this.handle,dos);
					
					// String
				
						writeString(this.vendor,dos);
					
					// String
				
						writeString(this.product_type,dos);
					
					// String
				
						writeString(this.tags,dos);
					
					// String
				
						writeString(this.created_at,dos);
					
					// String
				
						writeString(this.price,dos);
					
					// String
				
						writeString(this.sku,dos);
					
					// String
				
						writeString(this.image,dos);
					
					// String
				
						writeString(this.weight,dos);
					
					// String
				
						writeString(this.shape,dos);
					
					// String
				
						writeString(this.foam,dos);
					
					// String
				
						writeString(this.collection,dos);
					
					// String
				
						writeString(this.game_level,dos);
					
					// String
				
						writeString(this.frame,dos);
					
					// String
				
						writeString(this.surface,dos);
					
					// String
				
						writeString(this.professional_player,dos);
					
					// String
				
						writeString(this.color,dos);
					
					// String
				
						writeString(this.racket_type,dos);
					
					// String
				
						writeString(this.balance,dos);
					
					// String
				
						writeString(this.gender,dos);
					
					// String
				
						writeString(this.racket_cover,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("title="+title);
		sb.append(",handle="+handle);
		sb.append(",vendor="+vendor);
		sb.append(",product_type="+product_type);
		sb.append(",tags="+tags);
		sb.append(",created_at="+created_at);
		sb.append(",price="+price);
		sb.append(",sku="+sku);
		sb.append(",image="+image);
		sb.append(",weight="+weight);
		sb.append(",shape="+shape);
		sb.append(",foam="+foam);
		sb.append(",collection="+collection);
		sb.append(",game_level="+game_level);
		sb.append(",frame="+frame);
		sb.append(",surface="+surface);
		sb.append(",professional_player="+professional_player);
		sb.append(",color="+color);
		sb.append(",racket_type="+racket_type);
		sb.append(",balance="+balance);
		sb.append(",gender="+gender);
		sb.append(",racket_cover="+racket_cover);
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




	
	/**
	 * [tDBOutput_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBOutput_2", false);
		start_Hash.put("tDBOutput_2", System.currentTimeMillis());
		
	
	currentComponent="tDBOutput_2";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row1");
					}
				
		int tos_count_tDBOutput_2 = 0;
		





String dbschema_tDBOutput_2 = null;
	dbschema_tDBOutput_2 = "sa";
	

String tableName_tDBOutput_2 = null;
if(dbschema_tDBOutput_2 == null || dbschema_tDBOutput_2.trim().length() == 0) {
	tableName_tDBOutput_2 = ("sa_padel_rackets");
} else {
	tableName_tDBOutput_2 = dbschema_tDBOutput_2 + "\".\"" + ("sa_padel_rackets");
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
 
	final String decryptedPassword_tDBOutput_2 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:A3n5l8pHwwSY87vTjATXOLsXw3XlnbF6n3h2rhP45+zlNSvt8Q==");

    String dbPwd_tDBOutput_2 = decryptedPassword_tDBOutput_2;

    conn_tDBOutput_2 = java.sql.DriverManager.getConnection(url_tDBOutput_2,dbUser_tDBOutput_2,dbPwd_tDBOutput_2);
	
	resourceMap.put("conn_tDBOutput_2", conn_tDBOutput_2);
        conn_tDBOutput_2.setAutoCommit(false);
        int commitEvery_tDBOutput_2 = 10000;
        int commitCounter_tDBOutput_2 = 0;


   int batchSize_tDBOutput_2 = 10000;
   int batchSizeCounter_tDBOutput_2=0;

int count_tDBOutput_2=0;
	    String insert_tDBOutput_2 = "INSERT INTO \"" + tableName_tDBOutput_2 + "\" (\"title\",\"handle\",\"vendor\",\"product_type\",\"tags\",\"created_at\",\"price\",\"sku\",\"image\",\"weight\",\"shape\",\"foam\",\"collection\",\"game_level\",\"frame\",\"surface\",\"professional_player\",\"color\",\"racket_type\",\"balance\",\"gender\",\"racket_cover\") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	    
	    java.sql.PreparedStatement pstmt_tDBOutput_2 = conn_tDBOutput_2.prepareStatement(insert_tDBOutput_2);
	    resourceMap.put("pstmt_tDBOutput_2", pstmt_tDBOutput_2);
	    

 



/**
 * [tDBOutput_2 begin ] stop
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
				int footer_tFileInputDelimited_1 = 0;
				int totalLinetFileInputDelimited_1 = 0;
				int limittFileInputDelimited_1 = -1;
				int lastLinetFileInputDelimited_1 = -1;	
				
				char fieldSeparator_tFileInputDelimited_1[] = null;
				
				//support passing value (property: Field Separator) by 'context.fs' or 'globalMap.get("fs")'. 
				if ( ((String)",").length() > 0 ){
					fieldSeparator_tFileInputDelimited_1 = ((String)",").toCharArray();
				}else {			
					throw new IllegalArgumentException("Field Separator must be assigned a char."); 
				}
			
				char rowSeparator_tFileInputDelimited_1[] = null;
			
				//support passing value (property: Row Separator) by 'context.rs' or 'globalMap.get("rs")'. 
				if ( ((String)"\n").length() > 0 ){
					rowSeparator_tFileInputDelimited_1 = ((String)"\n").toCharArray();
				}else {
					throw new IllegalArgumentException("Row Separator must be assigned a char."); 
				}
			
				Object filename_tFileInputDelimited_1 = /** Start field tFileInputDelimited_1:FILENAME */"C:/Users/ASUS/Downloads/Sports/Sports/padel_rackets.csv"/** End field tFileInputDelimited_1:FILENAME */;		
				com.talend.csv.CSVReader csvReadertFileInputDelimited_1 = null;
	
				try{
					
						String[] rowtFileInputDelimited_1=null;
						int currentLinetFileInputDelimited_1 = 0;
	        			int outputLinetFileInputDelimited_1 = 0;
						try {//TD110 begin
							if(filename_tFileInputDelimited_1 instanceof java.io.InputStream){
							
			int footer_value_tFileInputDelimited_1 = 0;
			if(footer_value_tFileInputDelimited_1 > 0){
				throw new java.lang.Exception("When the input source is a stream,footer shouldn't be bigger than 0.");
			}
		
								csvReadertFileInputDelimited_1=new com.talend.csv.CSVReader((java.io.InputStream)filename_tFileInputDelimited_1, fieldSeparator_tFileInputDelimited_1[0], "ISO-8859-15");
							}else{
								csvReadertFileInputDelimited_1=new com.talend.csv.CSVReader(String.valueOf(filename_tFileInputDelimited_1),fieldSeparator_tFileInputDelimited_1[0], "ISO-8859-15");
		        			}
					
					
					csvReadertFileInputDelimited_1.setTrimWhitespace(false);
					if ( (rowSeparator_tFileInputDelimited_1[0] != '\n') && (rowSeparator_tFileInputDelimited_1[0] != '\r') )
	        			csvReadertFileInputDelimited_1.setLineEnd(""+rowSeparator_tFileInputDelimited_1[0]);
						
	        				csvReadertFileInputDelimited_1.setQuoteChar('"');
						
	            				csvReadertFileInputDelimited_1.setEscapeChar(csvReadertFileInputDelimited_1.getQuoteChar());
							      
		
			
						if(footer_tFileInputDelimited_1 > 0){
						for(totalLinetFileInputDelimited_1=0;totalLinetFileInputDelimited_1 < 1; totalLinetFileInputDelimited_1++){
							csvReadertFileInputDelimited_1.readNext();
						}
						csvReadertFileInputDelimited_1.setSkipEmptyRecords(true);
			            while (csvReadertFileInputDelimited_1.readNext()) {
							
								rowtFileInputDelimited_1=csvReadertFileInputDelimited_1.getValues();
								if(!(rowtFileInputDelimited_1.length == 1 && ("\015").equals(rowtFileInputDelimited_1[0]))){//empty line when row separator is '\n'
							
	                
	                		totalLinetFileInputDelimited_1++;
	                
							
								}
							
	                
			            }
	            		int lastLineTemptFileInputDelimited_1 = totalLinetFileInputDelimited_1 - footer_tFileInputDelimited_1   < 0? 0 : totalLinetFileInputDelimited_1 - footer_tFileInputDelimited_1 ;
	            		if(lastLinetFileInputDelimited_1 > 0){
	                		lastLinetFileInputDelimited_1 = lastLinetFileInputDelimited_1 < lastLineTemptFileInputDelimited_1 ? lastLinetFileInputDelimited_1 : lastLineTemptFileInputDelimited_1; 
	            		}else {
	                		lastLinetFileInputDelimited_1 = lastLineTemptFileInputDelimited_1;
	            		}
	         
			          	csvReadertFileInputDelimited_1.close();
				        if(filename_tFileInputDelimited_1 instanceof java.io.InputStream){
				 			csvReadertFileInputDelimited_1=new com.talend.csv.CSVReader((java.io.InputStream)filename_tFileInputDelimited_1, fieldSeparator_tFileInputDelimited_1[0], "ISO-8859-15");
		        		}else{
							csvReadertFileInputDelimited_1=new com.talend.csv.CSVReader(String.valueOf(filename_tFileInputDelimited_1),fieldSeparator_tFileInputDelimited_1[0], "ISO-8859-15");
						}
						csvReadertFileInputDelimited_1.setTrimWhitespace(false);
						if ( (rowSeparator_tFileInputDelimited_1[0] != '\n') && (rowSeparator_tFileInputDelimited_1[0] != '\r') )	
	        				csvReadertFileInputDelimited_1.setLineEnd(""+rowSeparator_tFileInputDelimited_1[0]);
						
							csvReadertFileInputDelimited_1.setQuoteChar('"');
						
	        				csvReadertFileInputDelimited_1.setEscapeChar(csvReadertFileInputDelimited_1.getQuoteChar());
							  
	        		}
	        
			        if(limittFileInputDelimited_1 != 0){
			        	for(currentLinetFileInputDelimited_1=0;currentLinetFileInputDelimited_1 < 1;currentLinetFileInputDelimited_1++){
			        		csvReadertFileInputDelimited_1.readNext();
			        	}
			        }
			        csvReadertFileInputDelimited_1.setSkipEmptyRecords(true);
	        
	    		} catch(java.lang.Exception e) {
globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE",e.getMessage());
					
						
						System.err.println(e.getMessage());
					
	    		}//TD110 end
	        
			    
	        	while ( limittFileInputDelimited_1 != 0 && csvReadertFileInputDelimited_1!=null && csvReadertFileInputDelimited_1.readNext() ) { 
	        		rowstate_tFileInputDelimited_1.reset();
	        
		        	rowtFileInputDelimited_1=csvReadertFileInputDelimited_1.getValues();
		        	
					
	        			if(rowtFileInputDelimited_1.length == 1 && ("\015").equals(rowtFileInputDelimited_1[0])){//empty line when row separator is '\n'
	        				continue;
	        			}
					
	        	
	        	
	        		currentLinetFileInputDelimited_1++;
	            
		            if(lastLinetFileInputDelimited_1 > -1 && currentLinetFileInputDelimited_1 > lastLinetFileInputDelimited_1) {
		                break;
	    	        }
	        	    outputLinetFileInputDelimited_1++;
	            	if (limittFileInputDelimited_1 > 0 && outputLinetFileInputDelimited_1 > limittFileInputDelimited_1) {
	                	break;
	            	}  
	                                                                      
					
	    							row1 = null;			
								
								boolean whetherReject_tFileInputDelimited_1 = false;
								row1 = new row1Struct();
								try {			
									
				char fieldSeparator_tFileInputDelimited_1_ListType[] = null;
				//support passing value (property: Field Separator) by 'context.fs' or 'globalMap.get("fs")'. 
				if ( ((String)",").length() > 0 ){
					fieldSeparator_tFileInputDelimited_1_ListType = ((String)",").toCharArray();
				}else {			
					throw new IllegalArgumentException("Field Separator must be assigned a char."); 
				}
				if(rowtFileInputDelimited_1.length == 1 && ("\015").equals(rowtFileInputDelimited_1[0])){//empty line when row separator is '\n'
					
							row1.title = null;
					
							row1.handle = null;
					
							row1.vendor = null;
					
							row1.product_type = null;
					
							row1.tags = null;
					
							row1.created_at = null;
					
							row1.price = null;
					
							row1.sku = null;
					
							row1.image = null;
					
							row1.weight = null;
					
							row1.shape = null;
					
							row1.foam = null;
					
							row1.collection = null;
					
							row1.game_level = null;
					
							row1.frame = null;
					
							row1.surface = null;
					
							row1.professional_player = null;
					
							row1.color = null;
					
							row1.racket_type = null;
					
							row1.balance = null;
					
							row1.gender = null;
					
							row1.racket_cover = null;
					
				}else{
					
	                int columnIndexWithD_tFileInputDelimited_1 = 0; //Column Index 
	                
						columnIndexWithD_tFileInputDelimited_1 = 0;
						
						
						
						if(columnIndexWithD_tFileInputDelimited_1 < rowtFileInputDelimited_1.length){
						
						
							
									row1.title = rowtFileInputDelimited_1[columnIndexWithD_tFileInputDelimited_1];
									
							
						
						}else{
						
							
								row1.title = null;
							
						
						}
						
						
					
						columnIndexWithD_tFileInputDelimited_1 = 1;
						
						
						
						if(columnIndexWithD_tFileInputDelimited_1 < rowtFileInputDelimited_1.length){
						
						
							
									row1.handle = rowtFileInputDelimited_1[columnIndexWithD_tFileInputDelimited_1];
									
							
						
						}else{
						
							
								row1.handle = null;
							
						
						}
						
						
					
						columnIndexWithD_tFileInputDelimited_1 = 2;
						
						
						
						if(columnIndexWithD_tFileInputDelimited_1 < rowtFileInputDelimited_1.length){
						
						
							
									row1.vendor = rowtFileInputDelimited_1[columnIndexWithD_tFileInputDelimited_1];
									
							
						
						}else{
						
							
								row1.vendor = null;
							
						
						}
						
						
					
						columnIndexWithD_tFileInputDelimited_1 = 3;
						
						
						
						if(columnIndexWithD_tFileInputDelimited_1 < rowtFileInputDelimited_1.length){
						
						
							
									row1.product_type = rowtFileInputDelimited_1[columnIndexWithD_tFileInputDelimited_1];
									
							
						
						}else{
						
							
								row1.product_type = null;
							
						
						}
						
						
					
						columnIndexWithD_tFileInputDelimited_1 = 4;
						
						
						
						if(columnIndexWithD_tFileInputDelimited_1 < rowtFileInputDelimited_1.length){
						
						
							
									row1.tags = rowtFileInputDelimited_1[columnIndexWithD_tFileInputDelimited_1];
									
							
						
						}else{
						
							
								row1.tags = null;
							
						
						}
						
						
					
						columnIndexWithD_tFileInputDelimited_1 = 5;
						
						
						
						if(columnIndexWithD_tFileInputDelimited_1 < rowtFileInputDelimited_1.length){
						
						
							
									row1.created_at = rowtFileInputDelimited_1[columnIndexWithD_tFileInputDelimited_1];
									
							
						
						}else{
						
							
								row1.created_at = null;
							
						
						}
						
						
					
						columnIndexWithD_tFileInputDelimited_1 = 6;
						
						
						
						if(columnIndexWithD_tFileInputDelimited_1 < rowtFileInputDelimited_1.length){
						
						
							
									row1.price = rowtFileInputDelimited_1[columnIndexWithD_tFileInputDelimited_1];
									
							
						
						}else{
						
							
								row1.price = null;
							
						
						}
						
						
					
						columnIndexWithD_tFileInputDelimited_1 = 7;
						
						
						
						if(columnIndexWithD_tFileInputDelimited_1 < rowtFileInputDelimited_1.length){
						
						
							
									row1.sku = rowtFileInputDelimited_1[columnIndexWithD_tFileInputDelimited_1];
									
							
						
						}else{
						
							
								row1.sku = null;
							
						
						}
						
						
					
						columnIndexWithD_tFileInputDelimited_1 = 8;
						
						
						
						if(columnIndexWithD_tFileInputDelimited_1 < rowtFileInputDelimited_1.length){
						
						
							
									row1.image = rowtFileInputDelimited_1[columnIndexWithD_tFileInputDelimited_1];
									
							
						
						}else{
						
							
								row1.image = null;
							
						
						}
						
						
					
						columnIndexWithD_tFileInputDelimited_1 = 9;
						
						
						
						if(columnIndexWithD_tFileInputDelimited_1 < rowtFileInputDelimited_1.length){
						
						
							
									row1.weight = rowtFileInputDelimited_1[columnIndexWithD_tFileInputDelimited_1];
									
							
						
						}else{
						
							
								row1.weight = null;
							
						
						}
						
						
					
						columnIndexWithD_tFileInputDelimited_1 = 10;
						
						
						
						if(columnIndexWithD_tFileInputDelimited_1 < rowtFileInputDelimited_1.length){
						
						
							
									row1.shape = rowtFileInputDelimited_1[columnIndexWithD_tFileInputDelimited_1];
									
							
						
						}else{
						
							
								row1.shape = null;
							
						
						}
						
						
					
						columnIndexWithD_tFileInputDelimited_1 = 11;
						
						
						
						if(columnIndexWithD_tFileInputDelimited_1 < rowtFileInputDelimited_1.length){
						
						
							
									row1.foam = rowtFileInputDelimited_1[columnIndexWithD_tFileInputDelimited_1];
									
							
						
						}else{
						
							
								row1.foam = null;
							
						
						}
						
						
					
						columnIndexWithD_tFileInputDelimited_1 = 12;
						
						
						
						if(columnIndexWithD_tFileInputDelimited_1 < rowtFileInputDelimited_1.length){
						
						
							
									row1.collection = rowtFileInputDelimited_1[columnIndexWithD_tFileInputDelimited_1];
									
							
						
						}else{
						
							
								row1.collection = null;
							
						
						}
						
						
					
						columnIndexWithD_tFileInputDelimited_1 = 13;
						
						
						
						if(columnIndexWithD_tFileInputDelimited_1 < rowtFileInputDelimited_1.length){
						
						
							
									row1.game_level = rowtFileInputDelimited_1[columnIndexWithD_tFileInputDelimited_1];
									
							
						
						}else{
						
							
								row1.game_level = null;
							
						
						}
						
						
					
						columnIndexWithD_tFileInputDelimited_1 = 14;
						
						
						
						if(columnIndexWithD_tFileInputDelimited_1 < rowtFileInputDelimited_1.length){
						
						
							
									row1.frame = rowtFileInputDelimited_1[columnIndexWithD_tFileInputDelimited_1];
									
							
						
						}else{
						
							
								row1.frame = null;
							
						
						}
						
						
					
						columnIndexWithD_tFileInputDelimited_1 = 15;
						
						
						
						if(columnIndexWithD_tFileInputDelimited_1 < rowtFileInputDelimited_1.length){
						
						
							
									row1.surface = rowtFileInputDelimited_1[columnIndexWithD_tFileInputDelimited_1];
									
							
						
						}else{
						
							
								row1.surface = null;
							
						
						}
						
						
					
						columnIndexWithD_tFileInputDelimited_1 = 16;
						
						
						
						if(columnIndexWithD_tFileInputDelimited_1 < rowtFileInputDelimited_1.length){
						
						
							
									row1.professional_player = rowtFileInputDelimited_1[columnIndexWithD_tFileInputDelimited_1];
									
							
						
						}else{
						
							
								row1.professional_player = null;
							
						
						}
						
						
					
						columnIndexWithD_tFileInputDelimited_1 = 17;
						
						
						
						if(columnIndexWithD_tFileInputDelimited_1 < rowtFileInputDelimited_1.length){
						
						
							
									row1.color = rowtFileInputDelimited_1[columnIndexWithD_tFileInputDelimited_1];
									
							
						
						}else{
						
							
								row1.color = null;
							
						
						}
						
						
					
						columnIndexWithD_tFileInputDelimited_1 = 18;
						
						
						
						if(columnIndexWithD_tFileInputDelimited_1 < rowtFileInputDelimited_1.length){
						
						
							
									row1.racket_type = rowtFileInputDelimited_1[columnIndexWithD_tFileInputDelimited_1];
									
							
						
						}else{
						
							
								row1.racket_type = null;
							
						
						}
						
						
					
						columnIndexWithD_tFileInputDelimited_1 = 19;
						
						
						
						if(columnIndexWithD_tFileInputDelimited_1 < rowtFileInputDelimited_1.length){
						
						
							
									row1.balance = rowtFileInputDelimited_1[columnIndexWithD_tFileInputDelimited_1];
									
							
						
						}else{
						
							
								row1.balance = null;
							
						
						}
						
						
					
						columnIndexWithD_tFileInputDelimited_1 = 20;
						
						
						
						if(columnIndexWithD_tFileInputDelimited_1 < rowtFileInputDelimited_1.length){
						
						
							
									row1.gender = rowtFileInputDelimited_1[columnIndexWithD_tFileInputDelimited_1];
									
							
						
						}else{
						
							
								row1.gender = null;
							
						
						}
						
						
					
						columnIndexWithD_tFileInputDelimited_1 = 21;
						
						
						
						if(columnIndexWithD_tFileInputDelimited_1 < rowtFileInputDelimited_1.length){
						
						
							
									row1.racket_cover = rowtFileInputDelimited_1[columnIndexWithD_tFileInputDelimited_1];
									
							
						
						}else{
						
							
								row1.racket_cover = null;
							
						
						}
						
						
					
				}
				
									
									if(rowstate_tFileInputDelimited_1.getException()!=null) {
										throw rowstate_tFileInputDelimited_1.getException();
									}
									
									
	    						} catch (java.lang.Exception e) {
globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE",e.getMessage());
							        whetherReject_tFileInputDelimited_1 = true;
        							
                							System.err.println(e.getMessage());
                							row1 = null;
                						
            							globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE", e.getMessage());
            							
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
	 * [tDBOutput_2 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row1"
						
						);
					}
					



        whetherReject_tDBOutput_2 = false;
                    if(row1.title == null) {
pstmt_tDBOutput_2.setNull(1, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(1, row1.title);
}

                    if(row1.handle == null) {
pstmt_tDBOutput_2.setNull(2, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(2, row1.handle);
}

                    if(row1.vendor == null) {
pstmt_tDBOutput_2.setNull(3, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(3, row1.vendor);
}

                    if(row1.product_type == null) {
pstmt_tDBOutput_2.setNull(4, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(4, row1.product_type);
}

                    if(row1.tags == null) {
pstmt_tDBOutput_2.setNull(5, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(5, row1.tags);
}

                    if(row1.created_at == null) {
pstmt_tDBOutput_2.setNull(6, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(6, row1.created_at);
}

                    if(row1.price == null) {
pstmt_tDBOutput_2.setNull(7, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(7, row1.price);
}

                    if(row1.sku == null) {
pstmt_tDBOutput_2.setNull(8, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(8, row1.sku);
}

                    if(row1.image == null) {
pstmt_tDBOutput_2.setNull(9, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(9, row1.image);
}

                    if(row1.weight == null) {
pstmt_tDBOutput_2.setNull(10, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(10, row1.weight);
}

                    if(row1.shape == null) {
pstmt_tDBOutput_2.setNull(11, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(11, row1.shape);
}

                    if(row1.foam == null) {
pstmt_tDBOutput_2.setNull(12, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(12, row1.foam);
}

                    if(row1.collection == null) {
pstmt_tDBOutput_2.setNull(13, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(13, row1.collection);
}

                    if(row1.game_level == null) {
pstmt_tDBOutput_2.setNull(14, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(14, row1.game_level);
}

                    if(row1.frame == null) {
pstmt_tDBOutput_2.setNull(15, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(15, row1.frame);
}

                    if(row1.surface == null) {
pstmt_tDBOutput_2.setNull(16, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(16, row1.surface);
}

                    if(row1.professional_player == null) {
pstmt_tDBOutput_2.setNull(17, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(17, row1.professional_player);
}

                    if(row1.color == null) {
pstmt_tDBOutput_2.setNull(18, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(18, row1.color);
}

                    if(row1.racket_type == null) {
pstmt_tDBOutput_2.setNull(19, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(19, row1.racket_type);
}

                    if(row1.balance == null) {
pstmt_tDBOutput_2.setNull(20, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(20, row1.balance);
}

                    if(row1.gender == null) {
pstmt_tDBOutput_2.setNull(21, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(21, row1.gender);
}

                    if(row1.racket_cover == null) {
pstmt_tDBOutput_2.setNull(22, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(22, row1.racket_cover);
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

	


				nb_line_tFileInputDelimited_1++;
			}
			
			}finally{
    			if(!(filename_tFileInputDelimited_1 instanceof java.io.InputStream)){
    				if(csvReadertFileInputDelimited_1!=null){
    					csvReadertFileInputDelimited_1.close();
    				}
    			}
    			if(csvReadertFileInputDelimited_1!=null){
    				globalMap.put("tFileInputDelimited_1_NB_LINE",nb_line_tFileInputDelimited_1);
    			}
				
			}
						  

 

ok_Hash.put("tFileInputDelimited_1", true);
end_Hash.put("tFileInputDelimited_1", System.currentTimeMillis());




/**
 * [tFileInputDelimited_1 end ] stop
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
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row1");
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
	 * [tFileInputDelimited_1 finally ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_1";

	

 



/**
 * [tFileInputDelimited_1 finally ] stop
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
		

		globalMap.put("tFileInputDelimited_1_SUBPROCESS_STATE", 1);
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
        final SA_Load_Padel_Rackets_SA SA_Load_Padel_Rackets_SAClass = new SA_Load_Padel_Rackets_SA();

        int exitCode = SA_Load_Padel_Rackets_SAClass.runJobInTOS(args);

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
            java.io.InputStream inContext = SA_Load_Padel_Rackets_SA.class.getClassLoader().getResourceAsStream("pi_padel_sa/sa_load_padel_rackets_sa_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = SA_Load_Padel_Rackets_SA.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
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

this.globalResumeTicket = true;//to run tPostJob




        end = System.currentTimeMillis();

        if (watch) {
            System.out.println((end-startTime)+" milliseconds");
        }

        endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        if (false) {
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : SA_Load_Padel_Rackets_SA");
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
 *     74341 characters generated by Talend Open Studio for Data Integration 
 *     on the 2 mars 2026, 22:33:37 WAT
 ************************************************************************************************/