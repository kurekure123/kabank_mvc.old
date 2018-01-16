package com.kabank.mvc.enums;

public enum DMLEnum {
	COUNT{
		 @Override
		public String toString() {
			 
		return "SELECT COUNT(*) AS count FROM";
		}
	},
	
	SELECT{
		@Override
		public String toString() {

			return "SELECT FROM";
		}
	},
	
	INSERT{
		@Override
		public String toString() {
			return "INSERT INTO VALUES";
		}
	},
	
	SELECT_ID_PASS{
		@Override
		public String toString() {
			return "SELECT * FROM Member WHERE id = '%s' AND pass = '%s'";
		}
	},
	UPDATE_PASSWORD{
		@Override
		public String toString() {
			return "UPDATE Member SET pass = '@' WHERE id = '$'" ;
		}
	},
	DELETE_ID{
		@Override
		public String toString() {
			return "DELETE FROM Member WHERE id = '$' ";
		}
	}
}
