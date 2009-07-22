// DO NOT EDIT.  Make changes to Voting.java instead.
package your.app.gwt.eo;
// this must be in the client package

import java.util.*;
import java.math.BigDecimal;

import wogwt.translatable.WOGWTClientUtil;

import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;

// This class can be serialized from server to client and back
@SuppressWarnings("all")
public abstract class _Voting 
	extends com.webobjects.eocontrol.EOGenericRecord 
	implements wogwt.translatable.rpc.WOGWTSerializableEO {
		
	public static final transient String ENTITY_NAME = "Voting";
	public static final transient String NUMBER_OF_VOTES_KEY = "numberOfVotes";
	public static final transient String RUNNING_AVERAGE_KEY = "runningAverage";
	public static final transient String MOVIE_KEY = "movie";
	
	/* these fields are defined for serialization and to hold data on the client side;
	   can't use a plain Map because all the types must be explicit for optimal code */
	private Integer _numberOfVotes;
	private Double _runningAverage;
	private your.app.gwt.eo.Movie _movie;

	public _Voting() {
		super();
	}
	
	// Attributes
	public Integer numberOfVotes() {
		return (Integer) storedValueForKey("numberOfVotes");
	}

	public void setNumberOfVotes(Integer value) {
		takeStoredValueForKey(value, "numberOfVotes");
	}
	
	public Double runningAverage() {
		return (Double) storedValueForKey("runningAverage");
	}

	public void setRunningAverage(Double value) {
		takeStoredValueForKey(value, "runningAverage");
	}
	
	public your.app.gwt.eo.Movie movie() {
		return (your.app.gwt.eo.Movie)storedValueForKey("movie");
	}
  
	public void setMovieRelationship(your.app.gwt.eo.Movie value) {
		if (value == null) {
			your.app.gwt.eo.Movie oldValue = movie();
			if (oldValue != null) {
				removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "movie");
			}
		} else {
			addObjectToBothSidesOfRelationshipWithKey(value, "movie");
		}
	}
  
	@Override
	public NSArray<String> attributeKeys() {
		NSArray<String> result = super.attributeKeys();
		if (result != null)
			return result;

		NSArray<String> keys = new NSArray<String>( new String[] {
			"numberOfVotes",			
			"runningAverage"			
		});
		return keys;
	}
	
	@Override
	public NSArray<String> toOneRelationshipKeys() {
		NSArray<String> result = super.toOneRelationshipKeys();
		if (result != null)
			return result;
		
		NSArray<String> keys = new NSArray<String>( new String[] {	
			"movie"			
		});
		
		return keys;
	}
	
	@Override
	public NSArray<String> toManyRelationshipKeys() {
		NSArray<String> result = super.toManyRelationshipKeys();
		if (result != null)
			return result;
		
		NSArray<String> keys = new NSArray<String>( new String[] {
		});
		
    	return keys;
	}
	
	public int deleteRuleNumber(String deleteRuleName) {
		if ("EODeleteRuleNullify".equals(deleteRuleName)) {
			return 0;
		} else if ("EODeleteRuleCascade".equals(deleteRuleName)) {
			return 1;
		} else if ("EODeleteRuleDeny".equals(deleteRuleName)) {
			return 2;
		} else if ("EODeleteRuleNoAction".equals(deleteRuleName)) {
			return 3;
		} else {
			return -1;
		}
	}
	
	@Override
	public int deleteRuleForRelationshipKey(String relationshipKey) {
		int result = super.deleteRuleForRelationshipKey(relationshipKey);
		if (result != -1)
			return result;
		
		if ("movie".equals(relationshipKey))
			return deleteRuleNumber("EODeleteRuleNullify");

		return result;
	}
	
	@Override
	public String inverseForRelationshipKey(String relationshipKey) {
		String result = super.inverseForRelationshipKey(relationshipKey);
		if (result != null)
			return result;
		

		return null;
	}
	
	@Override
	public boolean isReadOnly() {
		return false;
	}
	
	@Override
	public boolean ownsDestinationObjectsForRelationshipKey(String relationshipKey) {
		try {
			return super.ownsDestinationObjectsForRelationshipKey(relationshipKey);
		} catch (UnsupportedOperationException e) {
			return false;
		}
	}
	
	@Override
	public Object valueForKey(String key) {
		try {
			return super.valueForKey(key);
		} catch (UnsupportedOperationException e) {
			if ("entityName".equals(key))
				return entityName();
			else if ("numberOfVotes".equals(key))
				return numberOfVotes();
			else if ("runningAverage".equals(key))
				return runningAverage();
			else if ("movie".equals(key))
				return movie();
			else
				return handleQueryWithUnboundKey(key);
		}
	}
	
	@Override
	public void takeValueForKey(Object value, String key) {
		try {
			super.takeValueForKey(value, key);
		} catch (UnsupportedOperationException e) {
			if ("numberOfVotes".equals(key)) {
				setNumberOfVotes((value == null || value instanceof NSKeyValueCoding.Null) ? null : (Integer)value);
				return;
			}
			if ("runningAverage".equals(key)) {
				setRunningAverage((value == null || value instanceof NSKeyValueCoding.Null) ? null : (Double)value);
				return;
			}
			if ("movie".equals(key)) {
				setMovieRelationship((value == null || value instanceof NSKeyValueCoding.Null) ? null : (your.app.gwt.eo.Movie)value);
				return;
			}
			handleTakeValueForUnboundKey(value, key);
		}
	}
	
	@Override
	public Object storedValueForKey(String key) {
		try {
			return super.storedValueForKey(key);
		} catch (UnsupportedOperationException e) {
			if ("numberOfVotes".equals(key))
				return _numberOfVotes;
			if ("runningAverage".equals(key))
				return _runningAverage;
			if ("movie".equals(key))
				return _movie;
			return handleQueryWithUnboundKey(key);
		}
	}
	
	@Override
	public void takeStoredValueForKey(Object value, String key) {
		try {
			super.takeStoredValueForKey(value, key);
		} catch (UnsupportedOperationException e) {
			if ("numberOfVotes".equals(key)) {
				_numberOfVotes = (Integer)value;
				return;
			}
			if ("runningAverage".equals(key)) {
				_runningAverage = (Double)value;
				return;
			}
			if ("movie".equals(key)) {
				_movie = (your.app.gwt.eo.Movie)value;
				return;
			}
			handleTakeValueForUnboundKey(value, key);
		}
	}
	
	protected void includeObjectIntoPropertyWithKey(Object eo, String key) {
		try {
			super.includeObjectIntoPropertyWithKey(eo, key);
		} catch (UnsupportedOperationException e) {
		}		
	}
	
	@Override
	protected void excludeObjectFromPropertyWithKey(Object eo, String key) {
		try {
			super.excludeObjectFromPropertyWithKey(eo, key);
		} catch (UnsupportedOperationException e) {
		}
	}
	
	public Object handleQueryWithUnboundKey(String key) {
		if ("__globalID".equals(key) || "__isFault".equals(key)) {
			return null;
		} else {
			throw new NSKeyValueCoding.UnknownKeyException("Class '" + getClass().getName() + " does not have a client key named " + key, this, key);
		}	
	}
	
	public void handleTakeValueForUnboundKey(Object value, String key) {
		if ("__globalID".equals(key) || "__isFault".equals(key)) {
			return;
		} else {
			throw new NSKeyValueCoding.UnknownKeyException("Class '" + getClass().getName() + " does not have a client key named " + key, this, key);
		}
	}
	
	@Override
	public String entityName() {
		return "Voting";
	}
	
	public NSDictionary<String, Object> clientSnapshot() {
		NSDictionary<String, Object> result = new NSMutableDictionary();
		
		if (valueForKey("numberOfVotes") != null)
			result.put("numberOfVotes", valueForKey("numberOfVotes"));
		else
			result.put("numberOfVotes", NSKeyValueCoding.NullValue);

		if (valueForKey("runningAverage") != null)
			result.put("runningAverage", valueForKey("runningAverage"));
		else
			result.put("runningAverage", NSKeyValueCoding.NullValue);

		if (valueForKey("movie") != null)
			result.put("movie", valueForKey("movie"));
		else
			result.put("movie", NSKeyValueCoding.NullValue);

		return result.immutableClone();
	}
		
	public static Voting createVoting(EOEditingContext editingContext, your.app.gwt.eo.Movie movie) {
		Voting eo = (Voting) new Voting(); editingContext.insertObject(eo);    
		eo.setMovieRelationship(movie);
		return eo;
	}

	public static NSArray<Voting> fetchAllVotings(EOEditingContext editingContext) {
		return _Voting.fetchAllVotings(editingContext, null);
	}

	public static NSArray<Voting> fetchAllVotings(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
		return _Voting.fetchVotings(editingContext, null, sortOrderings);
	}

	public static NSArray<Voting> fetchVotings(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
		EOFetchSpecification fetchSpec = new EOFetchSpecification(Voting.ENTITY_NAME, qualifier, sortOrderings);
		fetchSpec.setIsDeep(true);
		NSArray<Voting> eoObjects = (NSArray<Voting>)editingContext.objectsWithFetchSpecification(fetchSpec);
		return eoObjects;
	}

	public static Voting fetchVoting(EOEditingContext editingContext, String keyName, Object value) {
		return _Voting.fetchVoting(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
	}

	public static Voting fetchVoting(EOEditingContext editingContext, EOQualifier qualifier) {
		NSArray<Voting> eoObjects = _Voting.fetchVotings(editingContext, qualifier, null);
		Voting eoObject;
		int count = eoObjects.count();
		if (count == 0) {
			eoObject = null;
		}
		else if (count == 1) {
			eoObject = (Voting)eoObjects.objectAtIndex(0);
		}
		else {
			throw new IllegalStateException("There was more than one Voting that matched the qualifier '" + qualifier + "'.");
		}
		return eoObject;
	}

	public static Voting fetchRequiredVoting(EOEditingContext editingContext, String keyName, Object value) {
		return _Voting.fetchRequiredVoting(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
	}

	public static Voting fetchRequiredVoting(EOEditingContext editingContext, EOQualifier qualifier) {
		Voting eoObject = _Voting.fetchVoting(editingContext, qualifier);
		if (eoObject == null) {
			throw new NoSuchElementException("There was no Voting that matched the qualifier '" + qualifier + "'.");
		}
		return eoObject;
	}


}
