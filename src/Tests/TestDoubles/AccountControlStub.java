package Tests.TestDoubles;


import java.util.ArrayList;
import Model.AccountProfile;
import Model.Authentication;
import View.AccountProfileView;
import View.AuthenticationView;
import View.GoalCollectionView;
import View.HealthMeasurementCollectionView;
import View.MeasurementTypeCollectionView;
import Control.AccountControl;
import Control.AccountProfileControl;
import Control.AuthenticationControl;
import Control.GoalCollectionControl;
import Control.GoalControl;
import Control.HealthMeasurementCollectionControl;
import Control.HealthMeasurementControl;
import Control.MeasurementTypeCollectionControl;
import Control.MeasurementTypeControl;

public class AccountControlStub extends AccountControl {

	public AccountControlStub(){
		authenticationControl = new AuthenticationControl(new Authentication("Vaul"), new AuthenticationView(), new AuthenticationCommunicatorStub()); 
		accountProfileControl = new AccountProfileControl(new AccountProfile(), new AccountProfileView(), new AccountProfileDataCommunicatorStub()); 
		goalCollectionControl = new GoalCollectionControl(new ArrayList<GoalControl>(), new GoalCollectionView(), new GoalDataCommunicatorStub()); 
		healthCollectionControl = new HealthMeasurementCollectionControl(new ArrayList<HealthMeasurementControl>(), 
				new HealthMeasurementCollectionView(), 
				new HealthMeasurementsDataCommunicatorStub()); 
		typeCollectionControl = new MeasurementTypeCollectionControl(
				new ArrayList<MeasurementTypeControl>(), 
				new MeasurementTypeCollectionView(), 
				new MeasurementTypeDataCommunicatorStub());
	}

}
