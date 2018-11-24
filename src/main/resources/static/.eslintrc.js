module.exports = {
    "env": {
     "browser": true,
     "node": true,

   },
   "globals": {
        "echarts": true,

    },
   "rules": {
    "no-console": "off",
    "no-restricted-syntax": [
            "error",
            {
                "selector": "CallExpression[callee.name='setTimeout'][arguments.length!=2]",
                "message": "setTimeout must always be invoked with two arguments."
            }
        ]
   },
    "extends": "airbnb-base"

};
